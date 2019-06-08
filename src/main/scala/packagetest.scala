package bobsrockets {
  class Ship
}


package bobsrockets.fleets
{
  class Fleet
  {
    // Doesn't compile! Ship is not in scope.
    def addShip() = { new bobsrockets.Ship }
  }
}