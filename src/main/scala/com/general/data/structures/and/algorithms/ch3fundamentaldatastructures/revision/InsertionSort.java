package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.revision;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

public class InsertionSort {
    public int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            //get current element and index in temp variables
            int j = i;
            int currentValue = array[i];

            while(j > 0 && array[j - 1] > currentValue) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = currentValue;
        }
        return array;
    }
}


class InsertionSortTest {
    public static void main(String[] args) {
        int[] array = new int[] {4,10,8,1,2,3};
        Utilities.printIntArray(array);
        InsertionSort i = new InsertionSort();
        int[] output = i.insertionSort(array);
        Utilities.printIntArray(output);
    }
}