package com.scalaCookbook.examples


class Database {
  def save = { println("saveing the db state ...")}
  def update = { println("updating the database ...")}
  def delete = { println("deleting the db...")}
}

class Connection

//No need to mention a class as abstract
//We use abstract class because a trait(interface) cannot take variables
abstract class BaseController (db : Database, conn : Connection) {

  def save { db.save }
  def update {db.update }
  def delete { db.delete }

  def connect

  def getStatus : String

  def getServerName (serverName : String)

}

//When any class extends BaseController class it must extend the implement the methods or make it abstract
abstract class BaseController1
