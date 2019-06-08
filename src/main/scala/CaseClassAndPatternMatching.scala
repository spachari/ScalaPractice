
sealed abstract class Expr
case class Var(name : String) extends Expr
case class Numb(num: Double) extends Expr
case class UnOp(operator : String, arg : Expr) extends Expr
case class BinOp(operator : String, left : Expr, right : Expr) extends Expr

class Patternmatching {


def simplyfyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e
  case BinOp("+", e, Numb(0)) => e
  case BinOp("*", e, Numb(1)) => e
  case _ => expr
}

def simplyfyAll(expr : Expr) : Expr = expr match {
  case UnOp("-", UnOp("-", e)) => simplyfyAll(e) //"-" is it's own inverse
  case BinOp("+", e, Numb(0)) => simplyfyAll(e) //'0' is a neutral for '+'
  case BinOp("*", e, Numb(1)) => simplyfyAll(e) //'1' is a neutral for '-'
  case UnOp(op, e) => UnOp(op, simplyfyAll(e))
  case BinOp(op, l, r) => BinOp(op, simplyfyAll(l), simplyfyAll(r))
  case _ => expr
}


}

//
//This is a function that takes an expr and gives an expr
//A pattern includes a sequence of alternatives each starting with a keyword case
//A alternative has a pattern and one or more expressions
//Ex of a pattern: case UnOp("-", UnOp("-", e)) => e
//In the above example, UnOp("-", UnOp("-", e)) is the pattern and e is the expression
//

//A constant pattern
//This will match using the == method. For example

//scala> val c = BinOp("*", Numb(1), Var("D"))
//c: BinOp = BinOp(*,Numb(1.0),Var(D))

//scala> c.left == Numb(1.0)
//res39: Boolean = true

//scala> c.operator == "*"
//res46: Boolean = true

//A variable pattern
//A variable pattern like e matches every value. The variable pattern then refers to that value (used in the expression)
//in the right hand clause. Is that a variable is bound within the pattern

//A wildcard pattern
//A wildcard pattern _ matches every value. But it is not referred or cannot be used in the expression


//A constructor pattern
//A constructor pattern looks like UnOp("-", e). This pattern matches all values of type UnOp whose first
//character matches "-" and any other character. The arguments to the constructor are patterns themselves.
//So we can write patterns line UnOP("-", UnOp("-", UnOp("-", e)))
//

//Difference between Java switch and Scala match
//1. match is an expression in scala, so it returns a value
//2. Scala's alternate expressions never fall through. If none of the expressions match, we will get a
//matcherror expression. Even if all cases are coevered it is best to give a catchall pattern
//Example
// list match {
//    case BinOp(op, left, right) => println(op + is a binary operation)
//    case _ =>
// }
// In the above example, since the return type is a Unit, we can simply leave out the expression part for the
// catchall pattern
//

//Wildcard pattern
//We can use wildcard pattern for ignoring certain parts of the object
// list match {
//    case BinOp(_, _, _) => println(expr + is a binary operation)
//    case _ =>
// }

//Constant pattern
//scala> import math.{Pi,E}
//import math.{Pi, E}

//scala> E match {
//| case Pi => println("value is " + Pi)
//  | case _ => println("Ok") }
//Result is OK because Pi is treated as a constant not as a variable
//Ok

//=====================================================================================
//scala> val pi = math.Pi
//pi: Double = 3.141592653589793

//Treating pi as a variable
//scala> E match {
//| case pi => println("value is " + pi)
//| case _ => println("Ok") }

//Note: since pi is a variable constant we cannot use anything after that. we will get a Warming
//<console>:16: warning: unreachable code
//case _ => println("Ok") }

//The point to remember is, a simple name that starts with a lowercase (pi) is taken as a variable and
// anythign else is a constant

//Constructor Pattern
//A Constructor pattern looks like BinOp("*",e,Num(0)). When Scala encounters such a pattern it iwll
// 1. Check if a case class exists named BinOp
// 2. Check if the constructor paramters match the object's own constructor

//This means you are effectively doing deep matches.
// 1. If the object exists
// 2. If the contents of the pattern matches the object (using other patterns)

//=======================================================================================

//Sealed class provides two advantages. For this one
//sealed abstract class Expr
//1. The compiler will not allow any classes from some other page to extend the class Expr. So we need to only worry about
//our class.
//2. THe compiler will provide better support for our missing classes. For example

