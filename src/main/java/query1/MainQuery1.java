package query1;

import mongodb.MongoUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import schemas.Query1Result;

public class MainQuery1 {

    private static String output = "hdfs:///Query1";

    public static void main (String[] args) {

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Query 1");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        System.out.println("Executing Query 1 ...");
        Long startTime = System.currentTimeMillis();

        JavaRDD<Query1Result> result = Query1Processing.executeQuery1(sc);

        System.out.println("Finished Query 1 in " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println("\n" + result.collect());

        SparkSession session = SparkSession.builder().appName("Test").master("local").getOrCreate();
        Dataset<Row> df = session.createDataFrame(result, Query1Result.class);
        df.write().json(output);
        MongoUtils.exportOnMongo(result.collect());
        session.close();

        sc.stop();
    }
}
