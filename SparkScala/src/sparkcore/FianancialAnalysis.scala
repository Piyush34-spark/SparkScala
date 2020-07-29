package sparkcore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object FianancialAnalysis {
  def main(args: Array[String]): Unit = {
    
    val conf = new SparkConf().setMaster("local[*]").setAppName("FinancialAnalysis");
    
    val context = new SparkContext(conf);
    
    val fileRDD = context.textFile("Financial_Sample_Header.csv", 4);
    
    val header = fileRDD.first();
    
    val cleanRDD = fileRDD.filter(line => !line.equals(header));
    
    val canadaRDD = cleanRDD.filter(line => line.split(",")(1).trim().equalsIgnoreCase("canada"));
    
    canadaRDD.persist();
    
    canadaRDD.foreach(println);
    
    println(canadaRDD.count());
    
    context.stop();
  }
}