//scala> def describe (e : Expr) = e match {
//| case Numb(_) => "a number"
//    | case Var(_) => "a string" }
//<console>:17: warning: match may not be exhaustive.
//  It would fail on the following inputs: BinOp(_, _, _), UnOp(_, _)
//  def describe (e : Expr) = e match {
//  ^
//  describe: (e: Expr)String

//The compiler warns that we will get a matchError if we pass BinOp(_, _, _), UnOp(_, _) to the function describe(e)
//The warning can get unnecessary if all we are only going to pass is a Numb(_) or Var(_)
//To fix this issue we can do a simple hack
//1. have a catchAll phrase and assign them to a runtime exception
//def describe(e:Expr) = e match {
//  case Var(_) => "a number"
//  case Numb(_) => "a string"
//  case _ => throw new RuntimeException
//}

//A better alternative would be to quieten the compiler by adding an annotation
//def describe(e:Expr) = (e @unchecked) match {
//  case Var(_) => "a number"
//  case Numb(_) => "a string"
//}
//If a match's selector is carrying an @unchecked annotation, exhaustivity checking for the patterns will be suppressed
//========================================================================================

//Option Type
//Scala has a standard type for named Option for optional values. It can take two forms
//1. Some(x)
//2. None
//It simply means that the value can be String or it might be null too. This is encouraged in scala if we do not know
//if we will get a value all the time or just a null

//scala> val capitals = Map("France" -> "Paris","Japan" -> "Tokyo")
//capitals: scala.collection.immutable.Map[String,String] = Map(France -> Paris, Japan -> Tokyo)

//scala> capitals.get("France")
//res57: Option[String] = Some(Paris)

//scala> capitals.get("Portugal")
//res58: Option[String] = None

//Using pattern matching on a Option data type
//scala> def getValues(x : Option[String]) = x match {
//| case Some(s) => s
//    | case None => "$" }
//getValues: (x: Option[String])String

//scala> getValues(capitals get "France")
//res62: String = Paris

//scala> getValues(capitals get "Portugal")
//res63: String = $

//This is the beauty of Scala, suppose we know that a get might obviously return you a NullPointerException error
//then we will need to cater for it throughout the code. But in scala, we will never get a nullpointerexception
//from a Hash[Int,Int]. we will either get a Some(x) or None
//===============================================================================================
//We can pattern match everywhere. For example,
//Patterns are allowed in any parts of Scala. For example we can do pattern matching on tuples
//val myTuple = Tuple2(123, "abc")
//
//scala> val myTuple = Tuple2(123, "abc")
//myTuple: (Int, String) = (123,abc)
//
//scala> val (num, str) = myTuple
//num: Int = 123
//str: String = abc
// We can use these two variables anywhere in our code
//===================================================================================================
// Case sequence
// A sequence of cases is called Case sequence. It can be used anywhere a function literal like (x + 3) is used
// It is used with {} instead of normal parantheses(). THe beauty is that every case statement is an entry point to the function
//Function example: scala> val addf = (x : Int) => x + 2
//Method example:   scala> def addm(x : Int) = x + 2


// def matchFunction (x : Option[Int]) : Int = x match {
//  case Some(x) => x
//  case None => 0
//}

//scala>  def matchFunction : Option[Int] => Int = {
//  |   case Some(x) => x
//  |   case None => 0
//    | }
//matchFunction: Option[Int] => Int

//scala> val m : Option[Int] => Int = {
//  | case Some(x) => x
//  | case None => 0 }

//The body of this function has two cases. Both of them are entry points for the function. Let's write a simple case function

//case class Person (id : Int, name : String)

//scala> def checkLiteral : Any => Any = {
//  |   case s : Int => s + 10
//    |   case p : String => "Hello " + "Srinivas"
//    |   case x : Person => Person(10,"Srinivas")
//    | }
//It is worth nothing that if we pass a checkLiteral(new Student()) or checkLiteral(Some(10))
// to the above example we will get a matcherror. SO we need a default case for this

//scala> val checkLiteral : PartialFunction[Any,Any] = {
//| case s : Int => s + 10
//| case p : String => "Hello " + "Srinivas"
//| case x : Person => Person(10,"Srinivas") }
//checkLiteral: PartialFunction[Any,Any] = <function1>

//If we have to use a partial function, we can check it with defining it as a partial function and then checking it via the below statements

//    scala> checkLiteral.isDefinedAt(Some(10))
//    res144: Boolean = false
//
//    scala> checkLiteral.isDefinedAt(p)
//    res145: Boolean = true

