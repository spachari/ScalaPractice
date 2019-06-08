package com.general.data.structures.and.algorithms.javatutorial.ternaryOperator;

public class TernaryOperator {
    public static void main(String[] args) {
        //Classical if statement only can do side effects
        String stringName = "";
        if (stringName == "") {
            stringName = "My String";
        }

        //This can help us write if as an expression than a statement (functional style)
        String stringName2 = (stringName == "") ? "My String" : stringName;

        System.out.println(stringName2);
    }
}
