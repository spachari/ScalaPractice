package com.scalatests.examples.sharing.fixtures.utils

import org.scalatest.{BeforeAndAfterEach, Suite}

import scala.collection.mutable.ListBuffer

trait BufferBeforeAndAfterEach extends BeforeAndAfterEach {
  self : Suite =>

  val buffer = new ListBuffer[String]

  override def beforeEach() {
    buffer.append("ScalaTest","is")
    super.beforeEach() // to be stackable we need to call super
  }

  override def afterEach(): Unit = {
    try { buffer.clear() }
    finally { super.afterEach() }
  }

}
