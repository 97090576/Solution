package person

object Solution2029 {
  def main(args: Array[String]): Unit = {
    val stones = Array(1, 2)
    val bool = stoneGameIX(stones)
    print(bool)
  }

  def stoneGameIX(stones: Array[Int]): Boolean = {
    if(stones.sum % 3 == 0) return true

    false
  }
}
