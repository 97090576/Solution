package person

import scala.collection.mutable.ListBuffer

object Solution1447 {
  def simplifiedFractions(n: Int): List[String] = {
    val res = ListBuffer[String]()
    for (i <- 2 to n) {
      for (j <- 1 until i) {
        if (co_prime(i, j)) {
          res += (j + "/" + i)
        }
      }
    }
    res.toList
  }

  def co_prime(n: Int, m: Int): Boolean = {
    if (m == 1 || n == 1) return true
    var dividend = n max m
    var divisor = m min n
    var remainder = dividend % divisor
    while (remainder != 0 && remainder != 1) {
      dividend = divisor
      divisor = remainder
      remainder = dividend % divisor
    }
    remainder == 1
  }

  def main(args: Array[String]): Unit = {
    val value = simplifiedFractions(4)
    value.foreach(println)
  }
}
