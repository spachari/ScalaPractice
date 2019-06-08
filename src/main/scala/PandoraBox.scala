import org.joda.time.DateTime

class PandoraBox {
  case class Thing (s : String)
  var things = new scala.collection.mutable.ArrayBuffer[Thing]
   things += Thing("thing1")
  things += Thing ("thing2")

  def addThings(s : String) = {things += new Thing(s)}

}

object MainThing {
  def main(args: Array[String]): Unit = {
    val p = new PandoraBox
    //println(p.things)
    for (t <- p.things)
      {
        println(t)
      }
    p.things.foreach(println)

    //adding two more things
    p.addThings("thing3")
    p.addThings("thing4")
    val rundate = "'" + org.joda.time.DateTime.now().toLocalDate.toString + "'"

    println(rundate)
    val rundate_string = (s"""$rundate""")

    println(rundate_string)

    val destDb = "bix_common"
    val destTbl = "history"
    val partitionFieldName = "rundate"



    println(s"ALTER TABLE  $destDb.$destTbl ADD IF NOT EXISTS PARTITION($partitionFieldName=$rundate)")

    p.things.foreach(println)
  }
}

//The beauty is that they only know that using addThings they can add new Things , encapsulation

