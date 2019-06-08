package com.neophytes.guide

import com.neophytes.guide.Math.NumberLike

import scala.annotation.implicitNotFound

//This is what we want to achieve
object Statistics {
  def median(xs : Vector[Double]) : Double = xs(xs.size / 2)
  def quartiles(xs : Vector[Double]) : (Double, Double, Double) = (xs(xs.size / 4), median(xs), xs(xs.size / 4 * 3))
  def iqr(xs : Vector[Double]) : Double = quartiles(xs) match {
    case (lowerQuartile, _, upperQuartile) => upperQuartile - lowerQuartile
  }

  def mean(xs : Vector[Double]) : Double = {
    xs.reduce( _ + _) / xs.size
  }
}

//A type class C defines some behaviour in the form of operations that must be supported by a type T for it to be a member of type class C.
// Whether the type T is a member of the type class C is not inherent in the type. Rather, any developer can declare that a type is a member
// of a type class simply by providing implementations of the operations the type must support. Now, once T is made a member of the type class
// C, functions that have constrained one or more of their parameters to be members of C can be called with arguments of type T.

object Math {

  @implicitNotFound(s"No member found for type class NumberLike in scope")
  trait NumberLike[T] {
    def plus(x : T, y : T) : T
    def minus(x : T, y : T) : T
    def divide(x : T, y : Int) : T
  }

  object NumberLike {
    implicit object NumberLikeDouble extends NumberLike[Double] {
      override def plus(x: Double, y: Double): Double = x + y
      override def minus(x: Double, y: Double): Double = x - y
      override def divide(x: Double, y: Int): Double = x / y
    }

    implicit object NumberLikeInt extends NumberLike[Int] {
      override def plus(x: Int, y: Int): Int = x + y
      override def minus(x: Int, y: Int): Int = x - y
      override def divide(x: Int, y: Int): Int = x / y
    }
  }
}

//Statistics object against TypeClass
object StatisticsWithTypeClass {
  def mean [T](xs : Vector[T])(implicit ev : NumberLike[T]) = {
    ev.divide(xs.reduce(ev.plus(_,_)), xs.size)
  }

  //A second, implicit parameter list on all methods that expect a member of a type class can be a little verbose. As a shortcut for
  // implicit parameters with only one type parameter, Scala provides so-called context bounds.

  //A context bound T : NumberLike means that an implicit value of type NumberLike[T] must be available, and so is really equivalent
  // to having a second implicit parameter list with a NumberLike[T] in it.

  def median[T] (xs : Vector[T]) : T = xs(xs.size / 2)

  def quartiles[T](xs : Vector[T]) : (T,T,T) = (xs(xs.size / 4), median(xs), xs(xs.size / 4 * 3))



  def iqr[T: NumberLike](xs: Vector[T]): T = quartiles(xs) match {
    case (lowerQuartile, _, upperQuartile) =>
      implicitly[NumberLike[T]].minus(upperQuartile, lowerQuartile)
  }
  //If you want to access that implicitly available value, however, you need to call the implicitly method, as we do in
  // the iqr method. If your type class requires more than one type parameter, you cannot use the context bound syntax.

  //The other can be used like this too
  def iqr2[T <: NumberLike[T]] (xs : Vector[T])(implicit ev : NumberLike[T]) : T = quartiles(xs) match {
    case (lowerQuartile, _, upperQuartile) => ev.minus(upperQuartile, lowerQuartile)
  }
}

object TypeClassTest extends App {
  val vecDoubles = Vector(13.0, 9.0, 2.0, 4.0, 5.0, 6, 20.0)
  val output = StatisticsWithTypeClass.mean(vecDoubles)
  println(output)

  val vecStrings = Vector("Srinivas", "pachari", "Surendranath")
  //val output1 = StatisticsWithTypeClass.mean(vecStrings)
  //println(output)
}
