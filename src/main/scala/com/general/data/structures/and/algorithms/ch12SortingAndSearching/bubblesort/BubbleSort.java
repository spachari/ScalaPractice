package com.general.data.structures.and.algorithms.ch12SortingAndSearching.bubblesort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;


//https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/tutorial/

public class BubbleSort {
    public void bubblesort(int[] array) {

        Utilities.printIntArray(array);

        for (int j = 0; j < array.length - 1 ; j ++) {
            for (int i = 0; i < array.length - j - 1 ; i ++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        Utilities.printIntArray(array);
    }
}

class BubbleSortTest {
    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] ints = new int[]{13,4,25,6,12, 10, 29, 6};
        b.bubblesort(ints);
    }
}
