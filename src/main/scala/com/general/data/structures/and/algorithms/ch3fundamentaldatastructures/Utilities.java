package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

import java.util.Collection;
import java.util.Set;

public class Utilities {

    public static void printArray(char[] intArr) {
        for(char i : intArr) {
            System.out.print(" " +i);
        }
        System.out.println();
    }

    public static void printIntArray(int[] intArr) {
        for(int i : intArr) {
            System.out.print(" " +i);
        }
        System.out.println();
    }

    public static void printCharArray(char[] intArr) {
        for(char i : intArr) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static void printIntSet(Collection<Integer> set) {
        for (Integer i : set) {
            System.out.print(i + "\t");
        }
    }

    public static void printTwoDimensionalArray(int[][] array) {
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int[][] cloneTwoDimensionalArray(int[][] array) {
        int[][] outputArray = new int[array.length][];
        for(int i = 0; i < array.length; i ++) {
                outputArray[i] = array[i].clone();
        }
        return outputArray;
    }

}
