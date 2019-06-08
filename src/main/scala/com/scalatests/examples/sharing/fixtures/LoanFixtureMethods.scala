package com.scalatests.examples.sharing.fixtures

import java.io.{File, FileWriter}
import java.util.concurrent.ConcurrentHashMap

import org.scalatest.FlatSpec

object DBServer {
  type Db = StringBuffer
  private val databases = new ConcurrentHashMap[String, Db]()

  def createDb(name : String) : Db = {
    val db = new StringBuffer
    databases.put(name, db)
    db
  }

  def removeDb(name : String) : Db = {
    databases.remove(name)
  }
}


class LoanFixtureMethods extends FlatSpec {

  import java.util.UUID.randomUUID

  import DBServer._


  //A loan-fixture method takes a function whose body forms part or all of a test's code. It creates a fixture, passes it to
  // the test code by invoking the function, then cleans up the fixture after the function returns.
  def withDatabases(testCode : Db => Any) {
    val dbName = randomUUID.toString
    val db = createDb(dbName) //Create the fixture
    try {
      db.append("ScalaTest is ") //perform setup
      testCode(db)            //loan the fixture to test. Test code can use db
    } finally {
      removeDb(dbName)
    }
  }

  //Remember that this means it will return Unit
  def withFile(testCode : (File, FileWriter) => Any) {
    val file = File.createTempFile("Hello", "World")
    val writer = new FileWriter(file)  //Create the fixture
    try {
      writer.write("ScalaTest is ") //perform setup
      testCode(file, writer)        //loan the fixture to test
    }
    finally {
      writer.close()
    }
  }

  //This test needs a file fixture
  "Testing" should "be Productive" in withFile { (file, writer) =>
    writer.write("productive!")
    writer.flush()
    assert(file.length() == 24)
  }

  //This test needs a db fixture
  "Testing" should "be Readable" in withDatabases { (db) =>
    db.append("readable!")
    assert(db.toString == "ScalaTest is readable!")
  }

  //This test needs both the file and database fixture
  it should "be clear and concise" in withDatabases { db =>
  { withFile { (file, fileWriter) => //loan fixture methods compose
      db.append("clear")
      fileWriter.write("concise!")
      fileWriter.flush()
      assert(db.toString == "ScalaTest is clear")
      assert(file.length() == 21)
    }
  }

    //Note the following.
    //1. Each database setup is independent
    //2. The name loan pattern is because each test creates a fixture (object i.e. file or db) and loans it to the test
    //3. Once the test is complete it will safely remove the object
    //4. It's like each test has a 'fixture sandbox' to play with

  }



}
