package person

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer

object Solution11 {
  def main(args: Array[String]): Unit = {

    val height = Array(1,2,1)
    val i = maxArea(height)
    print(i)
  }

  // 剪枝
  def maxArea(height: Array[Int]): Int = {
    var left = 0
    var right = height.length - 1
    var res = 0
    while(left < right) {
      res = res max (right - left) * (height(left) min height(right))
      if(height(left) < height(right)) left += 1
      else right -= 1
    }
    res
  }
}
