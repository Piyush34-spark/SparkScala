package scala

import java.util.Date

object FullyAppliedFunction {
  
  def log(date:Date, message:String) ={
    
    println(date + " ----- " + message)
    
  }
  
  def main(args : Array[String]): Unit ={
    
    var date = new Date
    
// This Function call is fully applied because we are passing all the Argumnet in the Function "log"
    log(date, "Message1")
    
    Thread.sleep(1000)
    
    log(date, "Message2")
    
    Thread.sleep(1000)
    
    log(date, "Message3")
    
  }
}