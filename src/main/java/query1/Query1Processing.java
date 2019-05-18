package query1;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import parsers.CityWeatherParser;
import scala.Tuple2;
import schemas.CityWeather;
import schemas.WeatherRecord;

public class Query1Processing {

    private static String pathToFile = "data/weather_description.csv";

    public static JavaRDD<String> preprocessDataset(JavaSparkContext sc) {

        // filter to take only row relative March, April and May
        JavaRDD<CityWeather> citiesWeatherForHour = sc.textFile(pathToFile)
                .map(line -> CityWeatherParser.parseCSV(line))
                .filter(x -> x != null && (x.getMounth().equals("03") || x.getMounth().equals("04") ||
                        x.getMounth().equals("05")));

        // Split RDD for cities
        JavaRDD<WeatherRecord> weatherRecordsForHour = citiesWeatherForHour.flatMap(citiesWeather ->
                WeatherRecord.cityWeatherToListWeatherRecords(citiesWeather).iterator());

        // (K, V) where K = "YYYY-MM-DD/city" and V = 1 if clear in that hour or 0 otherwise
        JavaPairRDD<String, Integer> clearWeatherForHourPairs = weatherRecordsForHour.mapToPair(x ->
                new Tuple2<>(x.getDatetime().split(" ")[0] + "/" + x.getCity(),
                        (x.getWeather().equals("sky is clear")) ? 1 : 0));

        // (K, V) where K = "YYYY-MM-DD/city" and V = total clear hour in that day
        JavaPairRDD<String, Integer> clearWeatherTotalHourForDayPairs =
                clearWeatherForHourPairs.reduceByKey((x, y) -> x + y);

        // A clear weather day must have at least 20 hours of clear sky
        JavaPairRDD<String, Integer> clearWeatherForDayPairs = clearWeatherTotalHourForDayPairs.mapToPair(x ->
                new Tuple2<>(x._1.split("-")[0] + x._1.split("-")[1] + "/" + x._1.split("/")[1],
                        (x._2 >= 20) ? 1 : 0));

        // (K, V) where K = "YYYY-MM/city" and V = total clear days in that mounts
        JavaPairRDD<String, Integer> clearWeatherTotalDayForMounthPairs =
                clearWeatherForDayPairs.reduceByKey((x, y) -> x + y);

        // A clear weather mounth must have at least 15 days of clear weather
        JavaPairRDD<String, Integer> clearWeatherForMounthPairs = clearWeatherTotalDayForMounthPairs.mapToPair(x ->
                new Tuple2<>(x._1.split("-")[0] + "/" + x._1.split("/")[1], (x._2 >= 15) ? 1 : 0));

        // (K, V) where K = "YYYY/city" and V = total clear mounth (mounth with at least 15 days of clear weather) in that years
        JavaPairRDD<String, Integer> clearWeatherTotalMounthForYearPairs =
                clearWeatherForMounthPairs.reduceByKey((x, y) -> x + y);

        // Filter pairs with V = 3
        JavaPairRDD<String, Integer> resultPairs = clearWeatherTotalMounthForYearPairs.filter(x -> x._2 == 3);

        //
        JavaRDD<String> result = resultPairs.map(x ->
                "city: " + x._1.split("/")[1] + "\tyear: " + x._1.split("/")[0]);

        return result;
    }
}
