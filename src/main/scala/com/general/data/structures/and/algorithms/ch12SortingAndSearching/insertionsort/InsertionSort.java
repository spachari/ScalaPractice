package com.general.data.structures.and.algorithms.ch12SortingAndSearching.insertionsort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

public class InsertionSort {
    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i ++) {
            int j = i - 1;
            int element = array[i];

            while(j >= 0 && array[j] > element) { //Check only till the point where both j >= 0 and array[i] is greater than array[j]
                array[j + 1] = array[j]; //keep shifting j to the right
                j--;
            }
            array[j + 1] = element; //whereever j is finishing, add array[i] back to it's position
            Utilities.printIntArray(array);
        }

        Utilities.printIntArray(array);
    }
}

class InsertionSortTest {
    public static void main(String[] args) {
        int[] ints = new int[]{12, 13, 9, 2, 8, 3, 15, 5};
        Utilities.printIntArray(ints);

        InsertionSort i = new InsertionSort();
        i.insertionSort(ints);

    }
}