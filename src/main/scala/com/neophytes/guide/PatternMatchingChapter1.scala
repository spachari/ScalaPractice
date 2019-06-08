package com.neophytes.guide

case class User(firstName : String, lastName : String, marks : Int)

object PatternMatchingChapter1 extends App {

  val students = List(User("Srinivas", "Pachari", 90), User("Sachin", "Pachari", 90), User("Shankar", "Pachari", 100))

  def advance (xs : List[User]) = xs match {
    case User(_,_,score1) :: User(_,_,score2) :: _ => score1 - score2
    case _ => 0
  }

  val result = advance(students)

  println(result)
  //This is possible because of Extractors
  //Types of Extractors
  //Extractor in a case class
  trait User1 {
    def name : String
  }

  class FreeUser(val name : String) extends User1
  class PremiumUser (val name : String) extends User1

  //Let's implement the unapply method
  object FreeUser {
    def unapply(arg: FreeUser): Option[String] = Some(arg.name + s" (From unapply method ${this.getClass.getName})")
  }

  object PremiumUser {
    def unapply(arg: PremiumUser): Option[String] = Some(arg.name + s" (From unapply method  ${this.getClass.getName})")
  }

  //Let's call them
  val freeUser = FreeUser.unapply(new FreeUser("Srinivas"))
  println(freeUser)

  val premiumUser = PremiumUser.unapply(new PremiumUser("Srinivas"))
  println(premiumUser)

  //Let's get a User object
  val user : User1 = new PremiumUser("Srinivas")

  val resultantUser = user match {
    case FreeUser(x) => "Hello " + x
    case PremiumUser(x) => "Welcome back " + x
  }

  println(resultantUser)

  //Extractor with multiple values
  trait User2 {
    def name : String
    def score : Int
  }

  class FreeUser2(val name : String, val score : Int, val upgradeProbability : Double) extends User2
  class PremiumUser2(val name : String, val score : Int) extends User2

  object FreeUser2{
    def unapply(arg: FreeUser2): Option[(String, Int, Double)] = Some(arg.name, arg.score,  arg.upgradeProbability)
  }

  object PremiumUser2 {
    def unapply(arg: PremiumUser2): Option[(String, Int)] = Some(arg.name, arg.score)
  }

val daniel = new FreeUser2("Daniel", 80, 0.7)

  val result3 = daniel match {
    case FreeUser2(x, y, z) if (z < 10.0) => s"What can we do to you " + x
    case PremiumUser2(x,y) => s"Hello " + x
  }

  println(result3)
  
  //A boolean extractor
  println("Boolean extractor tests ... ")

  def sendPremiumInvite (user : FreeUser2) = {
    println(s"Hello Mr. Premium customer ... Welcome ")
  }

  def normalCoadidate(user : PremiumUser2) = {
    println(s"Would you like to upgrade  ${user}")
  }

  object premiumCandidate {
    def unapply(arg: FreeUser2): Boolean = if (arg.upgradeProbability > 0.8) true else false
  }

  val result4 = daniel match {
    case freeUser2 @ premiumCandidate => sendPremiumInvite(freeUser2)
    case freeUser2 if (freeUser2.name == "Srinivas") => sendPremiumInvite(freeUser2)
    case user : PremiumUser2 => normalCoadidate(user)
  }

  println(result4)

  //Infix operations patterns
  val xs = 58 #:: 35 #:: 93 #:: Stream.empty

  xs match {
    case first #:: second #:: _ => first + second
    case _ => 0
  }

  println(xs)

  //Let's see how this works
  val xs1 = 13 :: 14 :: 15 :: 16 :: Nil

  xs1 match {
    case List(a,b, _*) => a * b
    case List(a,b) => a + b
    case _ => 0
  }

  println(xs1)

  object GivenNames {
    def unapplySeq(name : String) : Option[Seq[String]] = {
      val names = name.split(" ")
      println(names.toString)
      if (names.forall(_.isEmpty)) None else Some(names.toSeq)
    }
  }

  val name = "Srinivas pachari Surendranath"
  val name1 = null

  def getFirstName(name : String) =  {
    name match {
      case GivenNames(firstnames, _*) => println(s"Welcome ${firstnames}")
      case _ => "Welcome! Please make sure to fill in your name"
    }
  }

  getFirstName(name)

  //Out own pattern matching - Custom pattern matching
  //What we want is the last string provided to be the firstName and the first string to eb the lastName

  object Names {
    def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
      val names = name.split(" ")
      if (names.length < 2)
         None
      else
        Some(names.last, names.head, names.drop(1).dropRight(1))
    }
  }

  def getFirstNameLastName(name : String) = {
    name match {
      case Names(firstName, lastName , _*) => println(s"Welcome Mr ${firstName}, ${lastName}")
      case _ => println("Please provide a good name")
    }
  }

  getFirstNameLastName(name)

  //Pattern matching expressions in the real world

  case class Player (name : String, score : Int)

  def message (player : Player) = {
    player match {
      case Player(_ , score) if (score >= 3000) => s"Great player with ${score}"
      case Player(name, _) => s"Hey ${name}, you have to score well"
    }
  }

  def printMessage(player : Player) = message(player)

  //Another place where pattern matching happens is in the left hand side of the variable declaration

  def makePlayer (name : String, score : Int) = Player(name, score)

  //We can do it in two ways
  val player = makePlayer("Srinivas", 100)
  println(player.name)
  val Player(_, score) = makePlayer("Srinivas", 18)
  println(score)

  //But be careful with this because we can do this with empty values
  //val list = List()
  // val first :: second = list
  //println(first)

  //THe above will throw an error

  //Another way to use pattern matching is using this tuple
  val (n1, s1) : (String, Int) = ("Srinivas", 100)

  println(n1 + " : " + s1)

  val result5 = ("Srinivas", 100)
  println(result5._1 + " : " + result5._2)

  //Patterns in for comprehension
  //The same thing we did above we can do it in for comprehension generators as well

  val gameResults : Seq[(String,Int)] = ("Daniel", 100) :: ("Matt", 85) :: ("Chris", 70) :: Nil

  val hallOfFame = for {
    (name, score) <- gameResults
    if (score > 75)
  } yield Player(name, score)

  println(hallOfFame)

  //Another pattern matching with @
  val lists = List(1,2,3) :: List.empty :: List(1,2) :: Nil

  val outputs = for {
    list @ head <- lists
  } yield list.size

  println(outputs)

  //Let's try that if we do not have a match, then the element will be dropped

  val randomElements : Seq[Any] = ("Daniel", 100) :: ("Matt", 85) :: Player("Chris", 70) :: 85 :: Nil

  val results = for {
    Player(name, score) <- randomElements
  } yield Player(name, score)

  println(results)

  //Pattern matching within anomyous functions
  val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
    ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

  //A pattern matching anonymous function is an anonymous function that is defined as a block consisting of a sequence of cases,
  // surrounded as usual by curly braces, but without a match keyword before the block.
  val result6 = wordFrequencies.filter { case (word, frequency) => frequency > 3 && frequency < 25 }
                               .map {case (word, freq) => word}

  println(result6)

}
