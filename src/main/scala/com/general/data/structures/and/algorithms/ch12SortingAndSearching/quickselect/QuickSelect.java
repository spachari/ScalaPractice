package com.general.data.structures.and.algorithms.ch12SortingAndSearching.quickselect;

import com.general.data.structures.and.algorithms.ch12SortingAndSearching.quicksort.QuickSort;
import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;
import com.google.common.util.concurrent.UncheckedTimeoutException;

import java.util.Random;

public class QuickSelect {

    public int[] swap (int[] array, int i , int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return array;
    }

    public void partition(int[] array, int start, int end) {
        int randomNumber = (int) ((new Random().nextInt(array.length - 1)));
        System.out.println(randomNumber);

        int pivot = array[start]; //22
        System.out.println("pivot" + pivot);
        int j = start + 1;  //0 + 1
        for (int i = start + 1; i < end; i ++) {
            System.out.println("looping for " + array[i]);
            if (array[i] < pivot) { //is 10 < 22
                System.out.println(array[i] + " is less than " + pivot);
                System.out.println("Swapping " + i + " and " + j);
                array = swap(array, i , j);
                Utilities.printIntArray(array);
                j++;
            }
        }
        swap(array, j - 1, 0);
        Utilities.printIntArray(array);
    }

    public void partitionFromLast(int[] array, int start, int end) {
        int pivot = array[end];
        System.out.println(pivot);

        int j = start;

        for (int i = 0 ; i < array.length; i ++) {
            if (array[i] < pivot) {
                array = swap(array, i, j);
                Utilities.printIntArray(array);
                j++;
            }
        }
        swap(array, j - 1, 0);
        Utilities.printIntArray(array);
    }
}

class QuickSelectTest {
    public static void main(String[] args) {
        int[] array = new int[] {22, 10, 45, 12, 8};
        Utilities.printIntArray(array);

        QuickSelect q = new QuickSelect();
        //q.partition(array, 0, array.length);
        q.partitionFromLast(array, 0, array.length - 1);
    }
}