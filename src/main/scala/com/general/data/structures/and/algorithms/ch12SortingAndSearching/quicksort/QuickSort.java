package com.general.data.structures.and.algorithms.ch12SortingAndSearching.quicksort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

public class QuickSort {

    protected static int[] swap(int low, int high, int[] array) {
        Utilities.printIntArray(array);
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;

        //Utilities.printIntArray(array);
        return array;
    }

    public static int partition(int start, int end, int[] array) {
        int pivot = array[start];                       //the first element of the array is the pivot
        int i = start + 1;                              //from the next element, keep a counter of the poistion to swap from
                                                        //After all the swapping is done, this position is where the pivot element will be placed

        //Utilities.printIntArray(array);

        for (int j = start + 1; j <= end; j ++) {
            //System.out.println("Comparing " + array[j] + " and " + pivot + ". i value is " + i);
            if(array[j] <= pivot) {                     //compare each element of j in the array and if value is less than pivot
                swap(i, j, array);                      //swap the position from whereever to the next of pivot
                i += 1;                                 //increment the counter
            }
        }

        swap ( start ,i-1 , array) ;
        return i - 1;
    }

    public void quickSort(int low, int high, int[] array) {
        int j = 0;
        if (low < high) {

            j = partition(low, high, array);
            System.out.println("low " + array[low] + " " + " high " + array[high] + " " +  j);
            quickSort(low, j - 1, array);
            quickSort(j + 1, high, array);
        }

        Utilities.printIntArray(array);
    }
}

class QuickSortTest {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] ints = new int[]{10, 20, 5, 45, 60, 30, 25, 2, 3};
        System.out.println(ints.length);
        q.partition(0, ints.length - 1, ints);
        q.quickSort(0, ints.length - 1, ints);
    }
}
