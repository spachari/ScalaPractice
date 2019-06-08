package com.general.data.structures.and.algorithms.javatutorial.examples.java.creditcardex;

public class CreditCard {
    private String name;
    private String bank;
    private String account;
    private int limit;
    protected double balance;

    CreditCard(String name, String bank, String account, int limit, double balance) {
        this.name = name;
        this.account = account;
        this.bank = bank;
        this.limit = limit;
        this.balance = balance;
    }

    CreditCard(String name, String bank, String account, int limit) {
        this(name, bank, account, limit, 0.0);
    }

    public String getName() { return this.name; }
    public String getBank() { return this.bank; }
    public String getAccount() { return this.account; }
    public int getLimit() { return this.limit; }

    public Double makePayment( Double amount) {
        balance = balance - amount;
        return balance;
    }

    public boolean charge(Double price) {
        if ((this.balance - price) > 0.0) {
            this.balance = this.balance - price;
            return true;
        }
        else {
            return false;
        }
    }

    public static void printSummary(CreditCard creditCard) {
        System.out.println("Name " + creditCard.name);
        System.out.println("Bank " + creditCard.bank);
        System.out.println("Account " + creditCard.account);
        System.out.println("Limit " + creditCard.limit);
        System.out.println("Banance " + creditCard.balance);
    }
}

class CreditCardTest {



    public static void main(String[] args) {

        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("Srinivas Pachari", "HSBC Premier", "1234567890", 10000, 1000);
        wallet[1] = new CreditCard("Srinivas Pachari", "HSBC Premier", "2345678901", 1000, 200);
        wallet[2] = new CreditCard("Srinivas Pachari", "HSBC Premier", "4567890123", 10000);

        for (int val = 0; val <= 16; val ++) {
            wallet[0].charge(3.0 * val);
            wallet[1].charge(2.0 * val);
            wallet[2].charge(3.0 * val);
        }


        for (CreditCard creditCard : wallet) {
            CreditCard.printSummary(creditCard);
        }
    }
}
