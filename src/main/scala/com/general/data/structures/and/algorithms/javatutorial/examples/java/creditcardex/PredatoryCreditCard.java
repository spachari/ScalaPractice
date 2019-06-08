package com.general.data.structures.and.algorithms.javatutorial.examples.java.creditcardex;

public class PredatoryCreditCard extends CreditCard {

    double apr ;

    PredatoryCreditCard(String name,
                        String bank,
                        String account,
                        int limit,
                        double balance,
                        double apr
                        ) {
        super(name, bank, account, limit,balance);
        this.apr = apr;
    }

    public void processMonth() {
        if (balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 /12);
            balance *= monthlyFactor;
        }
    }

    public boolean charge(Double price) {
        boolean isSuccess = super.charge(price);
        if (!isSuccess)
            balance += 5;
            return isSuccess;
    }
}


class PredatoryCreditCardTest {
    public static void main(String[] args) {
        PredatoryCreditCard card = new PredatoryCreditCard("Srinivas Pachari", "HSBC Premier", "1234567890", 10000, 1000, 17.5);

        card.processMonth();
        card.charge(100.0);

        CreditCard.printSummary(card);

        //On the other hand
        CreditCard card1 = new PredatoryCreditCard("Srinivas Pachari", "HSBC Premier", "1234567890", 10000, 1000, 17.5);

        //Can call this
        card1.charge(100.00);
        CreditCard.printSummary(card1);

        //cannot do this
        //card1.processMonth();

        //But can do this
        ((PredatoryCreditCard) card1).processMonth();

    }
}