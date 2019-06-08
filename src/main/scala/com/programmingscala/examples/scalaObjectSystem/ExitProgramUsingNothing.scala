package com.programmingscala.examples.scalaObjectSystem

object ExitProgramUsingNothing {

  val help =
    """
      |usage: java ... objectsystem.ExitProgramUsingNothing arguments
      |where the allowed arguments are:
      |  -h   |  --help          Show help
      |  -i   |  --in    |  --input Path    Path for input
      |  -o   |  --out   |  --output Path   Path for output
    """.stripMargin

  //Important part of program
  def quit(message : String, status : Int) : Nothing = {
    if (message. length > 0) println(message)
    println(help)
    sys.exit(status)
  }

  case class Args(inputPath : String, outputPath : String)

  def parseArgs(args : Array[String]) : Args = {
    def pa(args2 : List[String], result : Args) : Args = args2 match {
      case Nil => result
      case ("-h" | "--help") :: Nil => quit("", 0)
      case ("-i" | "--input") :: path :: tail => pa(tail, result copy (inputPath = path))
      case ("-o" | "--output") :: path :: tail => pa(tail, result copy (outputPath = path))
      case _ => quit(s"Unrecognized argument ${args2.head}", 1)
    }

    val argz = pa(args.toList, Args("",""))

    if (argz.inputPath == "" || argz.outputPath == "") {
      quit("Must specify input path and output path", 2)
    }

    argz
  }

  def main(args: Array[String]): Unit = {
    val argz = parseArgs(args)
    println(argz)
  }

}
