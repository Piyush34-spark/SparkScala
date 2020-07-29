package SparkScalaSql

import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StructType, StructField, IntegerType, StringType, FloatType}

object DataFrameWithCSV {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val session = new SparkSession.Builder().master("local[*]").appName("DF with csv").getOrCreate()

    val orderSchema = StructType(List(
      StructField("InvoiceNo", IntegerType, true),
      StructField("StockCode", StringType, true),
      StructField("Discription", StringType, true),
      StructField("Quantity", IntegerType, true),
      StructField("InvoiceDate", StringType, true),
      StructField("UnitPrice", FloatType, true),
      StructField("Customer", IntegerType, true),
      StructField("Country", StringType, true)))
      
   val orderDF = session.read.option("header", true).schema(orderSchema).csv("C:/SparkScala/Online Retail.csv")
   
   orderDF.limit(10).show()
   
   session.stop()

  }
}