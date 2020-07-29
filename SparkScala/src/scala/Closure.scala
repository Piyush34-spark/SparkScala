package scala

object Closure {

  val factor = 3

  val multiplier = (i: Int) => i * factor //this function value depends on the variable outside of function

  def main(args: Array[String]): Unit = {

    println("Multiplier of 2 is " + multiplier(2))
    println("Multiplier of 3 is " + multiplier(3))
  }

}