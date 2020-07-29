package SparkScalaSql

import org.apache.log4j._
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession

object DataFrame {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.ERROR)

    val session = new SparkSession.Builder().master("local[*]").appName("DataFrame").getOrCreate()

    val employeeSchema = StructType(List(StructField("Frist_Name", StringType, true), StructField("Last_Name", StringType, true), StructField("Salary", IntegerType, true)))
    val employee = Seq(Row("Piyush", "Chandra", 30000), Row("Chandan", "Kumar", 20000), Row("Manish", "Kumar", 40000))
    
    val employeeDF = session.createDataFrame(session.sparkContext.parallelize(employee), employeeSchema)
    
    employeeDF.show()
  }
}