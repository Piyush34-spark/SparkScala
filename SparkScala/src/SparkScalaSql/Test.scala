package sparkcore

import org.apache.spark.sql.SparkSession
import org.apache.log4j.Logger
import org.apache.log4j.Level

object Test {

  case class Sales(transaction_id: Int, customer_id: Int, product_id: Int, timestamp: String, total_amount: String, total_quantity: Int)

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val spark = new SparkSession.Builder().master("local[*]").appName("Test").getOrCreate()

    val sales_RDD = spark.sparkContext.textFile("Sales.txt")

    val salesScemaRDD = sales_RDD.map(line => Sales(line.split('|')(0).toInt, line.split('|')(1).toInt, line.split('|')(2).toInt, line.split('|')(3), line.split('|')(4).substring(1, line.split('|')(4).length()), line.split('|')(5).toInt))

    import spark.implicits._

    val salesDF = salesScemaRDD.toDF()

    salesDF.createOrReplaceTempView("Sales")

    spark.sql("""select s.customer_id Customer, 
                    concat('$',sum(s.total_amount)) Total_spent 
                    from Sales s 
                    group by Customer
                    order by Total_spent desc
                    limit 5 
              """).show()

    spark.stop()

  }
}