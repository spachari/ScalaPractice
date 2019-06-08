//A TypeTag solves the problem that Scala's types are erased at runtime (type erasure). If we wanna do
//Actual problem with Type Erasures
class Foo
class Bar extends Foo

class PatternMatchingNormal {
  def meth[A](xs: List[A]) = xs match {
    case _: List[String] => println("List of String")
    case _: List[Foo] => println("List of Foos")
  }

  //Compile time warnings
  //<console>:63: warning: non-variable type argument String in type pattern List[String] (the underlying of List[String]) is unchecked since it is eliminated by erasure
  //  case _:List[String] => "List of String"
  //  ^
  //  <console>:64: warning: unreachable code
  //    case _:List[foo] => "list of Foos" }



}

//Manifests solving the problem

class Foo1 { class Bar }

class PatternMatchingManifests {
  def m (f : Foo1)(b : f.Bar)(implicit ev: Manifest[f.Bar]) = ev

  //val f1 = new Foo1; val b1 = new f1.Bar
  //val f2 = new Foo1; val b2 = new f2.Bar

  //val p1 = new PatternMatchingManifests()
  //val ev1 = p1.m(f1)(b1)
  //val ev2 = p1.m(f2)(b2)
  //println("Manifests says the two objects ev1 and ev2 are the same")
  //println(ev1 == ev2)
}

//Now let's look at TypeTags

import scala.reflect.runtime.universe._

class PatternMatchingTypeTags {

  def m(f : Foo1)(b : f.Bar)(implicit ev : TypeTag[f.Bar]) = ev

  def meth[A : TypeTag](xs : List[A]) = typeOf[A] match {
    case t if t =:= typeOf[String] => "List of Strings"
    case t if t =:= typeOf[Foo] => "List of Foos" //type equality
    case t if t <:< typeOf[Foo] => "List of Bar"  //subtype relation
  }

  //Difference between =:= and ==
  //scala> typeOf[List[java.lang.String]] =:= typeOf[List[Predef.String]]
  //res71: Boolean = true

  //scala> typeOf[List[java.lang.String]] == typeOf[List[Predef.String]]
  //res72: Boolean = false
  //The latter checks for structural equality, which often is not what should be done because it doesn't care about things such as prefixes
  // (like in the example).

  //A TypeTag is completely compiler-generated, that means that the compiler creates and fills in a TypeTag when one calls a method expecting
  // such a TypeTag. There exist three different forms of tags:


  //ClassTag provides only the information needed to create types at runtime (which are type erased):

  //scala> classTag[Int]
  //res99: scala.reflect.ClassTag[Int] = ClassTag[int]

  //scala> classTag[Int].runtimeClass
  //res100: Class[_] = int

  //scala> classTag[Int].newArray(3)
  //res101: Array[Int] = Array(0, 0, 0)

  //scala> classTag[List[Int]]
  //res104: scala.reflect.ClassTag[List[Int]] =↩
  //  ClassTag[class scala.collection.immutable.List]


  //As one can see above, they don't care about type erasure, therefore if one wants "full" types TypeTag should be used:

  //scala> typeTag[List[Int]]
  //res105: reflect.runtime.universe.TypeTag[List[Int]] = TypeTag[scala.List[Int]]

  //scala> typeTag[List[Int]].tpe
  //res107: reflect.runtime.universe.Type = scala.List[Int]

  //scala> typeOf[List[Int]]
  //res108: reflect.runtime.universe.Type = scala.List[Int]

  //scala> res107 =:= res108
  //res109: Boolean = true

  //scala> def m[ A : ClassTag : TypeTag ] = ( classTag[A], typeTag[A] )
  //m: [A](implicit evidence$1: scala.reflect.ClassTag[A], implicit evidence$2: reflect.runtime.universe.TypeTag[A])(scala.reflect.ClassTag[A], reflect.runtime.universe.TypeTag[A])


  //scala> m[List[Int]]
  //res715: (scala.reflect.ClassTag[List[Int]], reflect.runtime.universe.TypeTag[List[Int]]) = (scala.collection.immutable.List,TypeTag[scala.List[Int]])

  //scala> m[List[String]]
  //res716: (scala.reflect.ClassTag[List[String]], reflect.runtime.universe.TypeTag[List[String]]) = (scala.collection.immutable.List,TypeTag[scala.List[String]])
}

class ClassTagsClass {
  import scala.reflect._
  //Example of getting a sequence of A's
  def printSeq[A](seq : A*) = for (l <- seq) println(l)

  //Creating an array
  //def createArr[A](seq : A*) = Array[A](seq : _ *) //This will not work
  def createArr[A : ClassTag] (seq: A*) = Array[A](seq: _ *) //This is how we an create an array of anything
}



object TypeTagsandClassTags extends App {
  val p = new PatternMatchingNormal
  val listOfStrings = List("Srinivas","Pachari","Surendranath")
  println("Issue with Pattern matching using types")
  println("Pattern matching listOfStrings" + p.meth(listOfStrings)) //Output List of String

  val foo1 = new Foo
  val foo2 = new Foo
  val foo3 = new Foo
  val listOfFoos = List(foo1,foo2,foo3)
  println("Pattern matching listOfFoos" + p.meth(listOfFoos))//Output List of String

  println("Look at usage of Manifests")
  val f1 = new Foo1; val b1 = new f1.Bar
  val f2 = new Foo1; val b2 = new f2.Bar

  val p1 = new PatternMatchingManifests()
  val ev1 = p1.m(f1)(b1)
  val ev2 = p1.m(f2)(b2)
  println("Manifests says the two objects ev1 and ev2 are the same")
  println(ev1 == ev2)


  println("Let's look at TypeTags")
  val p2 = new PatternMatchingTypeTags
  val ev3 = p2.m(f1)(b1)
  val ev4 = p2.m(f2)(b2)
  println(ev3 == ev4)
  println(ev3.tpe == ev4.tpe)
  println("This is correct")

  println("Pattern matching in TypeTags")

  println("Pattern matching listOfStrings" + p2.meth(listOfStrings)) //Output List of String
  println("Pattern matching listOfFoos" + p2.meth(listOfFoos)) //Output List of Foos
  println("Pattern matching listOfBar1" + p2.meth(List(new Bar, new Bar))) //Output List of Foos

  val c = new ClassTagsClass
  val a = c.createArr(1,2,3)
  a.foreach(println)

  val b = c.createArr("Srinivas","Pachari","Surendranath")
  b.foreach(println)

}
