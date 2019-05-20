package query1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class MainQuery1 {

    private static String output = "hdfs:///outputQuery1";

    public static void main (String[] args) {

        System.out.println("Executing Query 1 ...");
        Long startTime = System.currentTimeMillis();

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Query 1");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        JavaRDD<String> result = Query1Processing.executeQuery1(sc);
        System.out.println(result.collect());
        result.saveAsTextFile(output);

        sc.stop();

        System.out.println("Finished Query 1 in " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
