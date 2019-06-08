package com.general.data.structures.and.algorithms.javatutorial.generics;

public class ReverseAnArray {
    int[] outputArray;

    public int[] reverse(int[] ints) {
        outputArray = new int[ints.length];
        int j = 0;
        for (int i = ints.length; i > 0; i --) {
            outputArray[j] = ints[i - 1];
            j++;
        }
        return outputArray;
    }
}



class ReverseArrayTest {
    public static void main(String[] args) {
        ReverseAnArray r = new ReverseAnArray();
        int[] arr = {1,2,3,4};
        int[] output = r.reverse(arr);

        for(int i : output) {
            System.out.println(i);
        }
    }
}
