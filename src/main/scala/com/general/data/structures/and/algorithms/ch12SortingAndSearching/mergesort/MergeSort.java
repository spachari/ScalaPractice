package com.general.data.structures.and.algorithms.ch12SortingAndSearching.mergesort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

import java.util.Arrays;
import java.util.Comparator;

//https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/tutorial/

public class MergeSort {


    public <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0; int j = 0;

        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
    }

    public <K> K[] mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        //if (n < 2) return S;
        //divide


        int mid = n / 2;
        K[] firstToMid = Arrays.copyOfRange(S,0,mid);
        K[] midToLast = Arrays.copyOfRange(S, mid, n);

        mergeSort(firstToMid, comp);
        mergeSort(midToLast, comp);

        merge(firstToMid, midToLast, S, comp);

        return S;

    }
}


class MergeSortInt {

    public void merge(int[] S1, int[] S2, int[] S) {
        int i = 0; int j = 0;

        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && S1[i] > S2[j])) {
                S[i + j] = S1[i++];
            } else {
                S[i + j] = S2[j++];
            }
        }
    }

    public void mergeSort(int[] S) {
        int n = S.length;
        if (n < 2) return;
        //divide


        int mid = n / 2;
        int[] firstToMid = Arrays.copyOfRange(S,0,mid);
        int[] midToLast = Arrays.copyOfRange(S, mid, n);

        Utilities.printIntArray(firstToMid);
        Utilities.printIntArray(midToLast);

        mergeSort(firstToMid);
        mergeSort(midToLast);

        merge(firstToMid, midToLast, S);

    }
}

class MergeSortIntGetOutput {

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

    public int[] mergeSort(int[] S) {
        int n = S.length;
        if (n < 2) {
            System.out.print("Inside return statement for ");
            Utilities.printIntArray(S);
            return S;
        }

        //divide


        int mid = n / 2;
        int[] firstToMid = Arrays.copyOfRange(S,0,mid);
        int[] midToLast = Arrays.copyOfRange(S, mid, n);

        Utilities.printIntArray(firstToMid);
        Utilities.printIntArray(midToLast);

        mergeSort(firstToMid);
        mergeSort(midToLast);

        return merge(firstToMid, midToLast, S);

    }
}


class MergeSortTest {
    public static void main(String[] args) {
        int[] arr1 = new int[] {2,1,4,5,10,6, 11};

        MergeSortInt m = new MergeSortInt();

        m.mergeSort(arr1);

        MergeSortIntGetOutput m1 = new MergeSortIntGetOutput();
        int[] output = m1.mergeSort(arr1);

        Utilities.printIntArray(output);

    }
}