//What it does is that it internally creates an apply method that
// new PartialFunction(Any, Any) = {
//     def apply (x : Any) : Any = x match {
//         case s : Int => s + 10
//         case p : String => "Hello " + "Srinivas"
//         case x : Person => Person(10,"Srinivas")}
//     def isDefined (x : Any) = x match {
//         case s : Int => true
//         case p : String => true
//         case x : Person => true
//         case _ => false }
//It is best to work with complete functions, but if we have to use partial functions we need to use this

//patters in for loop
//scala> val countryAndCapital = Map("France" -> "Paris", "Spain" -> "Madrid", "India" -> "Delhi")
//countryAndCapital: scala.collection.immutable.Map[String,String] = Map(France -> Paris, Spain -> Madrid, India -> Delhi)

//scala> for ((key,value) <- countryAndCapital) println(key + "'s capital city is " + value)
//France's capital city is Paris
//Spain's capital city is Madrid
//India's capital city is Delhi
//
//They can do filtering as well

//scala> val fruitList = List(Some("Apple"),None,Some("Orange"))
//fruitList: List[Option[String]] = List(Some(Apple), None, Some(Orange))

//scala> for (Some(fruit) <- fruitList) println(fruit)
//Apple
//Orange


//
//===================================================================================================
class ListPatternMatching {
  def matchList (list : List[Int]) = list match {
    case List(0,_*) => println("List starts from 0")
    case List(_,_) => println("List has only two items")
    case List(_,0) => println("List ends woth 0")  //wont work
    case xs :: x :: Nil => println("List ends with 0") //did not work either
    case _ => println("Do not know much about it")
  }
}

class ArrayPatternMatching {
  def matchArray (array : Array[Int]) = array match {
    case Array(0,_*) => println("Array starts from 0")
    case Array(_,_) => println("Array has only two items")
    case _ => println("Do not know much about the array")
  }
}

class TupleMatching {
  def tupleMatching (tuple3: Tuple3[Int,Int,Int]): Unit = tuple3 match {
    case (x,y,z) => println("matched " + x + " " + y + " " + z)
    case _ => println("Cannot match")
  }

  def tupleMatchingBinOp (expr : Any) : Unit = expr match {
    case BinOp(x, _, _) => println("This is a multiplication operation")
    case _ => println("Dont know anything abotu it")
  }
}

class TypedPatterns {
  def identifyType (x : Any) = x match {
    case a : String => println("Type string " + a.length)  //called typed pattern
    case m : Map[_,_] => println(m.values)
    case _ => println("Cannot identify the type")
  }

  def isIntIntMap (x : Any) = x match {
    case m : Map[Int,Int] => println("Map is Int")
    case _ => println("Map is not Int")
  }

  //def isStringArray (x : Array[Any]) = x match {
  //  case x: Array[String] => println("is String array")
  //  case _ => println("not a string array")
  //}

  def variableBinding (x : Any) = x match {
    case List(e @ List(1,2),_) => println(e)
    case _ => println(List(null,null))
  }
}

class PatternGuards {
  def setBinOp (e : BinOp) : BinOp = e match {
    case BinOp("*",x,y) if (x == y) => BinOp("*", x, Numb(2))
    case _ => e
  }
}

object PatternMathicngMain {
  def main(args: Array[String]): Unit = {
    val listPatternMatching = new ListPatternMatching
    listPatternMatching.matchList(List(1,2))
    listPatternMatching.matchList(List(0,1,2,3))
    listPatternMatching.matchList(List(1,2,3,0))

    val arrayPatternMatching = new ArrayPatternMatching
    arrayPatternMatching.matchArray(Array(1,2))
    arrayPatternMatching.matchArray(Array(0,1,2,3))
    arrayPatternMatching.matchArray(Array(1,2,3,0))

    val tuplematching = new TupleMatching
    tuplematching.tupleMatching(Tuple3(1,2,3))
    tuplematching.tupleMatchingBinOp( BinOp("*", Var("x"), Var("v")) )

    val typedPatterns = new TypedPatterns
    typedPatterns.identifyType(Map(1 -> 'a', 2 -> 'b'))
    typedPatterns.identifyType("abc")

    typedPatterns.isIntIntMap(Map(1 -> 'a', 2 -> 'b')) // this will match because type erasure will remove the type [Int,Int] of the

    //typedPatterns.isStringArray(Array("abc", "bcd", "xyz"))
    //typedPatterns.isStringArray(Array(1,2,3))

    typedPatterns.variableBinding(List(List(1,2),List(3,4)))

    val patternGuards = new PatternGuards
    val output = patternGuards.setBinOp(BinOp("*",Var("x"),Var("x")))
    println(output)
  }
}