package sparkcore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object RemoveHeader {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setMaster("local[*]").setAppName("RemoveHeader");
    
    val context = new SparkContext(conf);
    
    val fileRDD = context.textFile("Financial_Sample_Header.csv", 4);
    
    val header = fileRDD.first();
    
    val CleanRDD = fileRDD.filter(line => !line.equals(header));
    
    println(CleanRDD.count());
  }
}