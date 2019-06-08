val totalRecords = 100

for ( i <- 1 to 100000 by 10000)
{
  println(i + " " + (i.toInt + 10000 - 1))
}

val array = Array (1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17)
array.length

val item = array(1)





class number(a : Int)
{
  val b = this.a

  def addition ( that: number) : (String,String) =
  {
    ("that is " + that.b,"this is " + this.b)
  }
}



    val a = new number(1)
    val b = new number(2)

a addition(b) //in this call this is 1 and that is 2
//a is this and on top of the a implement b. So in this call this is 1 and that is 2


