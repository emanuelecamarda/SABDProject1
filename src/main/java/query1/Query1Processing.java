package query1;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import parsers.CityWeatherParser;
import scala.Tuple2;
import schemas.Query1Result;
import schemas.RowRecord;
import schemas.WeatherRecord;

public class Query1Processing {

    private static Integer n = 10;
    private static String pathToFile = "data/weather_description.csv";
    private static  Boolean printSwitch = false;

    public static JavaRDD<Query1Result> executeQuery1(JavaSparkContext sc) {

        // filter to take only row relative March, April and May
        JavaRDD<RowRecord> citiesWeatherForHour = sc.textFile(pathToFile)
                .map(line -> CityWeatherParser.parseCSV(line))
                .filter(x -> x != null && (x.getMounth().equals("03") || x.getMounth().equals("04") ||
                        x.getMounth().equals("05")));

        if (printSwitch)
            System.out.println(citiesWeatherForHour.take(n));

        // Split RDD for cities
        JavaRDD<WeatherRecord> weatherRecordsForHour = citiesWeatherForHour.flatMap(citiesWeather ->
                WeatherRecord.rowRecordToListWeatherRecords(citiesWeather).iterator());

        if (printSwitch)
            System.out.println(weatherRecordsForHour.take(n));

        // (K, V) where K = "YYYY-MM-DD/city" and V = 1 if clear in that hour or 0 otherwise
        JavaPairRDD<String, Integer> clearWeatherForHourPairs = weatherRecordsForHour.mapToPair(x ->
                new Tuple2<>(x.getDatetime().split(" ")[0] + "/" + x.getCity(),
                        (x.getWeather().equals("sky is clear")) ? 1 : 0));

        if (printSwitch)
            System.out.println(clearWeatherForHourPairs.take(n));

        // (K, V) where K = "YYYY-MM-DD/city" and V = total clear hour in that day
        JavaPairRDD<String, Integer> clearWeatherTotalHourForDayPairs =
                clearWeatherForHourPairs.reduceByKey((x, y) -> x + y);

        if (printSwitch)
            System.out.println(clearWeatherTotalHourForDayPairs.take(n));

        // A clear weather day must have at least 18 hours of clear sky
        JavaPairRDD<String, Integer> clearWeatherForDayPairs = clearWeatherTotalHourForDayPairs.mapToPair(x ->
                new Tuple2<>(x._1.split("-")[0] + "-" +  x._1.split("-")[1] + "/" + x._1.split("/")[1],
                        (x._2 >= 18) ? 1 : 0));

        if (printSwitch)
            System.out.println(clearWeatherForDayPairs.take(n));

        // (K, V) where K = "YYYY-MM/city" and V = total clear days in that mounts
        JavaPairRDD<String, Integer> clearWeatherTotalDayForMounthPairs =
                clearWeatherForDayPairs.reduceByKey((x, y) -> x + y);

        if (printSwitch)
            System.out.println(clearWeatherTotalDayForMounthPairs.take(n));

        // A clear weather mounth must have at least 15 days of clear weather
        JavaPairRDD<String, Integer> clearWeatherForMonthPairs = clearWeatherTotalDayForMounthPairs.mapToPair(x ->
                new Tuple2<>(x._1.split("-")[0] + "/" + x._1.split("/")[1], (x._2 >= 15) ? 1 : 0));

        if (printSwitch)
            System.out.println(clearWeatherForMonthPairs.take(n));

        // (K, V) where K = "YYYY/city" and V = total clear mounth (mounth with at least 15 days of clear weather) in that years
        JavaPairRDD<String, Integer> clearWeatherTotalMonthForYearPairs =
                clearWeatherForMonthPairs.reduceByKey((x, y) -> x + y);

        if (printSwitch)
            System.out.println(clearWeatherTotalMonthForYearPairs.take(n));

        // Filter pairs with V = 3
        JavaPairRDD<String, Integer> resultPairs = clearWeatherTotalMonthForYearPairs.filter(x -> x._2 == 3);

        if (printSwitch)
            System.out.println(resultPairs.take(n));

        JavaRDD<Query1Result> result = resultPairs.map(x -> new Query1Result(x._1.split("/")[1],
                x._1.split("/")[0]));

        if (printSwitch)
            System.out.println(result.take(n));

        return result;
    }
}
