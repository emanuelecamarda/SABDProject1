package query1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class MainQuery1 {

    private static String output = "hdfs://locahost:9000/user/hadoop/data/outputQuery1";

    public static void main (String[] args) {

        SparkConf conf = new SparkConf()
                .setMaster("local")
                .setAppName("Query 1");
        JavaSparkContext sc = new JavaSparkContext(conf);
        sc.setLogLevel("ERROR");

        System.out.println("Executing Query 1 ...");
        JavaRDD<String> result = Query1Processing.preprocessDataset(sc);
        result.saveAsTextFile(output);

        sc.close();
    }
}
