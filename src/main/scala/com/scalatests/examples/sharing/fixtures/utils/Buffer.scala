package com.scalatests.examples.sharing.fixtures.utils

import scala.collection.mutable.ListBuffer

trait Buffer {

  val buffer = ListBuffer("ScalaTest", "is")

}
