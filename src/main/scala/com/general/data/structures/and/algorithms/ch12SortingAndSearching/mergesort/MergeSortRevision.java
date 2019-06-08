package com.general.data.structures.and.algorithms.ch12SortingAndSearching.mergesort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

import java.util.Arrays;

public class MergeSortRevision {

    public int[] merge(int[] array1, int[] array2) {
        int[] outputArray = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;

        while(i + j < outputArray.length) {
            if (j == array2.length || (i < array1.length && array1[i] < array2[j])) {
                outputArray[i + j] = array1[i++];
            } else {
                outputArray[i + j] = array2[j++];
            }
        }

        return outputArray;
    }



    public int[] mergeSort(int[] array) {

        int n = array.length;
        if (n < 2) {
            return array;
        }

        Utilities.printIntArray(array);

        int mid = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, mid);
        mergeSort(array1);
        int[] array2 = Arrays.copyOfRange(array, mid, array.length);
        mergeSort(array2);
        return merge(array1, array2);
    }

    public int[] merge(int[] S1, int[] S2, int[] S) {
        int i = 0; int j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i] < S2[j])) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
        return S;
    }

    public int[] mergeSort1(int[] array) {

        int n = array.length;
        if (n < 2) {
            System.out.print("Inside return statement for ");
            Utilities.printIntArray(array);
            return array;
        }

        Utilities.printIntArray(array);

        int mid = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, mid);
        mergeSort1(array1);
        int[] array2 = Arrays.copyOfRange(array, mid, array.length);
        mergeSort1(array2);
        return merge(array1, array2, array);
    }
}

class MergeSortRevisionTest {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 7, 9};
        int[] array2 = new int[]{5, 8, 10, 12};

        MergeSortRevision m = new MergeSortRevision();

        int[] ints = new int[]{13, 10, 5, 3, 9, 8, 5, 19};
        Utilities.printIntArray(ints);

        MergeSortRevision m1 = new MergeSortRevision();
        Utilities.printIntArray(m1.mergeSort1(ints));

        Utilities.printIntArray(m1.mergeSort(ints));

    }
}