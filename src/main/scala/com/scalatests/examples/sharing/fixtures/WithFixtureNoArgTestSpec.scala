package com.scalatests.examples.sharing.fixtures

import java.io.File

import org.scalatest.{Failed, FlatSpec, Outcome}

//If we want to do something before or after each test we need to do the following

class WithFixtureNoArgTestSpec extends FlatSpec {

  override def withFixture(test: NoArgTest): Outcome = {
    super.withFixture(test) match {
      case failed : Failed => {
        val currDir = new File(".")
        val fileNames = currDir.listFiles()
        info("Dir snapshot: " + fileNames.mkString(", ")) //This is the way to print something for test cases
        failed
      }
      case other => other
    }
  }

  "This test " should "succeed" in {
    assert( 1 + 1 == 2)
  }

  "This test " should "fail" in {
    assert(1 + 1 == 3)
  }

}
