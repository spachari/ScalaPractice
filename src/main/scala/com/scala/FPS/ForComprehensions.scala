package com.scala.FPS

object ForComprehensions extends App {
  val srini = Name("Srinivas","Pachari","Surendranath")
  val steve = Name("Steve","Roger","Waugh")
  val shane = Name("Shane","Keith","Warne")

  val cricketers = List(shane, srini, steve)


  val output = for {c <- cricketers //generator, it's job is to bind the list to a value
  fName = c.firstName // definition, binds the pattern on the right to the value in the left
  if (fName.startsWith("S")) //filter, filters the value within the pattern
  } yield fName.toUpperCase

  println(output)

  //Normal iterator
  for {c <- cricketers //generator, it's job is to bind the list to a value
       fName = c.firstName // definition, binds the pattern on the right to the value in the left
       if (fName.startsWith("S")) //filter, filters the value within the pattern
  } println(fName)


  //Two generators
  for {i <- Range.apply(1, 3)
      j <- Range.apply('a', 'c')
} println(i, j)


}
