package com.general.data.structures.and.algorithms




object BinarySearchWithLoopElement extends App {

  case class DataItem(list : Seq[Int],
                      posFromList : Int,
                      searchItem : Int)

  val array = (1 to 100).toArray

  def checkItem(dataItem : DataItem) = {
    //println("-------------------")
    //println(dataItem.list(dataItem.posFromList / 2) + "------" + dataItem.searchItem)
    if (dataItem.list(dataItem.posFromList / 2) == dataItem.searchItem) {
      println(dataItem.list)
      println(dataItem.list(dataItem.posFromList / 2))
      val newList = List(dataItem.searchItem)  //match found. So get item in list and set 0 for posFromList
      DataItem(newList, 0, dataItem.searchItem)
    } else {
      if (dataItem.list(dataItem.posFromList / 2) >= dataItem.searchItem) {
        //println("is greater")
        val newList = dataItem.list.dropRight(dataItem.posFromList / 2)
        DataItem(newList, dataItem.posFromList / 2, dataItem.searchItem)
      }
      else {
        //println("is lesser")
        //println("before drop ...")
        //println(dataItem.list)
        //println(dataItem.posFromList / 2)
        val newList = dataItem.list.drop(dataItem.posFromList / 2)
        //println("after drop ...")
        //println(newList)
        DataItem(newList, dataItem.posFromList / 2, dataItem.searchItem)
      }
    }
  }

  def valueFromList(dataItem: DataItem) = {
    dataItem.list find(x => x == dataItem.searchItem)
  }

  def getBinarySortBinary(dataItem: DataItem) : DataItem =
    {
      //println(s"${dataItem} ----- ${dataItem.list.length}")
      dataItem match {
        case dataItem : DataItem if (dataItem.posFromList == 0) => dataItem
        case dataItem : DataItem if (dataItem.posFromList != 0) => getBinarySortBinary(checkItem(dataItem))
      }
    }

  val output = getBinarySortBinary(DataItem(array.toList, array.length - 1, 70))

  println("----------------------------------------------------------------------------------")
  println(output)
  println(valueFromList(output))
}
