package com.scalatests.examples.sharing.fixtures.utils

import org.scalatest.{BeforeAndAfterEach, Suite}

trait BuilderBeforeAndAfterEach extends BeforeAndAfterEach {
  self : Suite =>

  val builder = new StringBuilder

  override def beforeEach() {
    builder.append("ScalaTest is ")
    super.beforeEach() // To be stackable, must call super.beforeEach
  }


  override def afterEach() {
    try {
      super.afterEach() // To be stackable, must call super.afterEach
    }
    finally {
      builder.clear()
    }
  }
}
