package person
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
//
// 你可以对一个单词进行如下三种操作：
//
//
// 插入一个字符
// 删除一个字符
// 替换一个字符
//
//
//
//
// 示例 1：
//
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//
// 示例 2：
//
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//
//
// 提示：
//
//
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
//
// Related Topics 字符串 动态规划 👍 2060 👎 0
object Solution72 {

  def main(args: Array[String]): Unit = {
    val word1 = "c"
    val word2 = "ac"
    val i = minDistance(word1, word2)
    print(i)
  }

  /**
   *
  两个卡点：
       1. 将 word1 的删除操作等价为 word2 的插入操作
       2. 所有的操作都针对字符串最后一个字符操作
       由这两个前提，才有后面的状态只由前面的状态影响 =》 递推公式
       dp(i)(j) = word1(0->i) 转化成为 word2(0->j) 所使用的的最小操作数
        dp(i)(j) = min(dp(i-1)(j-1), dp(i)(j-1), dp(i-1)(j)) + 1

      "" r o s
   ""  0 1 2 3
   h   1 1 2 3
   o   2 2 1 2
   r   3 2 2 2
   s   4 3 3 2
   e   5 4 4 3
   */


  def minDistance(word1: String, word2: String): Int = {

    val dp = Array.ofDim[Int](word1.length+1, word2.length+1)
    for(i <- 0 to word1.length) {
      dp(i)(0) = i
    }
    for(i <- 1 to word2.length) {
      dp(0)(i) = i
    }
    for(i <- 1 to word1.length) {
      for(j <- 1 to word2.length) {
        if(word1(i-1) == word2(j-1)) {
          dp(i)(j) = dp(i-1)(j-1)
        } else {
          dp(i)(j) = (dp(i-1)(j-1) min dp(i-1)(j) min dp(i)(j-1)) + 1
        }
      }
    }
    dp(word1.length)(word2.length)
  }

}
