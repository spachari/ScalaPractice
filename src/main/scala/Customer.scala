
class MyAnyRef(val title : String)
class Publication(title : String) extends MyAnyRef (title)
class Book(title : String) extends Publication(title)

object Library {
  var books : Set[Book] = Set(new Book("Programming in Scala"), new Book("Walden"))

  def printBookList(info : Book => AnyRef) = { //Book can be converted into AnyRef and toString can be used on Books. This is possible because of covariaance
    for (book <- books) {
      println(info(book))
    }
  }
}

object Customer extends App{
def getTitle(p: Publication): String = p.title
  Library.printBookList(getTitle)

  def myGetTitle(q: MyAnyRef) : String = q.title
  Library.printBookList(myGetTitle)

  //The function printBookList takes a type book and gives AnyRef. So this can be used by any class that is greater than Books

  //In Summary, we can pass
  //Publication => String on
  //Book => AnyRef, because
  //trait Function1[-S, +T] {
  //def apply(x: S): T
  //}
}
