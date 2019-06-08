package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

public class InsertionSort {
    public void insertionSort(int[] intArray) {
        System.out.println(" total items in array is " + (intArray.length - 1));
        System.out.println();
        for (int i = 1; i <= intArray.length - 1; i ++) {
            System.out.println("item " + i + " value " + intArray[i] + " n is " + (intArray.length - 1));
            int item = intArray[i];

            //because i will be changing, we need a dedicated variable from the loop
            int j = i;
            //here we are looping through the left of the whole array, from the point of the item.
            while(j > 0 && intArray[j - 1] > item) {
                System.out.println(" j is " + j );
                intArray[j] = intArray[j - 1];
                j--;
            }
            intArray[j] = item;

            //
            System.out.println("Updated array after processing " + i);
            for (int a : intArray) {
                System.out.print(" " + a);
            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Final array ......");

        for (int a : intArray) {
            System.out.print(" " + a);
        }
        System.out.println("");
    }
}


class InsertionSortTest {
    public static void main(String[] args) {
        InsertionSort i = new InsertionSort();
        int[] intArray = new int[]{5,4,3,2,1};
        for (int a : intArray) {
            System.out.print(" " + a);
        }
        System.out.println("");
        i.insertionSort(intArray);
    }
}