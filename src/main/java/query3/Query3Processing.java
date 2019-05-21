package query3;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import parsers.CityWeatherParser;
import scala.Tuple2;
import schemas.CityExcursion;
import schemas.MeanSchema;
import schemas.RowRecord;
import schemas.TemperatureRecord;

import java.util.ArrayList;
import java.util.List;

public class Query3Processing {

    private static Integer n = 10;
    private static String pathToFile = "data/temperature.csv";
    private static  Boolean printSwitch = false;

    public static List<JavaRDD<CityExcursion>> executeQuery3(JavaSparkContext sc) {

        List<JavaRDD<CityExcursion>> result = new ArrayList<>();

        // filter to take only row relative year 2017 and 2016, with month january, february, march, april, july, june,
        // august and september and with hour between 12:00 and 15:00
        JavaRDD<RowRecord> preData = sc.textFile(pathToFile)
                .map(line -> CityWeatherParser.parseCSV(line))
                .filter(x -> x != null && (x.getYear().equals("2017") || x.getYear().equals("2016")) &&
                        ( !x.getMounth().equals("05") || !x.getMounth().equals("10") ||
                                !x.getMounth().equals("11") || !x.getMounth().equals("12")) &&
                        (x.getHour().equals("12") || x.getHour().equals("13") ||
                                x.getHour().equals("14") || x.getHour().equals("15")));

        if (printSwitch)
            System.out.println(preData.take(n));

        // Split RDD for cities
        JavaRDD<TemperatureRecord> citySplit = preData.flatMap(x ->
                TemperatureRecord.rowRecordToListTemperatureRecords(x).iterator());

        if (printSwitch)
            System.out.println(citySplit.take(n));

        // some data are corrupted, they don't have the comma in their representation (like 2016-01-01 12:00:00
        // Beersheba that have a temperature of 281875). So I need to converter this data with the hypothesis that a
        // reasonable temperature have three figures
        JavaRDD<TemperatureRecord> citySplitConverted = citySplit.map(x -> x.getTemperature() > 500 ?
                new TemperatureRecord(x.getDatetime(), x.getCity(),
                        Double.parseDouble(x.getTemperature().toString().substring(0, 3) + "." +
                                x.getTemperature().toString().substring(3, x.getTemperature().toString().length() - 2)))
                : x);

        // filter 2017 records
        JavaRDD<TemperatureRecord> temperature2017 = citySplitConverted.filter(x -> x.getYear().equals("2017"));

        if (printSwitch)
            System.out.println(temperature2017.take(n));

        // filter january, february, march and april records
        JavaRDD<TemperatureRecord> temperatureCold2017 = temperature2017.filter(x -> x.getMounth().equals("01") ||
                x.getMounth().equals("02") || x.getMounth().equals("03") || x.getMounth().equals("04"));

        if (printSwitch)
            System.out.println(temperatureCold2017.take(n));

        // map to pair (K, V) with K = city and V = MeanSchema(temperature, 1)
        JavaPairRDD<String, MeanSchema> temperatureCold2017Pairs = temperatureCold2017.mapToPair(
                x -> new Tuple2<>(x.getCity(), new MeanSchema(x.getTemperature(), 1.0)));

        if (printSwitch)
            System.out.println(temperatureCold2017Pairs.take(n));

        // calculate mean with reduceByKey
        JavaPairRDD<String, MeanSchema> temperatureCold2017mean = temperatureCold2017Pairs.reduceByKey(
                (x, y) -> MeanSchema.updateMean(x, y));

        if (printSwitch)
            System.out.println(temperatureCold2017mean.collect());

        // filter July, June, August, September records
        JavaRDD<TemperatureRecord> temperatureHot2017 = temperature2017.filter(x -> x.getMounth().equals("06") ||
                x.getMounth().equals("07") || x.getMounth().equals("08") || x.getMounth().equals("09"));

        if (printSwitch)
            System.out.println(temperatureHot2017.take(n));

        // map to pair (K, V) with K = city and V = MeanSchema(temperature, 1)
        JavaPairRDD<String, MeanSchema> temperatureHot2017Pairs = temperatureHot2017.mapToPair(
                x -> new Tuple2<>(x.getCity(), new MeanSchema(x.getTemperature(), 1.0)));

        if (printSwitch)
            System.out.println(temperatureHot2017Pairs.take(n));

        // calculate mean with reduceByKey
        JavaPairRDD<String, MeanSchema> temperatureHot2017mean = temperatureHot2017Pairs.reduceByKey(
                (x, y) -> MeanSchema.updateMean(x, y));

        if (printSwitch)
            System.out.println(temperatureHot2017mean.collect());

        // Calculate temperature excursions (pairs (city, excursions))
        JavaRDD<CityExcursion> excursions2017 = temperatureCold2017mean.union(temperatureHot2017mean)
                .reduceByKey((x, y) -> new MeanSchema(Math.abs(x.getMean() - y.getMean()), 0.0))
                .map(x -> new CityExcursion(x._1, x._2.getMean(), "2017"));

        if (printSwitch)
            System.out.println(excursions2017.collect());

        // ranking excursion USA 2017
        JavaRDD<CityExcursion> excursion2017USA = excursions2017.filter(x -> x.getState().equals("USA"))
                .sortBy(f -> f.getExcursions(), false, 1);
        result.add(excursion2017USA);

        if (printSwitch)
            System.out.println(excursion2017USA.collect());

        // ranking excursion Israel 2017
        JavaRDD<CityExcursion> excursion2017Israel = excursions2017.filter(x -> x.getState().equals("Israel"))
                .sortBy(f -> f.getExcursions(), false, 1);
        result.add(excursion2017Israel);

        if (printSwitch)
            System.out.println(excursion2017Israel.collect());




        // filter 2016 records
        JavaRDD<TemperatureRecord> temperature2016 = citySplitConverted.filter(x -> x.getYear().equals("2016"));

        if (printSwitch)
            System.out.println(temperature2016.take(n));

        // filter january, february, march and april records
        JavaRDD<TemperatureRecord> temperatureCold2016 = temperature2016.filter(x -> x.getMounth().equals("01") ||
                x.getMounth().equals("02") || x.getMounth().equals("03") || x.getMounth().equals("04"));

        if (printSwitch)
            System.out.println(temperatureCold2016.take(n));

        // map to pair (K, V) with K = city and V = MeanSchema(temperature, 1)
        JavaPairRDD<String, MeanSchema> temperatureCold2016Pairs = temperatureCold2016.mapToPair(
                x -> new Tuple2<>(x.getCity(), new MeanSchema(x.getTemperature(), 1.0)));

        if (printSwitch)
            System.out.println(temperatureCold2016Pairs.take(n));

        // calculate mean with reduceByKey
        JavaPairRDD<String, MeanSchema> temperatureCold2016mean = temperatureCold2016Pairs.reduceByKey(
                (x, y) -> MeanSchema.updateMean(x, y));

        if (printSwitch)
            System.out.println(temperatureCold2016mean.collect());

        // filter July, June, August, September records
        JavaRDD<TemperatureRecord> temperatureHot2016 = temperature2016.filter(x -> x.getMounth().equals("06") ||
                x.getMounth().equals("07") || x.getMounth().equals("08") || x.getMounth().equals("09"));

        if (printSwitch)
            System.out.println(temperatureHot2016.take(n));

        // map to pair (K, V) with K = city and V = MeanSchema(temperature, 1)
        JavaPairRDD<String, MeanSchema> temperatureHot2016Pairs = temperatureHot2016.mapToPair(
                x -> new Tuple2<>(x.getCity(), new MeanSchema(x.getTemperature(), 1.0)));

        if (printSwitch)
            System.out.println(temperatureHot2016Pairs.take(n));

        // calculate mean with reduceByKey
        JavaPairRDD<String, MeanSchema> temperatureHot2016mean = temperatureHot2016Pairs.reduceByKey(
                (x, y) -> MeanSchema.updateMean(x, y));

        if (printSwitch)
            System.out.println(temperatureHot2016mean.collect());

        // Calculate temperature excursions (pairs (city, excursions))
        JavaRDD<CityExcursion> excursions2016 = temperatureCold2016mean.union(temperatureHot2016mean)
                .reduceByKey((x, y) -> new MeanSchema(Math.abs(x.getMean() - y.getMean()), 0.0))
                .map(x -> new CityExcursion(x._1, x._2.getMean(), "2016"));

        if (printSwitch)
            System.out.println(excursions2016.collect());

        // ranking excursion USA 2016
        JavaRDD<CityExcursion> excursion2016USA = excursions2016.filter(x -> x.getState().equals("USA"))
                .sortBy(f -> f.getExcursions(), false, 1);
        result.add(excursion2016USA);

        if (printSwitch)
            System.out.println(excursion2016USA.collect());

        // ranking excursion Israel 2016
        JavaRDD<CityExcursion> excursion2016Israel = excursions2016.filter(x -> x.getState().equals("Israel"))
                .sortBy(f -> f.getExcursions(), false, 1);
        result.add(excursion2016Israel);

        if (printSwitch)
            System.out.println(excursion2016Israel.collect());

        return result;
    }
}
