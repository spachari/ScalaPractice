package com.scalatests.examples.sharing.fixtures

import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

//We use this technique when you
// 1. Do not need to clean anything after each test is executed
// 2. The setup/ mutable variables need to be set up for every test and then cleaned automatically

class GetFixtureMethods extends FlatSpec {

  def fixture = new {
    val builder = new StringBuilder("ScalaTest is ")
    val buffer = new ListBuffer[String]
  }

  "Testing " should "should be easy" in {
    val f = fixture
    f.builder.append("easy")
    assert(f.builder.toString == "ScalaTest is easy")
    assert(f.buffer == List.empty)
    f.buffer.append("sweet")
  }

  it should " fun " in {
    val f = fixture
    f.builder.append("fun!")
    assert(f.builder.toString == "ScalaTest is fun!")
    assert(f.buffer.isEmpty)
  }

}
