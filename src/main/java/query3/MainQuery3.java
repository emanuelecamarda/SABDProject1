package query3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import schemas.CityExcursion;

import java.util.List;

public class MainQuery3 {

    private static String output = "hdfs:///outputQuery3";

    public static void main (String[] args) {

        System.out.println("Executing Query 3 ...");
        Long startTime = System.currentTimeMillis();

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Query 3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        List<JavaRDD<CityExcursion>> result = Query3Processing.executeQuery3(sc);
        System.out.println("2017 USA\n\n" + result.get(0).take(3));
        System.out.println("2017 Israel\n\n" + result.get(1).take(3));
        System.out.println("2016 USA\n\n" + result.get(2).take(3));
        System.out.println("2016 Israel\n\n" + result.get(3).take(3));
        result.get(0).saveAsTextFile(output + "-2017USA");
        result.get(1).saveAsTextFile(output + "-2017Israel");
        result.get(2).saveAsTextFile(output + "-2016USA");
        result.get(3).saveAsTextFile(output + "-2016Israel");

        sc.stop();

        System.out.println("Finished Query 3 in " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
