package sparkcore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.log4j._

object TotalMovieRatingWise {

  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)

    val conf = new SparkConf().setMaster("local[*]").setAppName("TotalMovieRatingWise")
    val context = new SparkContext(conf)

    val movieRDD = context.textFile("C:/SparkScala/ml-100k/u.data")

    val ratingRDD = movieRDD.map(movie => movie.toString().split("\t")(2))
    val ratingCount = ratingRDD.countByValue()

    val sortedRating = ratingCount.toSeq.sortBy(_._1)
    sortedRating.foreach(println);
  }
}