package com.scalaCookbook.examples.Collections

object AddingRemovingTraversingElementsOfAMap extends App {

  //Create a mutable Map
  import scala.collection.mutable.{Map => MMap}

  //Different ways of adding elements to a Map
  val mutableMap = MMap[String, Int]()
  mutableMap += ("Srinivas" -> 1)
  mutableMap += ("Kirthika" -> 2)
  mutableMap += ("Sadhiv" -> 3, "Sadhana" -> 4)

  mutableMap ++= List("Sidharth" -> 1, "Smita" -> 1,"Vihan" -> 3,"Vyas" -> 4)
  mutableMap += ("Komal" -> 9)

  mutableMap.foreach{ case (x,y) => println(x + "  " + y) }

  //Different ways of removign elements from a Map
  mutableMap -= ("komal")

  mutableMap --= List("Sidharth", "Smita","Vihan","Vyas")

  mutableMap.put("Steve",100)

  mutableMap.foreach{ case(x,y) => println(x + "   "  + y)}


  mutableMap.retain((k,v) => k == "Steve")

  mutableMap.foreach{ case(x,y) => println(x + "   "  + y)}

  mutableMap.clear()

  //Creating an immutable Map

  println("Immutable map ...")
  val map = Map[String, Int]()

  val map1 = map + ("Srinvias" -> 1)

  val map2 = map1 + ("Kirthika" -> 2)

  val map3 = map2 + ("Sadhana" -> 3)

  val map4 = map3 ++ List("Sadhana" -> 4, "Sadhiv" -> 5)

  val map6 = map4 -- List("Sadhana" , "Sadhiv")

  val map7 = map6 - ("Kirthika")

  map7.foreach{ case(k,v) => println( k + "  " + v)}

  val map8 = map7 - ("Srinvias") - ("Kirthika")

  map8.foreach(println)


  //Accessing map values
  val states = Map("AL" -> "Alabama", "AK" -> "Alaska", "AZ" -> "Arizona", "CA" -> "California").withDefaultValue("Default")

  println(states("foo"))

  println(states.get("Al"))

  println(states.getOrElse("BO","Key not present"))

  println(states)


  //Traversing through a Map
  val ratings = Map("Lady in the Water"-> 3.0, "Snakes on a Plane"-> 4.0, "You, Me and Dupree"-> 3.5)

  ratings.foreach{ case (k,v) => println(s"key ${k}, value ${v}")}

  for ((k,v) <- ratings)
    {
      println(s"key ${k}, value ${v}")
    }

  ratings.foreach(println)

  ratings.foreach((x) => println("Value is " + x._2 + " and Key is " + x._1))


  ratings.keys.foreach(println)

  ratings.values.foreach(println)

  val map34 = Map(1 -> 12, 2 -> 22, 3 -> 33)

  map34.mapValues(x => x * 100).foreach(println)

  map34.transform((k,v) => k * v).foreach(println)

  //Getting Keys or values from a Map
  map34.keySet.foreach(println)

  map34.keys.foreach(println)

  map34.keysIterator.toList.foreach(println)

  map34.values.foreach(println)

  map34.valuesIterator.toList.foreach(println)

  //reversing keys and values in a map

  val products = Map("Breadsticks" -> "$5", "Pizza" -> "$10", "Wings" -> "$2")

  val reverseMap = for ((k,v) <- products) yield (v -> k)

  reverseMap.foreach{ case (x,y) => println(x + "  " + y) }

  //Checkign if a value is present in the map

  println(reverseMap.valuesIterator.contains("Pizz"))

  println(reverseMap.valuesIterator.contains("Wings"))

  println(reverseMap.keysIterator.contains("$2"))

}
