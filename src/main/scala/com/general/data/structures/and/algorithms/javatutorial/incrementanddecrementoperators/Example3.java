package com.general.data.structures.and.algorithms.javatutorial.incrementanddecrementoperators;

public class Example3 {
    public static void main(String[] args) {
        int[] intArr = new int[10];
        int i = 5;
        intArr[i++] = ++i+i++; //Assign 5 to i in intArr[5] and then increment i 3 times!!!

        System.out.println(intArr[5] + " " + intArr[6]);
        System.out.println(i);
    }
}
