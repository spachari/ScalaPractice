package com.programmingscala.examples.scalaObjectSystem.overriding.abs.and.conc.methods

trait Widget {
  def draw() : Unit

  override def toString: String = "(widget)"
}

