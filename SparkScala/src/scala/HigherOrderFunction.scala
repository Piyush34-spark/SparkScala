package scala

object HigherOrderFunction {
  
  def layout(x: Int):String = "[" + x.toString() + "]"
  
  def apply(f: Int => String, v:Int) = f(v)
  
  def main(args: Array[String]): Unit = {
    
    println(apply(layout, 10))
  }
 
}