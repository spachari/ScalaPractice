package com.programmingscala.examples.types.underscore

case class Animal(name : String)

class Dog (override val name : String) extends Animal(name)
