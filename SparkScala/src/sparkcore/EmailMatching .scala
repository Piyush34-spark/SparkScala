package sparkcore

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import java.util.regex.Pattern
import org.apache.log4j._

object EmailMatching  {
  def main(args: Array[String]): Unit = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val regEX = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"
    val conf = new SparkConf().setMaster("local[*]").setAppName("EmailMaching")
    
    val context = new SparkContext(conf);
    
    val fileRDD = context.textFile("Emails.txt")
    
    val validEmail = fileRDD.filter(email => Pattern.compile(regEX).matcher(email).matches() )
    
    validEmail.foreach(println)
    
    context.stop()
  }
}