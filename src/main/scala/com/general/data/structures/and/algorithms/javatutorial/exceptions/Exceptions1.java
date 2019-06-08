package com.general.data.structures.and.algorithms.javatutorial.exceptions;


public class Exceptions1 {
    public static void main(String[] args) {
        int n = 0;

        try {
            int num = Integer.parseInt(args[0]);
            if (num < 0) {
                System.out.println("Enter a number greater than 0");
                System.out.println("Setting a value of num to 0");
            } else {
                n = num;
            }

        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("There is no value prvided for the input");
            a.printStackTrace();
        } catch (NumberFormatException b) {
            System.out.println("Not a valid number");
            b.printStackTrace();
        }

        System.out.println("Final ans is " + n / 2);
    }
}
