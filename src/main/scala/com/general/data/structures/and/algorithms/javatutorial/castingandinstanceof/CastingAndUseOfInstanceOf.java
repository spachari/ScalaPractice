package com.general.data.structures.and.algorithms.javatutorial.castingandinstanceof;

public class CastingAndUseOfInstanceOf {

    public static void main(String[] args) {
        Number n;
        Integer i;

        n = new Integer(10);

        //Let's do a narrow.
        i = (Integer) n;

        //Any conversion will only work in java when the casting follows a "is a" conversion

        //This will not work
        //Double d = (Double) n;
        //java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Double


        //instanceOf can help us to identify this problem during compile time

        Integer i1;
        if (n instanceof Integer) {
            i1 = (Integer) n;
            System.out.println("i1 is " + i);
        }

        Integer i2;
        //i2 = n instanceof Double; //here we are checking if n is Double during compile time itself and it will not compile

        if (n instanceof Double) { //here we are checking if n is Double during compile time itself
            i2 = (Integer) n;
        }
        else {
            System.out.println("Cannot perform conversion");
        }


    }

}
