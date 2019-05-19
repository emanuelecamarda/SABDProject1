package query3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import schemas.CityExcursion;

import java.util.List;

public class MainQuery3 {

    private static String output = "hdfs:///outputQuery3";

    public static void main (String[] args) {

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Query 3");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        System.out.println("Executing Query 3 ...");
        List<JavaRDD<CityExcursion>> result = Query3Processing.executeQuery3(sc);
        result.get(0).saveAsTextFile(output + "2017USA");
        result.get(1).saveAsTextFile(output + "2017Israel");
        result.get(2).saveAsTextFile(output + "2016USA");
        result.get(3).saveAsTextFile(output + "2016Israel");

        sc.stop();
    }
}
