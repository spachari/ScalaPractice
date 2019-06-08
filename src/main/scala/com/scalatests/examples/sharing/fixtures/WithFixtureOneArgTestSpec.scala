package com.scalatests.examples.sharing.fixtures

import org.scalatest.fixture

//Each test in a fixture.FlatSpec takes a fixture as a parameter, allowing you to pass the fixture into the test.
// You must indicate the type of the fixture parameter by specifying FixtureParam, and implement a withFixture method that
// takes a OneArgTest. This withFixture method is responsible for invoking the one-arg test function, so you can perform
// fixture set up before, and clean up after, invoking and passing the fixture into the test function.

//Here setup is done during the test

class WithFixtureOneArgTestSpec extends fixture.FlatSpec {

  import java.io._

  case class FixtureParam(file : File, fileWriter : FileWriter)

  def withFixture(test: OneArgTest) = {
    val file = File.createTempFile("hello", "world") // create the fixture
    val writer = new FileWriter(file)
    val theFixture = FixtureParam(file, writer)

    try {
      writer.write("ScalaTest is ") //setup the fixture
      withFixture(test.toNoArgTest(theFixture)) // "loan" the fixture to the test. This is available to all test cases
    }
    finally {
      writer.close()
    }
  }

  "Testing" should "be productive" in { f =>
    f.fileWriter.write("easy!")
    f.fileWriter.flush()
    assert(f.file.length() == 18)
  }

  it should "be fun" in { f =>
    f.fileWriter.write("fun!")
    f.fileWriter.flush()
    assert(f.file.length() == 17)
  }



}
