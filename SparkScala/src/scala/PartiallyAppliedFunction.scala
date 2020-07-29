package scala

import java.util.Date

object PartiallyAppliedFunction {
  
  def log(date: Date, message: String):Unit = {
    
     println(date + " -------- " + message)
  }
  
  def main(args: Array[String]): Unit = {
    
     val date = new Date
     
 /*   while calling of the function "log" we are not passing all the argument instead 
  *   we place "_", this type of call is called partial Applied Function 
  *   This type of Function call is usefull when one or more Argument is not changing while
  *   calling function for multiple times.  */  
     
     val partialFunc = log(date, _:String)
     
     partialFunc("Message1")
     
     Thread.sleep(1000)
     
     partialFunc("Message2")
     
     Thread.sleep(1000)
     
     partialFunc("Message3")
     
  }
}