package com.general.data.structures.and.algorithms.ch12SortingAndSearching.quicksort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

import static java.lang.Math.random;

public class QuickSortRandPartition {

    private static int rand_partition(int[] array, int low, int high) {
        int rand = (int) (Math.random() * (0 + array.length));
        QuickSort.swap(rand, low, array);
        return QuickSort.partition(low, array.length - 1, array);
    }

    public static void  random_quickSort(int low, int high, int[] array) {
        int r = 0;
        if (low < high) {
            r = rand_partition(array, 0, array.length - 1);
            System.out.println("low " + array[low] + " " + " high " + array[high] + " " +  r);
            random_quickSort(0, r - 1, array);
            random_quickSort(r + 1, array.length, array);
        }


        Utilities.printIntArray(array);
    }
}


class QuickSortRandPartitionTest {
    public static void main(String[] args) {
        QuickSortRandPartition q = new QuickSortRandPartition();
        int[] ints = new int[] {12, 10, 8, 16, 20, 19};
        QuickSortRandPartition.random_quickSort(0, ints.length, ints);
    }
}