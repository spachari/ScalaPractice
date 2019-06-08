var x = 0

while(x < 5) {
  var y = 0
  while(y < 5) {
    var z = (x * y).toString
    if (z.contains('4') || z.contains('6')) {
      println(s"$x times $y is $z")
    }
    y = y + 1
  }
  x = x + 1
}