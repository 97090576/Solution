package person

import scala.collection.mutable

object Solution42 {

  def main(args: Array[String]): Unit = {
    val height = Array(4,2,0,3,2,5)
    val i = trap(height)
    print(i)
  }

  // dp
  def trap(height: Array[Int]): Int = {
    val n = height.length
    val maxL = new Array[Int](n)
    val maxR = new Array[Int](n)
    for(i <- height.indices) {
      val j = n - 1 - i
      if(i == 0){
        maxL(i) = -1
        maxR(j) = -1
      }
      else {
        maxL(i) = Math.max(maxL(i-1), height(i-1))
        maxR(j) = Math.max(maxR(j+1), height(j+1))
      }
    }
    var res = 0
    for(i <- maxL.indices) {
      if(maxL(i) > height(i) && maxR(i) > height(i)) {
        res += (Math.min(maxL(i), maxR(i)) - height(i))
      }
    }
    res
  }
}
