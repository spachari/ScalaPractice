package com.general.data.structures.and.algorithms.javatutorial.incrementanddecrementoperators;

public class Example1 {
    public static void main(String[] args) {

        //If ++ or -- is used in front of a variable reference, then 1 is added to (or subtracted from) the variable and its value is read
        // into the expression.

        //If it is used after a variable reference, then the value is first read and then the variable is incremented or decremented by 1.

        int i = 10;
        int j = i++;
        System.out.println("i " + i);
        System.out.println("j " + j);
        System.out.println();

        i = 10;
        j = ++i;
        System.out.println("i " + i);
        System.out.println("j " + j);
        System.out.println();

        i = 10;
        j = i--;
        System.out.println("i " + i);
        System.out.println("j " + j);
        System.out.println();

        i = 10;
        j = --i;
        System.out.println("i " + i);
        System.out.println("j " + j);
        System.out.println();
    }
}
