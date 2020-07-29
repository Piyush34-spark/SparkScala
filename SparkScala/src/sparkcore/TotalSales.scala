package sparkcore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.log4j._

object TotalSales {
  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val conf = new SparkConf().setMaster("local[*]").setAppName("TotalSalesInCanada");
    
    val context = new SparkContext(conf);
    
    val rowRDD = context.textFile("Financial_Sample_Header.csv", 4);
    
    val header = rowRDD.first();
    
    val cleanRDD = rowRDD.filter(line => !line.equals(header));
    
    val canadaRDD = cleanRDD.filter(line => line.split(",")(1).trim().equalsIgnoreCase("Canada"));
    
    val totalQuanSold = canadaRDD.map(line => line.split(",")(4).toDouble).reduce(_+_);
    
    println(s"Total Quantitny Sold in Canada is $totalQuanSold");
    
    context.stop();
  }
  
}