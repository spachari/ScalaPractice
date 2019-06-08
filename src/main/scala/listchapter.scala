class MyList {
  def isort(xs: List[Int]): List[Int] = {
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))
  }


  def insert(x: Int, xs: List[Int]): List[Int] = {
    if (xs.isEmpty || x <= xs.head) x :: xs
    else
      xs.head :: insert(x, xs.tail)
  }


  //Pattern matching in lists
  //scala> val fruit = List("apples","oranges","grapes")
  //fruit: List[String] = List(apples, oranges, grapes)

  //If you know exactly the number of items
  //scala> val List(a,b,c) = fruit
  //a: String = apples
  //b: String = oranges
  //c: String = grapes
  //If you know do not know the number of items
  //scala> val (a :: b :: rest) = fruit
  //a: String = apples
  //b: String = oranges
  //rest: List[String] = List(grapes)


  //:: and ... are constructor patterns
  // x :: xs is treated as ::(x,xs) :: is a class like UnOp()

  def appendList[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case List() => ys
    case x :: xs => appendList(xs, x :: ys)
  }

  def revList[T](xs: List[T]): List[T] = xs match {
    case Nil => Nil
    case x :: Nil => List(x)
    case x :: xs => revList(xs) ::: List(x)
  }


  //List operations
  //head - gives first element
  //tail - gives everything but the first
  //init - gives everything but the last element
  //last - gives the last element
  //reverse - reverse the list
  //take - returns the list till the position
  //drop - returns the list without the elements till the position
  //splitAt - returns 2 lists by splitting the list at the position mentioned
  //indices - converts the list into a Range
  //flatten - flatens a list of lists
  //scala> val listofLists = List(List(1,2),List(2,3),List(3,4)).flatten
  //listofLists: List[Int] = List(1, 2, 2, 3, 3, 4)

  val list = List(1, 2, 3, 4)

  val listofAlplabets = List('a', 'b', 'c', 'd', 'e')
}
//Zip
//scala> list zip listofAlplabets
//res32: List[(Int, Char)] = List((1,a), (2,b), (3,c), (4,d))

//zipwithIndex
//scala> list.zipWithIndex
//res33: List[(Int, Int)] = List((1,0), (2,1), (3,2), (4,3))

//unzip
//scala> val zipped = list zip listofAlplabets
//zipped: List[(Int, Char)] = List((1,a), (2,b), (3,c), (4,d))

//scala> zipped.unzip
//res38: (List[Int], List[Char]) = (List(1, 2, 3, 4),List(a, b, c, d))


//scala> list.toString
//res39: String = List(1, 2, 3, 4)

//scala> list.mkString("")
//res40: String = 1234

//scala> "abcde".toList
//res41: List[Char] = List(a, b, c, d, e)

//mkstring has a variant mkstring[pre,sep,post]

//scala> "abcde".mkString("[",",","]")
//res42: String = [a,b,c,d,e]

//AddString
//scala> val buf = new StringBuilder
//buf: StringBuilder =

//scala> list.addString(buf, "(",";",")")
//res44: StringBuilder = (1;2;3;4)

//scala> val arr = list.toArray
//arr: Array[Int] = Array(1, 2, 3, 4)

//scala> val list = arr.toList
//list: List[Int] = List(1, 2, 3, 4)


//creating an iterator
//scala> val it = list.iterator
//it: Iterator[Int] = non-empty iterator

//scala> it.next
//res49: Int = 1

//scala> it.next
//res50: Int = 2

//scala> it.next
//res51: Int = 3

//scala> it.next
//res52: Int = 4


//Difference between map and flatMap
//A flatMap is like a Map where it takes a list of elements in it's operand and it applies the function to all elements of the list.
//It then concatenates all the results and then returns it

//flatMap = map + flatten

//scala> fruit.map(_.reverse)
//res57: List[String] = List(selppa, segnaro, separg)

//scala> fruit.flatMap(_.reverse)
//res58: List[Char] = List(s, e, l, p, p, a, s, e, g, n, a, r, o, s, e, p, a, r, g)


//flatmap further example
//scala> List.range(1,5)
//res59: List[Int] = List(1, 2, 3, 4)

//scala> List.range(1,5).map(i => (1,i))
//res60: List[(Int, Int)] = List((1,1), (1,2), (1,3), (1,4))

//scala> List.range(1,5).map(i => List.range(1,i))
//res61: List[List[Int]] = List(List(), List(1), List(1, 2), List(1, 2, 3))

//scala> List.range(1,5).map(i => List.range(1,i) map(j => (i,j)))
//res62: List[List[(Int, Int)]] = List(List(), List((2,1)), List((3,1), (3,2)), List((4,1), (4,2), (4,3)))

//scala> List.range(1,5).flatMap(i => List.range(1,i) map(j => (i,j)))
//res63: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))

//foreach========================================
//scala> var sum = 0
//sum: Int = 0

//scala> list.foreach(sum += _)

//scala> sum
//res73: Int = 10

//scala> list.find(_ % 2 == 0)
//res79: Option[Int] = Some(2)

//scala> list.find(_ % 10 == 0)
//res80: Option[Int] = None

//scala> list.takeWhile(x => x == 3)
//res81: List[Int] = List()

//scala> list.takeWhile(x => x <= 3)
//res82: List[Int] = List(1, 2, 3)

//scala> list.dropWhile(x => x <= 3)
//res83: List[Int] = List(4)

//scala> list.span(x => x <= 3)
//res84: (List[Int], List[Int]) = (List(1, 2, 3),List(4))

//scala> list.partition(x => x == 3)
//res86: (List[Int], List[Int]) = (List(3),List(1, 2, 4))

//folding lists
//Folding lists can be done from two sides /: (left fold) and :\ (right fold). They are used to fold lists to one value

//Fold Left contains (z /: list)(op) where z is the accumulator and op is the operation
// if it is implemented as (z /: List(a,b,c)) (op) then its result will be op(op(op(z,a),b,c)


//Example
//scala> def conWords(list : List[String]) = ("" /: list)(_ + _)
//conWords: (list: List[String])String

//scala> fruit
//res94: List[String] = List(apples, oranges, grapes)

//scala> conWords(fruit)
//res95: String = applesorangesgrapes

//Fold right contains (List :\ z)(op)
//

//sortWith

//scala> List(1,2,3,-5,4,6).sortWith(_<_)
//res121: List[Int] = List(-5, 1, 2, 3, 4, 6)

//Working on multiple lists
//

object listchapterMain {
  def main(args: Array[String]): Unit = {
    val p = new MyList
    println(p.isort(List(10,4,12,15,2)))
  }
}
