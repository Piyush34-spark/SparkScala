package sparkcore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


object UpperCase {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setMaster("local[*]").setAppName("UpperCase");
    
    val context = new SparkContext(conf);
    
    val fileRDD = context.textFile("Financial_Sample.csv", 2);
    
    val upperRDD = fileRDD.map(line => line.toUpperCase());
    
    upperRDD.foreach(println);
  }
}