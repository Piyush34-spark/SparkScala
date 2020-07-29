package scala

object DoubleUtil {
  implicit class Funny(val num:Double){
   
    def knockKnock = {
      s"$num.toString is here"
    }
  }
  
  def main(args: Array[String]): Unit = {
    
    import DoubleUtil._
  //println(3.14.knockknock)
}

}
