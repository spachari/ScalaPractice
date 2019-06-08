package com.programmingscala.examples.implicits

trait Session {
  def names: String
  def isLoggedIn : Boolean
}

class LoggedInSession(name : String) extends Session {
  override def names: String = this.name
  override def isLoggedIn = true
}

class NotLoggedInSession(name : String) extends Session {
  override def names: String = this.name
  override def isLoggedIn = false
}

case class Item(name : String)

object ImplicitsToControlCapabilities extends App {

  val helpItem = Item("Help Item")
  val searchItem = Item("Search Item")
  val viewAccountItem = Item("View Account Item")
  val searchAccountItem = Item("Search Account Item")

  val defaultMenu = Seq(helpItem, searchItem)

  def createMenu (implicit session : Session) = {
    if (session.isLoggedIn == true) {
      val accountsMenu = Seq(viewAccountItem, searchAccountItem)
      val totalMenu = defaultMenu ++ accountsMenu
      (session.names,totalMenu)
    }
    else
      {
        (session.names,defaultMenu)
      }
  }

  val notLoggedInUser = new LoggedInSession("Shankar")

  {
    implicit val loggedInUser = new LoggedInSession("Srinivas")
    val output = createMenu
    output._2.foreach(println)
  }

}
