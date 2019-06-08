package com.general.data.structures.and.algorithms.javatutorial.exceptions;

import java.util.Scanner;

public class ThrowsKeyword {

    public int myParseInt(String s) throws NumberFormatException {
       return Integer.parseInt(s);
    }

    public static void main(String[] args) {

        int finalNumber = 0;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number");
        String str = s.next();
        ThrowsKeyword t = new ThrowsKeyword();
        try {
            int num = t.myParseInt(str);
            finalNumber = num;
        } catch (NumberFormatException numException) { //see even exception is just an object, as
                                                       //long as we capture it, it is all we need for the job to successfully
                                                       //complete our project
        }
        finally {
            System.out.println("The number is " + finalNumber);
        }
    }
}
