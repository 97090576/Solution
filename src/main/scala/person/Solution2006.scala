package person

object Solution2006 {
  def countKDifference(nums: Array[Int], k: Int): Int = {
    val map = collection.mutable.HashMap(nums(0) -> 1)
    var res = 0
    for(i <- 1 until nums.length) {
      res += (map.getOrElse(nums(i)+k, 0) + map.getOrElse(nums(i)-k, 0))
      val cnt = map.getOrElse(nums(i), 0)
      map += (nums(i) -> (cnt+1))
    }
    res
  }
}
