package com.general.data.structures.and.algorithms

object CompareTwoCollections extends App {

  val family = Map("Dad" -> "Srinivas", "Mum" -> "Kirthika", "Girl" -> "Sadhana", "Boy" -> "Sadhiv")
  val family1 = Map("Dad" -> "Srinivas", "Mum" -> "Kirthika", "Girl" -> "Sadhana", "Boy" -> "Sadhiv1")

  case class FolderNameAndSchema(folderName : String, schemaMap : Map[String, String])

  def compareMaps(correctMap : FolderNameAndSchema)(itemToCompare : FolderNameAndSchema) = {
    val output = if (!correctMap.schemaMap.equals(itemToCompare.schemaMap)) {
      for (i <- itemToCompare.schemaMap) yield {
        val dataTypeForOtherMap = correctMap.schemaMap.get(i._1).get
        if (i._2 != dataTypeForOtherMap) {
          println(s"${itemToCompare.folderName} deos not match. ${i._1} is different. map is ${i._2} but other value is ${dataTypeForOtherMap}")
        }
      }
    }
  }

compareMaps(FolderNameAndSchema("family",family))(FolderNameAndSchema("family1",family1))

}
