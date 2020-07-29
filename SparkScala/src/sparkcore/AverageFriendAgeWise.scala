package sparkcore

import org.apache.log4j._
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object AverageFriendAgeWise {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val conf = new SparkConf().setMaster("local[*]").setAppName("AverageFriendAgeWise")
    val context = new SparkContext(conf)

    val lineRDD = context.textFile("C:/SparkScala/fakefriends.csv")
    val stagingRDD = lineRDD.map(line => (line.toString().split(",")(2).toInt, line.toString().split(",")(3).toInt))
    val totalByAge = stagingRDD.mapValues(firend => (firend, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
    val avgByAge = totalByAge.mapValues(x => x._1 / x._2).collect()

    avgByAge.sorted.foreach(println)

  }
}