package scala

object PolymorphicFunction {

  /*below function is defined as type "A", So while calling the function we can
    define the type or it will be defined on basis of call, here we have called two times same function
    one with "INT" type and one with "String" type.*/
  
  def listOfDuplicates[A](value: A, length: Int): List[A] = {
    if (length < 1)
      Nil
    else
      value :: listOfDuplicates(value, length - 1) // "::" is called list cons operator, it will add value to list
  }

  def main(args: Array[String]): Unit = {

    println(listOfDuplicates[Int](3, 4))
    println(listOfDuplicates("piyush", 5))
  }
}