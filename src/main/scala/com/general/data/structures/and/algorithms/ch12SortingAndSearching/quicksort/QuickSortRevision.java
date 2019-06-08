package com.general.data.structures.and.algorithms.ch12SortingAndSearching.quicksort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

public class QuickSortRevision {
    public int[] swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        return array;
    }

    public int partition(int[] array, int start, int end) {
        int i = start + 1;
        int element = array[start];
        for (int j = start + 1; j < end; j ++) {
            if (array[j] < element) {
                swap(array, i, j);
                Utilities.printIntArray(array);
                i++;
            }
        }
        swap(array, i - 1, start);
        return i - 1;
    }

    public void quicksort(int[] array, int low, int high) {
        int j = 0;
        if (low < high) {
            j = partition(array, 0, high);
            System.out.println("low " + low + " high " + high + "j " + j);
            quicksort(array, low, j - 1);
            quicksort(array, j + 1, high);
        }
    }
}

class QuickSortRevisionTest {
    public static void main(String[] args) {
        QuickSortRevision q = new QuickSortRevision();

        int[] arr1 = new int[] {7,21,15,1,4,5,10,6};
        Utilities.printIntArray(arr1);

        q.quicksort(arr1, 0, arr1.length - 1);

    }
}
