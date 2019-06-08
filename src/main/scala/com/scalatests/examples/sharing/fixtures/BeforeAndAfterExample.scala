package com.scalatests.examples.sharing.fixtures

import org.scalatest.{BeforeAndAfter, FlatSpec}

import scala.collection.mutable.ListBuffer

//In BeforeAndAfter, if anything goes wrong, the test will be aborted. No tests will be even attempted.
//The rest of the set up will get test to fail if something happens during the setup

class BeforeAndAfterExample extends FlatSpec with BeforeAndAfter {

  val builder = new StringBuilder
  val buffer = new ListBuffer[String]

  before {
    builder.append("ScalaTest is ")
  }

  after {
    builder.clear()
    buffer.clear()
  }

  "Testing" should "be easy" in {
    builder.append("easy!")
    assert(builder.toString() == "ScalaTest is easy!")
    assert(buffer == List.empty)
    buffer += "sweet"
  }

  it should "be fun" in {
    builder.append("fun!")
    assert(builder.toString() == "ScalaTest is fun!")
    buffer += "sweet"
    assert(buffer.toList == List("sweet"))
  }

}
