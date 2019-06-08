import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set

class Buffers(listBuf : ListBuffer[Int])
{
  def addItem ( x : Int) = listBuf += x

  def printBuffer = listBuf.foreach(println)

}


class Sets(mutableSet : scala.collection.mutable.Set[String]) {


}

class Maps {
  var mutableMap = scala.collection.mutable.Map.empty[String, Int]

  def countWords (s : String) : scala.collection.mutable.Map[String, Int] = {
    val string = s.split("[ !,.]")
    var count = 0
    for (st <- string)
      {
        val word = st.toLowerCase.trim
        var count = 0
        if (mutableMap.contains(word))
          {
            count = mutableMap(word) + 1
          }
        else
          {
            count = 1
          }
        mutableMap += word -> count
      }
    mutableMap
  }
}

class StringManipulations {
  def findLongestWord (s : String) : (String, Int) = {
    val words = s.split("[ .,!]")
    val map = scala.collection.mutable.Map.empty[String, Int]
    var word = ""
    for (w <- 1 until words.length)
      {
        //println(words(w))
        if (words(w).length > word.length)
          {
            word = words(w)
          }
      }
    (word, word.length)
  }
}

object SequencesInScala {
  def main(args: Array[String]): Unit = {
    val buffer = new Buffers(new ListBuffer[Int])
    buffer.addItem(10)
    buffer.addItem(20)
    buffer.addItem(30)

    buffer.printBuffer

    //Sets
    val set =  scala.collection.mutable.Set[String]()
    val text = "Look Sport, run run run. fast!"
    val string = text.split("[ ,!.]+")
    //val newSet = string.toSet

    for (s <- string)
      {
        set += s.toLowerCase()
      }

    set.foreach(println)

    println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    //Maps
    val m = new Maps
    val map = m.countWords("Look Sport, run run run. Run fast!")

    for (m <- map)
      {
        println(m._1, m._2)
      }
    map.clear()

    println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    //Getting the longest word in a string
    val s = new StringManipulations
    val longWord = s.findLongestWord("Look Sport, run run run. Run fast!")
println(longWord)
  }
}
