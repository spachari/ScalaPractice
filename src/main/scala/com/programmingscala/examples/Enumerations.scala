package com.programmingscala.examples



object Breed extends Enumeration {

  type str = String
  val str = "Srinivas"

  type Breed = Value
  val doberman = Value("doberman")
  val yorkie   = Value("Yorkshire Terrier")
  val scottie  = Value("Scottish Terrier")
  val dane     = Value("Great Dane")
  val portie   = Value("Portuguese Water Dog")


}

object WeekDay extends Enumeration {
  type WeekDay = Value

  val Mon, Tue, Wed, Thu, Fri, Sat, Sun = Value

  //Just like this
  val str1, str2, str3 = "String"
}

object BreedTest extends App {

  import com.programmingscala.examples.Breed.Breed

  for ( b <- Breed.values)
    {
      println(s"breed-id ${b.id} breed-name ${b}")
    }

  println("Printing Terriers")
  Breed.values filter ( x => x.toString.contains("Terrier")) foreach println
  Breed.values.filter(x => x.toString.contains("Terrier")).foreach(println)

  def isTerrier(b : Breed) = b.toString.contains("Terrier")

  Breed.values filter(isTerrier) foreach println

  WeekDay.values foreach(println)

}
