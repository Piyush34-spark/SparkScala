package sparkcore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.log4j._

object CountrywiseTotal {
  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)

    val conf = new SparkConf().setMaster("local[*]").setAppName("CountrywiseTotal")

    val context = new SparkContext(conf)

    val rowRDD = context.textFile("Financial_Sample_Header.csv", 2)

    val header = rowRDD.first()

    val clearRDD = rowRDD.filter(line => !line.equalsIgnoreCase(header))

    val totUnitSoldCountrywise = clearRDD.map(line => (line.split(",")(1).trim(), line.split(",")(4).toDouble))
      .reduceByKey(_ + _);

    //    totUnitSoldCountrywise.foreach(println)

    totUnitSoldCountrywise.foreach(res => println(res._2 + " Unit Sold in " + res._1 + "."))

    context.stop()
  }
}