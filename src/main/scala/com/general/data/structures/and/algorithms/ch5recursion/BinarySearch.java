package com.general.data.structures.and.algorithms.ch5recursion;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

import java.util.Arrays;

public class BinarySearch {

    public void printArrayBetweenPoints(int[] array, int low, int high) {
        System.out.println("low " + low + " high " + high);
        for (int i = low; i < high; i ++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] firstHalfOFAnArray(int[] initialArray) {
        int[] outputArray = new int[initialArray.length / 2];
        for (int i = 0; i < outputArray.length; i ++) {
            outputArray[i] = initialArray[i];
        }
        Utilities.printIntArray(outputArray);
        return outputArray;
    }

    public int[] lastHalfOFAnArray(int[] initialArray) {
        Utilities.printIntArray(initialArray);
        System.out.println("length of array is " + initialArray.length / 2);
        int outputArrayLength = 0;
        if (initialArray.length % 2 == 0) {
            outputArrayLength = (initialArray.length / 2);
        }
        else {
            outputArrayLength = (initialArray.length / 2)  + 1;
        }
        int[] outputArray = new int[outputArrayLength];
        int counter = 0;
        for (int i = initialArray.length / 2; i < initialArray.length; i ++) {

            outputArray[counter] = initialArray[i];
            counter++;
        }
        Utilities.printIntArray(outputArray);
        return outputArray;
    }

    int output = 0;

    public int binarySearch(int[] intArray, int itemToSearch) {

        int centralPosition = intArray.length / 2;
        if (intArray[centralPosition] == itemToSearch) {
            output = itemToSearch;
        }
        else if (intArray.length == 1 && intArray[0] != itemToSearch) {
            output = -1;
        }
        else if (intArray[centralPosition] > itemToSearch) {
            int[] newArray = firstHalfOFAnArray(intArray);
            //int[] newArray = Arrays.copyOf(intArray, intArray.length / 2);
            binarySearch(newArray, itemToSearch);
        }
        else if (intArray[centralPosition] < itemToSearch) {
            int[] newArray = lastHalfOFAnArray(intArray);
            //int[] newArray = Arrays.copyOfRange(intArray, intArray.length / 2, intArray.length);
            binarySearch(newArray, itemToSearch);
        }
        return output;
    }

    public int binarySearchIterative(int[] array, int target) { //array, 0, array.length
        int low = 0;
        int high = array.length - 1;

        while(high >= low) {
            printArrayBetweenPoints(array, low, high);
            int mid = (high + low) / 2;
            if (array[mid] == target) {
                System.out.println("Target Found ...");
                return array[mid];
            } else if ((array[mid] >= target) && !(high - low == 0)) {
                high = mid - 1;
            } else if (array[mid] <= target && !(high - low == 0)) {
                low = mid + 1;
            } else if ((high - low == 0) && (array[mid] != target)) {
                System.out.println("Target Not Found ...");
                target = -1;
                high ++;
            }
        }
        return target;
    }

}

class BinarySearchTest {
    public static void main(String[] args) {

        int[] testArray = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
        BinarySearch b = new BinarySearch();
        System.out.println(b.binarySearch(testArray, 18));
        System.out.println();
        System.out.println();
        System.out.println(b.binarySearchIterative(testArray, 30));

    }
}
