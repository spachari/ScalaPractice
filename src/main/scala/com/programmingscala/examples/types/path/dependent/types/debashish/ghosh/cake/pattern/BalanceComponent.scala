package com.programmingscala.examples.types.path.dependent.types.debashish.ghosh.cake.pattern

import java.util.Date



trait BalanceComponent {
  type Balance

  def balance(amount : Double, currency : Currency, asOf : Date) : Balance
  def inBaseCurrency(b : Balance) : Balance
}


trait SimpleBalanceComponent extends BalanceComponent {
  import Defaults._
  type Balance = (Double, Currency, Date)

  override def balance(amount: Double, currency: Currency, asOf: Date): (Double, Currency, Date) =
    (amount, currency, asOf)

  override def inBaseCurrency(b: Balance): (Double, Currency, Date) =
    ((b._1) * baseCurrencyFactor.get(b._2).get, baseCurrency, b._3)
}

trait CustomBalanceComponent extends BalanceComponent {

  import Defaults._
  type Balance = BalanceRep

  case class BalanceRep(amount : Double, currency : Currency, asOf : Date)

  override def balance(amount: Double, currency: Currency, asOf: Date): BalanceRep =
    BalanceRep(amount, currency, asOf)

  override def inBaseCurrency(b: Balance): Balance =
    BalanceRep((b.amount) * baseCurrencyFactor.get(b.currency).get, baseCurrency, b.asOf)

}

object SimpleBalanceComponent extends SimpleBalanceComponent
object CustomBalanceComponent extends CustomBalanceComponent

object Test extends App {

  println(ClientPortfolioAuditService1.currentPortfolio(Account("100", "dg", java.util.Calendar.getInstance.getTime, "a")))
}
