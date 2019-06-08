package com.general.data.structures.and.algorithms.ch12SortingAndSearching.mergesort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

class Merge {

    public int[] merge(int[] array1, int[] array2) {
        int array1Length = array1.length;
        int array2Length = array2.length;
        int array1Counter = 0; int array2Counter = 0; int outputArrayCounter = 0;
        int[] outputArray = new int[array1Length + array2Length];

        //Comparision is complete
        while (array1Counter < array1Length && array2Counter < array2Length) {
            if (array1[array1Counter] < array2[array2Counter]) {
                outputArray[outputArrayCounter++] = array1[array1Counter++]; //Add and increment the numbers
            } else {
                outputArray[outputArrayCounter++] = array2[array2Counter++];
            }
        }
        //Utilities.printIntArray(outputArray);

        //Load the rest of them
        while(array1Counter < array1Length || array2Counter < array2Length) {
            if (array1Counter < array1Length)
                outputArray[outputArrayCounter++] = array1[array1Counter++];
            else
                outputArray[outputArrayCounter++] = array2[array2Counter++];
        }

        //THis is just for explanation, here it will do nothing.
        //Alternate way of merging lists

        for (;array1Counter < array1Length; array1Counter++) {
            outputArray[outputArrayCounter++] = array1[array1Counter];
        }

        for (;array2Counter < array2Length; array2Counter++) {
            outputArray[outputArrayCounter++] = array2[array2Counter];
        }

        return outputArray;
    }

    private int[] makeNewArray(int[] arr, int startPoint) {
        int[] newArray1 = new int[arr.length - startPoint];
        int counter = 0;
        for (int i = startPoint; i < arr.length; i ++) {
            newArray1[counter++] = arr[i];
        }
        return newArray1;
    }

    private int[] getNonNullElements(int[] arr) {
        int counter = 0;
        for (int i : arr) {
            if (i != 0) {
                counter++;
            }
        }
        int[] outputArray = new int[counter];
        for (int j = 0; j < counter ; j ++) {
            outputArray[j] = arr[j];
        }

        return outputArray;
    }

    public int[] threeWayMerge(int[] array1, int[] array2, int[] array3) {

        int array1Length = array1.length;
        int array2Length = array2.length;
        int array3Length = array3.length;
        int array1Counter = 0,array2Counter = 0, array3Counter = 0;
        int outputArrayCounter = 0;
        int[] outputArray = new int[array1Length + array2Length + array3Length];

        //Compare three equal array elements
        while (array1Counter < array1Length && array2Counter < array2Length && array3Counter < array3Length) {
            if (array1[array1Counter] < array2[array2Counter] && array1[array1Counter] < array3[array3Counter]) { //array[1] is smaller
                System.out.println(array1[array1Counter]);
                outputArray[outputArrayCounter++] = array1[array1Counter++]; //set the value of
                                                                             // array1Counter to output array and increment it as well
            } else if (array2[array2Counter] < array1[array1Counter] && array2[array2Counter] < array3[array3Counter]) {
                System.out.println(array2[array2Counter]);
                outputArray[outputArrayCounter++] = array2[array2Counter++];
            } else  {
                System.out.println(array3[array3Counter]);
                outputArray[outputArrayCounter++] = array3[array3Counter++];
            }
        }

        outputArray = getNonNullElements(outputArray);


        int[] remAr1 = makeNewArray(array1, array1Counter);
        Utilities.printIntArray(remAr1);

        int[] remAr2 = makeNewArray(array2, array2Counter);
        Utilities.printIntArray(remAr2);

        int[] remAr3 = makeNewArray(array3, array3Counter);
        Utilities.printIntArray(remAr3);

        Utilities.printIntArray(outputArray);

        if (array1Counter < array1Length) {
            outputArray = merge(outputArray, remAr1);
        }

        if (array2Counter < array2Length) {
            outputArray = merge(outputArray, remAr2);
        }

        if (array3Counter < array3Length) {
            outputArray = merge(outputArray, remAr3);
        }

        return outputArray;

    }

    public int[] twoWayMerge(int[] array1, int[] array2, int[] array3) {
        int[] tempArray = merge(array1, array2);
        return  merge(tempArray, array3);
    }

}

public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,7};
        int[] arr2 = new int[]{2,4,6,8,10,12};
        int[] arr3 = new int[]{11,13,15};

        Merge m = new Merge();
        int[] output = m.merge(arr1, arr2);
        Utilities.printIntArray(output);

        int[] outputArray = m.twoWayMerge(arr1, arr2, arr3);

        Utilities.printIntArray(outputArray);

        int[] outputArray2 = m.threeWayMerge(arr1, arr2, arr3);
        Utilities.printIntArray(outputArray2);

    }
}
