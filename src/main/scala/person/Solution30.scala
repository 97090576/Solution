package person

object Solution30 {
  def findSubstring(s: String, words: Array[String]): List[Int] = {
    val map = collection.mutable.Map[String, Int]()
    val res = collection.mutable.ListBuffer[Int]()
    for (elem <- words) {
      val cnt = map.getOrElse(elem, 0)
      map.put(elem, cnt + 1)
    }
    val wordLength = words(0).length
    for (i <- 0 to (s.length - wordLength * words.length)) {
      val tmp = map.clone()
      var j = i
      var end = if(j + wordLength < s.length) j + wordLength else s.length
      var str = s.substring(j, end)
      while(tmp.nonEmpty && tmp.contains(str)) {
        val cnt = tmp.getOrElse(str, 0)
        if(cnt - 1 <= 0) {
          tmp.remove(str)
        } else {
          tmp.put(str, cnt-1)
        }
        j = end
        end = if(j + wordLength < s.length) j + wordLength else s.length
        str = if(j < s.length) s.substring(j, end) else ""
      }
      if(tmp.isEmpty) {
        res += i
      }
    }

    res.toList
  }

  def main(args: Array[String]): Unit = {
    val value = findSubstring("wordgoodgoodgoodbestword", Array("word", "good", "best", "good"))
    value.foreach(println)
  }
}
