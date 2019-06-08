package com.scalaCookbook.examples.WebServices.json4s

import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

object ConvertingobjectstoJson4S extends App {

  case class Winner(id: Long, numbers: List[Int])
  case class Lotto(id: Long, winningNumbers: List[Int], winners: List[Winner], drawDate: Option[java.util.Date], shop : Shop)
  case class Shop(name : String, area : Area)
  case class Area(name : String)

  val winners = List(Winner(23, List(2, 45, 34, 23, 3, 5)), Winner(54, List(52, 3, 12, 11, 18, 22)))
  val lotto = Lotto(5, List(2, 45, 34, 23, 7, 5, 3), winners, None, Shop("New Market", Area("Addington")))

  val json = ("lotto" ->
    ("id" -> lotto.id) ~
      ("winningNumbers" -> lotto.winningNumbers) ~
      ("draw-date" -> lotto.drawDate.map(_.toString)) ~
      ("winners" ->
        (lotto.winners.map { f =>
        ("winner-id" -> f.id) ~
          ("winner_numbers" -> f.numbers)})) ~
      ("shop" -> lotto.shop.name) ~
      ("area" -> (lotto.shop.area.name))
    )

  println(pretty(render(json)))

}
