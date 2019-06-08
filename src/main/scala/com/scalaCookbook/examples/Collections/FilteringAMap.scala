package com.scalaCookbook.examples.Collections

object FilteringAMap extends App {

  //Mutable Map
  val map = scala.collection.mutable.Map(1 -> 'a', 2 -> 'b', 3 -> 'c')

  val filterKeysMap = map.filterKeys(x => x == 2)

  println(filterKeysMap)

  val filterMapOnKeys = map.filter(x => x._1 == 1)
  println(filterMapOnKeys)

  val filterMapOnValues = map.filter(x => x._2 == 'b')
  println(filterMapOnValues)

  val retainedKeys = map.retain((x,y) => x > 1)

  println(retainedKeys)


  val transformedMap = map.transform((x,y) => y.toUpper)

  transformedMap.foreach(println)


}
