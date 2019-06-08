package com.programmingscala.examples.types.path.dependent.types.debashish.ghosh.cake.pattern.actualcode


import java.util.{Calendar, Date}
object cake {

  sealed trait Currency
  case object USD extends Currency
  case object EUR extends Currency
  case object AUD extends Currency

  val baseCurrency: Currency = USD

  val baseCurrencyFactor: Map[Currency, Double] = Map(USD -> 1, EUR -> 1.3, AUD -> 1.2)

  case class Account(no: String, name: String, openedOn: Date, status: String)

  trait BalanceComponent {
    type Balance

    def balance(amount: Double, currency: Currency, asOf: Date): Balance
    def inBaseCurrency(b: Balance): Balance
  }

  trait SimpleBalanceComponent extends BalanceComponent {
    type Balance = (Double, Currency, Date)
    override def balance(amount: Double, currency: Currency, asOf: Date) = (amount, currency, asOf)
    override def inBaseCurrency(b: Balance) =
      ((b._1) * baseCurrencyFactor.get(b._2).get, baseCurrency, b._3)
  }

  trait CustomBalanceComponent extends BalanceComponent {
    type Balance = BalanceRep
    case class BalanceRep(amount: Double, currency: Currency, asOf: Date)
    override def balance(amount: Double, currency: Currency, asOf: Date) =
      BalanceRep(amount, currency, asOf)
    override def inBaseCurrency(b: Balance) =
      BalanceRep((b.amount) * baseCurrencyFactor.get(b.currency).get, baseCurrency, b.asOf)
  }

  trait Portfolio { //This trait already contains BalanceComponent
    val balanceComponent: BalanceComponent
    import balanceComponent._

    def currentPortfolio(account: Account): List[Balance]
  }

  trait ClientPortfolio extends Portfolio {
    val balanceComponent: BalanceComponent
    import balanceComponent._ //This import is for using balance

    override def currentPortfolio(account: Account) = {
      //.. actual impl will fetch from database
      List(
        balance(1000, EUR, Calendar.getInstance.getTime),
        balance(1500, AUD, Calendar.getInstance.getTime)
      )
    }
  }

  trait Auditing extends Portfolio {
    val semantics: Portfolio
    val balanceComponent: semantics.balanceComponent.type
    import balanceComponent._ //All this is 1. Because we need to use inBaseCurrency from BalanceComponent
                                          //2. also we are getting balanceComponent from PortFolio


    override def currentPortfolio(account: Account) = {
      semantics.currentPortfolio(account) map inBaseCurrency
    }
  }

  object SimpleBalanceComponent extends SimpleBalanceComponent
  object CustomBalanceComponent extends CustomBalanceComponent

  object ClientPortfolioAuditService1 extends Auditing {
    val semantics = new ClientPortfolio { val balanceComponent = SimpleBalanceComponent }
    val balanceComponent: semantics.balanceComponent.type = semantics.balanceComponent
  }

  object ClientPortfolioAuditService2 extends Auditing {
    val semantics = new ClientPortfolio { val balanceComponent = CustomBalanceComponent }
    val balanceComponent: semantics.balanceComponent.type = semantics.balanceComponent
  }
}


object Test extends App {
  import cake._
  ClientPortfolioAuditService1.currentPortfolio(Account("100", "dg", java.util.Calendar.getInstance.getTime, "a"))
}

