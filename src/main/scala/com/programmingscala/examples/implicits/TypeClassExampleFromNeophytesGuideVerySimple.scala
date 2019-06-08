package com.programmingscala.examples.implicits

import com.programmingscala.examples.implicits.Math.NumberLike
import org.joda.time.Duration
import org.joda.time.Duration._

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


    import org.joda.time.Duration

    implicit object NumberLikeDuration extends NumberLike[Duration] {
      override def plus(x: Duration, y: Duration): Duration = x.plus(y)

      override def minus(x: Duration, y: Duration): Duration = x.minus(y)

      override def divide(x: Duration, y: Int): Duration = Duration.millis(x.getMillis / y)
    }

  }
}

//Statistics object against TypeClass
object StatisticsWithTypeClass1 {
  def mean [T](xs : Vector[T])(implicit ev : NumberLike[T]) = {
    ev.divide(xs.reduce(ev.plus(_,_)), xs.size)
  }

  def total[T](xs : Vector[T])(implicit ev : NumberLike[T]) = {
    xs.reduce(ev.plus(_,_))
  }

  //A second, implicit parameter list on all methods that expect a member of a type class can be a little verbose. As a shortcut for
  // implicit parameters with only one type parameter, Scala provides so-called context bounds.

  //A context bound T : NumberLike means that an implicit value of type NumberLike[T] must be available, and so is really equivalent
  // to having a second implicit parameter list with a NumberLike[T] in it.

  def median[T] (xs : Vector[T]) : T = xs(xs.size / 2)

  def quartiles[T](xs : Vector[T]) : (T,T,T) = (xs(xs.size / 4), median(xs), xs(xs.size / 4 * 3))


  def iqr[T: NumberLike](xs: Vector[T]): T = quartiles(xs) match { //Note: when you create context bound, use the object NumberLike
    case (lowerQuartile, _, upperQuartile) =>                      //not the trait NumberLike[T]
      implicitly[NumberLike[T]].minus(upperQuartile, lowerQuartile)
  }
  //If you want to access that implicitly available value, however, you need to call the implicitly method, as we do in
  // the iqr method. If your type class requires more than one type parameter, you cannot use the context bound syntax.

  //The other can be used like this too
  def iqr2[T : NumberLike] (xs : Vector[T])(implicit ev : NumberLike[T]) : T = quartiles(xs) match {
    case (lowerQuartile, _, upperQuartile) => ev.minus(upperQuartile, lowerQuartile)
  }
}

object TypeClassTest extends App {

  val vecDoubles = Vector(13.0, 9.0, 2.0, 4.0, 5.0, 6, 20.0)
  val outputMean = StatisticsWithTypeClass1.mean(vecDoubles)
  val outputTotal = StatisticsWithTypeClass1.total(vecDoubles)
  println(outputMean)
  println(outputTotal)


  val vecStrings = Vector("Srinivas", "pachari", "Surendranath")
  //val output1 = StatisticsWithTypeClass.mean(vecStrings)
  //println(output)

  val vecDurations = Vector(standardSeconds(20), standardSeconds(57), standardMinutes(2),
    standardMinutes(17), standardMinutes(30), standardMinutes(58), standardHours(2),
    standardHours(5), standardHours(8), standardHours(17), standardDays(1),
    standardDays(4))

  def plusDurations(x : Duration, y : Duration) = x.plus(y)
  val test = vecDurations.reduce((x,y) => plusDurations(x,y))

  println(test.getStandardHours)

  val totalDurations = StatisticsWithTypeClass1.total(vecDurations)
  println(totalDurations)

  val meanDurations = StatisticsWithTypeClass1.mean(vecDurations)
  println(meanDurations.getStandardHours)


}
