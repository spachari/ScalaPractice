package bobsrockets
{
  package navigation {

    package launch {
      class Booster1
    }

    class MissionControl1 {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets.navigation.launch.Booster1
      val booster3 = new _root_.launch.Booster3
      val booster4 = new launch.Booster2
    }

    package launch {
      class Booster2
    }
  }
}


