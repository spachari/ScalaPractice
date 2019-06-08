package com.scalaCookbook.examples.Collections

import com.scalaCookbook.examples.Collections.Margin.Margin

object UsingEnumeration extends App {

  val currentMargin = Margin.TOP
  println(currentMargin)

  def checkMargin (margin : Margin) = {
    if (currentMargin == Margin.TOP) {
      println("Margin is Top")
    }
    else if (currentMargin == Margin.BOTTOM) {
      println("Margin is Bottom")
    }
    else if (currentMargin == Margin.LEFT) {
      println("Margin is Left")
    }
  }


  for(s <- Margin.values) {
    println(s)
  }

  checkMargin(currentMargin)


  def getMargin(s : String) : Margin = {
    var margin = Margin.DEFAULT
    if (s.toUpperCase == "TOP") {
      margin = Margin.TOP
    }
    else if (s.toUpperCase == "BOTTOM") {
      margin = Margin.BOTTOM
    }
    else if (s.toUpperCase == "LEFT") {
      margin = Margin.LEFT
    }
    margin
  }

  val l = getMargin("top")

  println(l)
}
