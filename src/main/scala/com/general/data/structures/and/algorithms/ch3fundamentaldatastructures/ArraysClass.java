package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

import java.util.Arrays;

public class ArraysClass {


    public static void printArray(int[] intArr) {
        for(int i : intArr) {
            System.out.print(" " +i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int intArr[] = {100,20,4,30,5};
        int intArr1[] = {100,20,4,30,5};

        Arrays.sort(intArr);

        ArraysClass.printArray(intArr);

        boolean isTrue = Arrays.equals(intArr, intArr1);
        System.out.println(isTrue);

        int[] testArr = new int[20];

        Arrays.fill(testArr, 20);
        ArraysClass.printArray(testArr);

        int[] copyOfintArr = Arrays.copyOf(testArr, 10);
        ArraysClass.printArray(copyOfintArr);

        int[] copyOfintArr1 = Arrays.copyOf(testArr, 30);
        ArraysClass.printArray(copyOfintArr1);

        String str = Arrays.toString(intArr);

        System.out.println(str);


        int searchedInt = Arrays.binarySearch(intArr, 20);
        System.out.println(searchedInt);

        int intArr3[] = {100,20,4,30,5};
        int intArr4[] = {100,20,4,30,5};

        System.out.println(Arrays.equals(intArr3, intArr4));
        System.out.println(intArr3 == intArr4);
        System.out.println(intArr3.equals(intArr4));

        int intArr5[][] = new int[2][2];
        intArr5 = new int[][]{
                {1,1},
                {1,2}
        };
        int intArr6[][] = new int[2][2];
        intArr6 = new int[][]{
                {1,1},
                {1,2}
        };

        System.out.println(intArr5.equals(intArr6));
        System.out.println(Arrays.deepEquals(intArr5, intArr6));

    }

}
