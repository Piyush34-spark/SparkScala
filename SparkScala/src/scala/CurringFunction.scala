package scala

import scala.io._

object CurringFunction {
  
  /*Curring Function transfprm a function that takes multiple parameter
  to a chain of Functions*/
  
  def concat(str1: String) = (str2: String) => str1 + str2 //Curring Function
  
  def concat1(str1:String)(str2:String) = str1 + str2 //Curring Function
  
  def main(args : Array[String]):Unit = {
    
    val str1 = StdIn.readLine()
    val str2 = StdIn.readLine()
    
    println(s"Concatination of '$str1' and '$str2' is " + concat(str1)(str2))
    
    println(s"Concatination of '$str1' and '$str2' is " + concat1(str1)(str2))
    
  }
}