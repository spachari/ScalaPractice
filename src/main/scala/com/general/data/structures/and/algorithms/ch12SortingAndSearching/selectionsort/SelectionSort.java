package com.general.data.structures.and.algorithms.ch12SortingAndSearching.selectionsort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

public class SelectionSort {

    public void selectSort(int[] array) {
        int minElement;
        int minElementPos = 0;
        for (int j = 0; j < array.length; j++) {
            minElement = array[j];

            for (int i = j; i < array.length; i++) {
                System.out.println("Looping for " + array[j] + " " + array[i] + " " + minElement + " " + minElementPos);
                if (minElement > array[i]) {
                    minElement = array[i];
                    minElementPos = i;
                }
            }

            //Now do a swap
            if (array[minElementPos] < array[j]) {
                System.out.println("Swapping " + array[minElementPos] + " " + array[j]);
                int temp = minElement;
                array[minElementPos] = array[j];
                array[j] = temp;
            }


            Utilities.printIntArray(array);
            System.out.println("--------- Iteration complete for " + array[j]);
        }
    }
}

class SelectionSortRef {
    public int[] selectionSort(int[] array) {

        int minElement;
        int minElementPos;
        for (int i = 0; i < array.length; i ++) {
            minElement = array[i];
            minElementPos = i;
            for (int j = i + 1; j < array.length; j ++) {
                if (array[j] < minElement) {
                    minElement = array[j];
                    minElementPos = j;
                }
            }
            //Swap minElementPos and array[j]
            int temp = array[minElementPos];
            array[minElementPos] = array[i];
            array[i] = temp;
            Utilities.printIntArray(array);
        }

        return array;
    }
}


class SelectionSortTest {
    public static void main(String[] args) {
        int[] ints = new int[]{12, 13, 9, 2, 8, 3, 15, 5};
        Utilities.printIntArray(ints);
       // SelectionSort s = new SelectionSort();
       // s.selectSort(ints);

        SelectionSortRef r = new SelectionSortRef();
        Utilities.printIntArray(r.selectionSort(ints));
    }
}
