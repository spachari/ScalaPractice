package com.programmingscala.examples.types.selfrecursive

//Seq[T] --------> Seq[T] forSome {type T}
//Seq[_ <: A] ---------> Seq[T] forSome {type T <: A}

//List[T forSome { type T <: Account[T]}] means any subtype that
//


trait Account[T <: Account[T]] {
  def addFunds(amount : BigDecimal): T
}

class BrokerageAccount(total : BigDecimal) extends Account[BrokerageAccount] {
  override def addFunds(amount: BigDecimal) = {
    new BrokerageAccount(amount + total)
  }
}

class SavingsAccount(total : BigDecimal) extends Account[SavingsAccount] {
  override def addFunds(amount: BigDecimal): SavingsAccount = {
    new SavingsAccount(amount + total)
  }
}

object Account {
  val feePercentage = BigDecimal("0.02")
  val feeThreshold = BigDecimal("10000.00")

  def deposit[T <: Account[T]](amount : BigDecimal, account : T)  = {
    val output = if (amount < feeThreshold)
      {
        account.addFunds(amount - (amount * feePercentage))
      }
    else {
      account.addFunds(amount)
    }
    output.asInstanceOf[Account[T]]
  }

  //what if we want to implement this for a list of Accounts, how will we mention the types
  def debitAll
  (amount : BigDecimal, accounts : List[T forSome { type T <: Account[T]}])
  = {
    accounts.map(_.addFunds(-amount))
  }

  //THe difference between this and the above is that debitAll2 expects all Ts to be the same
  def debitAll2[T <: Account[T]](amount: BigDecimal, accounts: List[T]): List[T] = {
    accounts map { _.addFunds(-amount) }
  }

}


object FBoundedTypesExample  extends App {

  val brokerageAccount = new BrokerageAccount(100000)
  val brokerageAccount1 = new BrokerageAccount(100000)
  val savingsAccount = new SavingsAccount(100000)

  val listOfAccounts = List(brokerageAccount, brokerageAccount1)

  val output = Account.debitAll(BigDecimal("10.00"), List[T forSome { type T <: Account[T] }](brokerageAccount, brokerageAccount1, savingsAccount))

  //Wont compile
  //val output2 = Account.debitAll2(BigDecimal("10.00"), List[T forSome { type T <: Account[T] }](brokerageAccount, brokerageAccount1))

  output.foreach(println)

}
