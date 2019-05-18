package query1;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple3;
import schemas.CityWeather;

public class Query1Preprocessing {

    private static String pathToFile = "data/weather_description.csv";

    public static JavaRDD<Tuple3<String, String, Double>> preprocessDataset(JavaSparkContext sc) {

        JavaRDD<CityWeather> citiesWeather = sc.textFile(pathToFile)
                .map(line -> OutletParser.parseCSV(line))
                .filter(x -> x != null && x.getProperty().equals("1"));
        JavaRDD<Tuple3<String, String, Double>> result = citiesWeather.map(x -> new Tuple3<String, String, Double>
                (x.getHouse_id(), x.getTimestamp(), Double.parseDouble(x.getValue())));

        return result;
    }
}
