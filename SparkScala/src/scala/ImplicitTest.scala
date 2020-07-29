package scala

object ImplicitTest {

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    def add(x: String, y: String) = x concat y
    def unit() = ""
  }

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {

    def add(x: Int, y: Int) = x + y

    def unit() = 0
  }

  def sum[A](xy: List[A])(implicit m: Monoid[A]): A =
    if (xy.isEmpty) m.unit()
    else m.add(xy.head, sum(xy.tail))

  def main(args: Array[String]): Unit = {

    println(sum(List(1, 2, 3, 4, 5, 6, 7)))
    println(sum(List("A", "B", "c", "d", "e")))
  }

}