

case class Person(name: String,
                  isMale: Boolean,
                  children: Person*)

object forExpressions extends App {

  val lara = Person("Lara", false)
  val bob = Person("Bob", true)
  val julie = Person("Julie", false, lara, bob)
  val persons = List(lara, bob, julie)

  val personswithchildren = persons.filter(p => p.isMale == false).flatMap(p => (p.children map (c => (p.name, c.name))))

  println(personswithchildren)

  //A for loop has a sequence, generator and a filter
  println(for (p <- persons; //generator It will simply iterate through a list. ex list(persons)
               n = p.name; //definition This definition binds the pattern p.name to the value of n, so it has the same effect as a val definition:
               if (n startsWith("Bo")) //filter
  ) yield n)

  //Using multiple generators
  val v = for (x <- List(1,2); y <- List("one", "two")) yield (x,y)
  for (item <- v) {
    println(item)
  }

}
