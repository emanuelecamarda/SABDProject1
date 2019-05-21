package query3;

import mongodb.MongoUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import schemas.CityExcursion;
import schemas.Query1Result;

import java.util.List;

public class MainQuery3 {

    private static String output = "hdfs:///Query3";

    public static void main (String[] args) {

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Query 3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        System.out.println("Executing Query 3 ...");
        Long startTime = System.currentTimeMillis();

        List<JavaRDD<CityExcursion>> result = Query3Processing.executeQuery3(sc);

        System.out.println("Finished Query 3 in " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println("\n2017 USA ...\n" + result.get(0).take(3));
        System.out.println("\n2017 Israel ...\n" + result.get(1).take(3));
        System.out.println("\n2016 USA ...\n" + result.get(2).take(3));
        System.out.println("\n2016 Israel ...\n" + result.get(3).take(3));

        SparkSession session = SparkSession.builder().appName("Test").master("local").getOrCreate();
        Dataset<Row> df = session.createDataFrame(result.get(0), Query1Result.class);
        df.write().json(output + "-2017USA");
        MongoUtils.exportOnMongo(result.get(0).collect());
        df = session.createDataFrame(result.get(1), Query1Result.class);
        df.write().json(output + "-2017Israel");
        MongoUtils.exportOnMongo(result.get(1).collect());
        df = session.createDataFrame(result.get(2), Query1Result.class);
        df.write().json(output + "-2016USA");
        MongoUtils.exportOnMongo(result.get(2).collect());
        df = session.createDataFrame(result.get(3), Query1Result.class);
        df.write().json(output + "-2016Israel");
        MongoUtils.exportOnMongo(result.get(3).collect());
        session.close();

        sc.stop();
    }
}
