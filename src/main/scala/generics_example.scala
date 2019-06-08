import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFSum

class generics_example [T] {
  def printElements[T] (xs : List[T]) = {
    for (x <- xs) {
      println(x)
    }
  }
}


class Stack [+A] { //This class can take anything that is subtype of A. That is what +A means. The class can take anything above A
  def push[B >: A](elem : B) : Stack[B] = new Stack[B] { //[B >: A] means lower type bound. It means B is constrained to be subtype of A
    override def top : B = elem
    override def pop : Stack[B] = Stack.this

    override def toString: String = elem.toString + " " + Stack.this.toString()
  }

  def top : A = sys.error("no element at stack")
  def pop : Stack[A] = sys.error("no element at stack")

  override def toString: String = ""
}


class GenericSum [+A] { //This class can take anything that is a subtype of A. That is what + means.
  def printing[B >: A](xs : List[B]) = {//[B >: A] means lower type bound. It means B is constrained to be subtype of A
    for (x <- xs) {//Dog >: Animal
      println(x)
    }
  }

}

class Generics[-A] {//This class can take anything that is a supertype of A. That is what - means.
  def printing[C <: A] (xs : List[C]) = { ////[C <: A] means upper type bound. It means C is constrained to be supertype of A
    for (x <- xs) {
      println(x)
    }
  }
}


class Test_ {
  var x : Int = _
  var str : String = _
  var y : Int = 10
}

object test extends App {
  val n = new generics_example[Int]
  n.printElements(List(1,2,3,4,5))

  val s = new generics_example[String]
  s.printElements(List("Srinivas", "Pachari"))

  //val x = new GenericSum[Int]
  //x.summation(List(1,2,3,4,5))

  var st : Stack[Any] = new Stack().push("hello")
  st = st.push(new Object)
  st = st.push(7)

  println(st)

  val t = new Test_
  println(t.x)
  println(t.y)
  println(t.str)
}