package com.general.data.structures.and.algorithms.ch5recursion.linear;

public class Power {
    public int power(int number, int raiseTo) {
        if (raiseTo == 0) {
            return 1;
        }
        else {
            System.out.println("power(" + number + ", " + raiseTo +  ") * " +  number);
            return power(number, raiseTo - 1) * number;
        }
    }

    public double powerInt(int number, int raiseTo) {
        if (raiseTo == 0) {
            return 1;
        }
        else {
            double partial = power(number, raiseTo / 2);
            double result = partial * partial;
            System.out.println("number " + number + " raiseTo " + raiseTo + " partial " + partial + " result " + result);

            if ((raiseTo % 2) == 1) {
                result *= raiseTo;
            }
            return result;
        }
    }
}

class PowerTest {
    public static void main(String[] args) {
        Power power = new Power();
        System.out.println(power.power(5,5));
        System.out.println("Calculating the other way ... ");
        System.out.println(power.powerInt(5, 5));

    }
}
