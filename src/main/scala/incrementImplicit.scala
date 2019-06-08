package com.srinivas.utils

import scala.language.implicitConversions

object StringUtils1 {
  implicit class incrementImplicit (s : String) {
    def increment = s.map(c => (c + 1).toChar)
    def decrement = s.map(c => (c - 1).toChar)
  }
}
