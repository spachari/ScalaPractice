package com.programmingscala.examples.functional.programming.functor.category

import com.programmingscala.examples.functional.programming.functor.category.FunctorF.map1
import org.scalatest.FunSpec
import org.scalatest.prop.PropertyChecks


//In Category Theory terms, other categories are the objects and the morphisms are the mapping between categories.
// For example, List[Int] and List[String] would be two categories whose own objects are all possible lists of Ints and Strings, respectively.

class FunctorPropertiesTests extends FunSpec with PropertyChecks {

  def id[A] = identity[A] _
  // This is a function of type
  // id: [A]=> A => A
  //id[Int] will give
  // id: [Int] => Int = <function1>
  //id[Int](100) will return 100

  //this will create a function that will take a value and return it
  //ex
  //id[Int] will give a function that will take ints
  //id[Int](10) will return a 10

  //id
  //[A] will be replaced with Nothing
  //Nothing => Nothing = $$Lambda$1267/1461657245@406a54a2

  def testSeqMorphism(f2 : Int => Int) = {
    val f1 : Int => Int = _ * 2
    //THis is another way of writing val f1 : Int => Int = (i : Int) => i * 2

    import SeqFunctor._
    forAll { (l : List[Int]) =>
      println(s"Checking for l ${l} left hand value is ${map(map(l)(f1))(f2)} is right hand value is ${map(l)(f2 compose f1)}" )
      assert(map(map(l)(f1))(f2) === map(l)(f2 compose f1))
    }
  }


  def testFunctionMorphism(f2: Int => Int) = {
    val f1: Int => Int = _ * 2
    import FunctorF._
    forAll { (i: Int) =>
      println(s"Checking for i ${i} left hand value is ${map1(f1)(f2)(i)} and right hand value is ${(f2 compose f1)(i)}")
      assert( map1(f1)(f2)(i) === (f2 compose f1)(i) )
    }
  }

  describe ("Functor morphism composition") {
    it ("works for Sequence Functors") {
      testSeqMorphism(_ + 3)
    }

    it("works for Function Functors") {
      testFunctionMorphism(_ + 3)
    }
  }


  describe("Functor identity composed with another function commutes") {
    it("works for Sequence Functors") {
      testSeqMorphism(id[Int])
    }

    it("works for Function Functors") {
      testFunctionMorphism(id)
    }
  }

  describe("Functor identities maps between the identies of categories") {
    it("works for sequence Functors") {
      val f1 : Int => String = _.toString
      import SeqFunctor._
      assert(map(List.empty)(f1) === List.empty[String])
    }

    it ("works for function functors") {
      val f1 = (x : Int) => x * 2
      def id[A] = identity[A] _

      import FunctorF._
      forAll { (i: Int) =>
        println("printing i " + i)
        assert( map1(id[Int])(f1)(i) === (f1 compose id[Int])(i) )
      }
    }
  }

  describe("Functor morphism composition is associative") {
    it("works for sequence Functors") {
      val f1 = (x : Int) => x * 2
      val f2 : Int => Int = _ + 3
      val f3 : Int => Int = _ * 5
      val f : Int => Int = _ + 21

      import SeqFunctor._
      forAll { (l : List[Int]) =>
        val m12 = map(map(l)(f1))(f2)
        val m23 = (seq : Seq[Int]) => map(map(seq)(f2))(f3)
        println(s"L is ${l} Left hand side is ${map(m12)(f3)} and right hand side is ${m23(map(l)(f1))}")
        assert(map(m12)(f3) === m23(map(l)(f1)))
      }
    }

    it("works for Function functors") {
      val f1 = (x : Int) => x * 2
      val f2 : Int => Int = _ + 3
      val f3 : Int => Int = _ * 5
      val f : Int => Int = _ + 21

      import FunctorF._
      val m12 = map1(map1(f)(f1))(f2)
      val m23 = (g : Int => Int) => map1(map1(g)(f2))(f3)

      forAll { (i : Int) =>
        println(s"i is ${i} and ")
        assert(map1(m12)(f3)(i) === m23(map1(f)(f1))(i))
      }
    }

  }



}


object Test extends App {
  val f1 = (x : Int) => x * 2
  val f2 : Int => Int = _ + 3
  val f3 : Int => Int = _ * 5
  val f : Int => Int = _ + 21

  def id[A] = identity[A] _

  val l = List(1,2)
  //Checking the tests

  import SeqFunctor._
  val output = map(map(l)(f1))(f2)
  println(output)

  val output1 = map(l)(f2 compose f1)
  println(output1)

  val output3 = map(List(1))(f1)
  //Testing associative principles

  val m12 = map(map(l)(f1))(f2)
  val m123 = map(m12)(f3)
  println(m123)
  val m123test = map(map(map(l)(f1))(f2))(f3)
  println(m123test)

  val f23 = (seq : Seq[Int]) => map(map(seq)(f2))(f3)
  val f123 = f23(map(l)(f1))
  println(f123)


  //Test associativity on functions
  // (x + (y + z)) == ((x + y) + z) (associativity law).
  val fun12 = map1(map1(f)(f1))(f2)
  val fun24 = map1(fun12)(f3)(10)
  println(fun24)

  val func23 = (g : Int => Int) => map1(map1(g)(f2))(f3)
  val funcoutput = func23(map1(f)(f1))(10)
  println(funcoutput)

  val idOutput = map(map(l)(f1))(id)

  println(idOutput)

}