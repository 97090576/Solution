package person

object Solution10 {
  def isMatch(s: String, p: String): Boolean = {
    val dp = Array.ofDim[Boolean](s.length + 1, p.length + 1)
    dp(0)(0) = true
    for (i <- 2 to p.length) {
      dp(0)(i) = p(i - 1) == '*' && dp(0)(i - 2)
    }

    for (i <- 1 to s.length) {
      for (j <- 1 to p.length) {
        if (isCharMatch(s, p, i, j)) {
          if (p(j - 1) == '*') {
            dp(i)(j) = dp(i - 1)(j - 1) || dp(i - 1)(j) || dp(i)(j - 2)
          } else {
            dp(i)(j) = dp(i - 1)(j - 1)
          }
        } else if (p(j - 1) == '*') {
          dp(i)(j) = dp(i)(j - 2)
        }
      }
    }

    dp(s.length)(p.length)
  }

  /**
   * p 下标为 index_p 的字符是否可以匹配上 s 下标为 index_s 的字符
   * 1. p(index_p) == '.' ， 可以匹配任意字符
   * 2. p(index_p) == '*' ， 匹配结果与 p(index_p-1) 和 s(index_s) 的匹配结果相同
   * 3. p(index_p) == [a-z]，匹配结果 = p(index_p)==s(index_s)
   */
  def isCharMatch(s: String, p: String, indexs: Int, indexp: Int): Boolean = {
    val index_p = indexp - 1
    val index_s = indexs - 1
    if (p(index_p) == '.') true
    else if (p(index_p) == '*') {
      p(index_p - 1) == '.' || p(index_p - 1) == s(index_s)
    } else {
      s(index_s) == p(index_p)
    }
  }

  def main(args: Array[String]): Unit = {
    val bool = isMatch("aaa", "ab*a*c*a")
    println(bool)
  }

}
