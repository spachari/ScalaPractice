package com.programmingscala.examples.types.path.dependent.types.debashish.ghosh.cake.pattern

import java.util.Date

sealed trait Currency
case object USD extends Currency
case object EUR extends Currency
case object AUD extends Currency

case class Account(no : String, name : String, dateOpenedOn : Date, status : String)


object Defaults {
  val baseCurrency: Currency = USD

  val baseCurrencyFactor: Map[Currency, Double] = Map(USD -> 1, EUR -> 1.3, AUD -> 1.2)
}

//The interesting point to note is that the actual type of Balance has been abstracted in BalanceComponent, since various
// services may choose to use various representations of a Balance. And this is one of the layers of the Cake that we will
// mix finally ..

//Just a note for the uninitiated, a base currency is typically considered the domestic currency or accounting currency.
// For accounting purposes, a firm may use the base currency to represent all profits and losses. So we may have some
// service or component that would like to have the balances reported in base currency.