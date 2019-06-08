package com.scalatests.examples.sharing.fixtures

import com.scalatests.examples.sharing.fixtures.utils.{BufferBeforeAndAfterEach, BuilderBeforeAndAfterEach}
import org.scalatest.FlatSpec

class BeforeAndAfterEachAsTrait extends FlatSpec with BuilderBeforeAndAfterEach with BufferBeforeAndAfterEach {

  "Testing" should "be productive" in {
    builder.append("fun!")
    buffer.append("fun!")
    assert(builder.toString() == "ScalaTest is fun!")
    assert(buffer.toList.length == 3)
  }

  it should "be fun" in {
    builder.append("each!")
    buffer.append("each!")
    assert(builder.toString() == "ScalaTest is each!")
    assert(buffer.toList.length == 3)
  }


}
