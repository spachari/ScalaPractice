package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

import java.util.Arrays;
import java.util.Random;

public class UtilRandomExample {
    public static void printArray(int[] intArr) {
        for(int i : intArr) {
            System.out.print(" " +i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int data[] = new int[10];

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        for (int i = 0; i < data.length; i ++) {
            data[i] = rand.nextInt(100);
        }

        UtilRandomExample.printArray(data);

        int[] duplicate = Arrays.copyOf(data, 10);

        boolean myBool = Arrays.equals(data, duplicate);

        System.out.println(myBool);

        Arrays.sort(data);

        System.out.println("Are both the arrays equal" + (Arrays.equals(data, duplicate)));
        System.out.println("data " + (Arrays.toString(data)));
        System.out.println("duplicate " + (Arrays.toString(duplicate)));
    }
}
