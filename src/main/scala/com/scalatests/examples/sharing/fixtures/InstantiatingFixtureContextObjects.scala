package com.scalatests.examples.sharing.fixtures

import com.scalatests.examples.sharing.fixtures.utils.{Buffer, Builder}
import org.scalatest.FlatSpec

//Use this technique when
//1. we want to allocate variables/setup before each test and dont care to them after the test finishes
//2. mix and match traits when we need them

class InstantiatingFixtureContextObjects extends FlatSpec {

  "Testing " should  "be Productive " in new Builder {
    builder.append("fun!")
    assert(builder.toString == "ScalaTest is fun!")
  }

  "Test code " should "be Readable" in new Buffer {
    val b = buffer += ("fun")
    assert(b == List("ScalaTest", "is", "fun"))
  }

  it should "be clear and concise with " in new Builder with Buffer {
    builder.append("easy")
    assert(builder.toString == "ScalaTest is easy")
    buffer += ("fun")
    assert(buffer == List("ScalaTest", "is", "fun"))

  }

}
