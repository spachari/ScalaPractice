package com.programmingscala.examples.types.path.dependent.types.debashish.ghosh.cake.pattern

import java.util.Calendar

trait Portfolio {
  val bal : BalanceComponent

  import bal._
  def currentPortfolio(account : Account) : List[Balance]
  //The type Balance is actually a path dependent type that can be represented as bal.Balance

}

//Portfolio uses the abstract BalanceComponent and does not commit to any specific implementation. And the Balance
// in the return type of the method currentPortfolio is actually a path dependent type, made to look nice through the
// object import syntax.

trait ClientPortfolio extends Portfolio {
  val bal: BalanceComponent
  import bal._

  override def currentPortfolio(account: Account) = {
    //.. actual impl will fetch from database
    List(
      balance(1000, EUR, Calendar.getInstance.getTime),
      balance(1500, AUD, Calendar.getInstance.getTime)
    )
  }
}

trait Auditing extends Portfolio {

  val semantics : Portfolio
  val bal : semantics.bal.type

  import bal._

  override def currentPortfolio(account: Account): List[Balance] = {
    semantics.currentPortfolio(account) map inBaseCurrency
  }

}





object ClientPortfolioAuditService1 extends Auditing {
  val semantics = new ClientPortfolio { val bal = SimpleBalanceComponent }
  val bal: semantics.bal.type = semantics.bal
}

object ClientPortfolioAuditService2 extends Auditing {
  val semantics = new ClientPortfolio { val bal = CustomBalanceComponent }
  val bal: semantics.bal.type = semantics.bal
}