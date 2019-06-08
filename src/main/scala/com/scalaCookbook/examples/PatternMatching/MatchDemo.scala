package com.scalaCookbook.examples.PatternMatching

import java.io.FileNotFoundException

import scala.annotation.switch


object MatchDemo extends App {
  val i = 1
  //Compiling your match expression to a tableswitch or lookupswitch is better for performance,
  // because it results in a branch table rather than a decision tree

  //Switch annotation documentation
  //An annotation to be applied to a match expression. If present, the compiler will verify that the match has been compiled to a
  // tableswitch or lookupswitch, and issue an error if it instead compiles into a series of conditional expressions.
  val x = (i: @switch) match {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
    case _ => "Anything"
  }

  //types in match stattement

  def getClassFromVar(x : Any) : String = x match {
    case s : String => s + " is a String"
    case i : Int => "This is Int"
    case f : Float => "This is float"
    case l : List[_] => "This is list"
    case _ => "Unknown"
  }

  println(x)

  //Using multiple values in case statement

  trait Command
  object Start extends Command
  object Go extends Command
  object Quit extends Command
  object Running extends Command
  object Abort extends Command

  def checkStatus (cmd : Command) = {
   val value = cmd match {
     case Start | Go | Running => println("Good state")
     case Quit | Abort => println("Bad state")
   }
  }

  case class Person (firstName : String, lastName : String)
  case class Dog (name : String)

  val three = 0

  //Pattern matching on primitives
  def  allPatternMatches (a : Any) : String = {
    val two = 2
    val output = a match {
      //constant pattern
      case 0 => "zero"
      //variable pattern if you are using a variable , you need to mention the type it is from. Think of it like pattern matching on
      // primitives
      case two : Int => s"you gae me ${two}"
      case three : Int => s"you gave me ${three}"
      //Constructor pattern
      case Person(first, "Pachari") => s"Found a Pachari, whose first name is ${first}"
      case Dog("Suka") => s"Name of the dog is Suka"
      //Sequence Pattern
      case list : List[Int] => s"A list that contains ${list}"
      case List(1, _, _) => s"A list that starts with 1 and has 3 items"
      case List(1, _*) => s"A List that starts with 1 and has many items"
      case List(1, xs) => s"A List that starts with 1 and has ${xs}"
      //Tuple patterns
      case (a, b, c) => s"A tuple containing ${a}, ${b} and ${c}"
      case (a, b, c, _) => s"A tuple containing ${a}, ${b} and ${c} and a lot more"
      //Type patterns
      case s: String => s"${s} is a string"
      case _ => s"default"
    }
    output
  }

  //pattern matching on objects and returning the variable including objects
  def patternMatchingOnObjects (x : Any) = x match {
      //Pattern matching on normal variables
    case two : Int => s"you gae me ${two}"
    case three : Int => s"you gave me ${three}"
      //Pattern matching on object variables and collections
    case intList @ List(1,_*) => s"this is a ${intList}"
    case strList @ List("str",_*) => s"this is a ${strList}"
    case some @ Some(_) => s"this is a ${some}"
    case person @ Person(first,"Pachari") => s"the first name is ${person.firstName} and last name is ${person.lastName}"
    case _ => "default"
  }

  //Overcoming the type erasure issue in scala using Typetag and ClassTag
  import scala.reflect.runtime.universe._
  def matchList[A: TypeTag](list: List[A]) = list match {
    case strlist: List[String @unchecked] if typeOf[A] =:= typeOf[String] => println("A list of strings!")
    case intlist: List[Int @unchecked] if typeOf[A] =:= typeOf[Int] => println("A list of ints!")
  }

  import scala.reflect.{ClassTag, classTag}
  def matchList2[A : ClassTag](list: List[A]) = list match {
    case strlist: List[String @unchecked] if classTag[A] == classTag[String] => println("A List of strings!")
    case intlist: List[Int @unchecked] if classTag[A] == classTag[Int] => println("A list of ints!")
  }

  //a multi case example
  trait Animal
  case class Tiger(name : String) extends Animal
  case class Cat(name : String) extends Animal
  case object Woodpecker extends Animal

  def determineType (x : Animal) : String = x match {
    case Tiger(x) => s"We got a Tiger named ${x}"
    case _ : Cat => "Got a Cat (ignoring the name)"
    case Woodpecker => "That was a Woodpecker"
    case _ => "This was something else"
  }

  println(determineType(Tiger("Rocky")))
  println(determineType(Cat("This is Rusty")))
  println(determineType(Woodpecker))


  def getAnimalObjects (x : Animal) : Any = x match {
    case tiger @ Tiger(x) => tiger.name
    case _ : Cat => "Got a Cat (ignoring the name)"
    case Woodpecker => "That was a Woodpecker"
    case _ => "This was something else"
  }

