package person

import scala.collection.mutable

object Solution2034 {

  class StockPrice() {

    val timeStamp2Value: mutable.SortedMap[Int, Int] =  collection.mutable.SortedMap[Int, Int]()
    val valueCount: mutable.SortedMap[Int, Int] =  collection.mutable.SortedMap[Int, Int]()

    def update(timestamp: Int, price: Int) {
      val maybeInt = timeStamp2Value.put(timestamp, price)
      if(maybeInt.isDefined) {
      }
    }

    def current(): Int = {
      timeStamp2Value.last._2
    }

    def maximum(): Int = {
      valueCount.last._1
    }

    def minimum(): Int = {
      valueCount.head._1
    }

  }
}