  val s = getAnimalObjects(Tiger("Rocky"))
  println(s)

  //Using guards (if statement) in pattern matching
  def rangePatternMatching (x : Int) = x match {
    case a if 0 to 9 contains a => s"number ${a} falls in range 0 to 9"
    case b if 10 to 19 contains b => s"number ${b} falls in range 10 to 19"
    case _ => "number falls outside range"
  }

  case class Student(id : Int, name : String, rank : Int, mark : Int) extends SchoolPerson

  def getStudentName(x : Student) = x match {
    case x if (x.name == "Srinivas" && x.id == 10) => s"This guys' name is Pachari and his mark is ${x.mark}"
    case x if (x.name == "Srinivas" || x.rank == 1) => s"This is not Pachari and his mark is ${x.mark}"
    case x if x.name == "Srinivas" => s"the name of the student is ${x.name}"
    case _ => s"Not an interesting guy"
  }

  val srini1 = Student(1, "Srinivas", 1, 100)
  val srini2 = Student(2, "Srinivas", 10, 80)

  println(getStudentName(srini1))
  println(getStudentName(srini2))

  val getStudentNames = (x : Student) => x match {
    case x if (x.name == "Srinivas" && x.id == 10) => s"This guys' name is Pachari and his mark is ${x.mark}"
    case x if (x.name == "Srinivas" || x.rank == 1) => s"This is not Pachari and his mark is ${x.mark}"
    case x if x.name == "Srinivas" => s"the name of the student is ${x.name}"
    case _ => s"Not an interesting guy"
  }

  println(getStudentNames.apply(srini1))

  def getStudent(x : Student) = x match {
    case Student(id : Int, name : String, rank : Int, mark : Int) if (name == "Srinivas" && id == 10) =>
      s"This guys' name is Pachari and his mark is ${mark}"
    case Student(id : Int, name : String, rank : Int, mark : Int) if (name == "Srinivas" || rank == 1) =>
      s"This is not Pachari and his mark is ${mark}"
    case Student(id : Int, name : String, rank : Int, mark : Int) if name == "Srinivas" =>
      s"the name of the student is ${name}"
    case _ => s"Not an interesting guy"
  }

  println(getStudent(srini1))

  def getStudentHavingCaseInRightSide (x : Student) = x match {
    case Student(id : Int, name : String, rank : Int, mark : Int) =>
      if (name == "Srinivas")
         if (name == "Srinivas" && id == 10)
            s"This guys' name is Pachari and his mark is ${mark}"
         else if (name == "Srinivas" || rank == 1)
            s"This is not Pachari and his mark is ${mark}"
         else
            s"This is ${name} but not the guy we are after"
    case Student(id : Int, name : String, rank : Int, mark : Int) if name == "Kirthika" => s"the name of the student is ${name}"
    case _ => s"Not an interesting guy"
  }


  println(getStudentHavingCaseInRightSide(srini1))
  val kirthika = Student(2, "Kirthika", 10, 80)

  println(getStudentHavingCaseInRightSide(kirthika))

  sealed trait SchoolPerson
  case class Teacher (name : String, expert : String) extends SchoolPerson
//we are using type matching instead of isInstanceOf
  def getTypeUsingType (x : SchoolPerson) = x match {
    case Student(id, name, rank, mark) => s"This is a student whose name is ${name} and his id is ${id}"
    case Teacher(name, expert) => s"This is a teacher whose name is ${name} and his expertise is in ${expert}"
  }

  val alagar = Teacher("Alagarsamy", "Physics")
  println(getTypeUsingType(srini1))
  println(getTypeUsingType(alagar))

  //Some recursion examples using pattern matching
  def listToString (list : List[String]) : String = list match {
    case s :: rest => s + " " + listToString(rest)
    case Nil => ""
  }

  def isPresentInList(item : String, list : List[String]) = {
    val s = if (list.contains(item)) Some(item) else None
    s.getOrElse("")
  }

  def uniqueItemsInList(list : List[String]) : List[String] = list match {
    case s :: rest => { println(isPresentInList(s, rest))
      isPresentInList(s, s :: rest) :: uniqueItemsInList(rest)
    }
    case Nil => List()
  }

  //Handling exceptions
  def convertToInt(x : String) : Any = {
    try {
      x.toInt
    } catch {

      case e: NumberFormatException => println("This is a number format exception")
      case  _ : Exception => println("Cannot convert it to Number")
    }
  }

  @throws(classOf[NumberFormatException])
  def myToInt(x: String) : Any = {
    try {
      x.toInt
    } catch {
      case e: Exception => println("Cannot convert it to Number")
      case e: NumberFormatException => println("This is a number format exception")
      case e : FileNotFoundException => println("File is not present")
    }
  }



}
