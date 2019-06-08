package com.general.data.structures.and.algorithms.ch4algorithmanalysis;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

import java.util.Arrays;

public class CheckIfArrayIsDistinct {
    public boolean isUniqueAllDataCheck(int[] data) {
        for (int i = 0; i < data.length; i ++) {
            for (int j = 0; j < data.length; j ++) {
                if (i != j) {
                    if (data[i] == data[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isUniqueCheckOnce(int[] data) {
        int counter = 0;
        for (int i = 0; i < data.length; i ++) {
            for (int j = i + 1; j < data.length; j ++) {
                System.out.println( "Iteration " + counter + " i " + data[i] + " j " + data[j]);
                counter = counter + 1;
                if (i != j) {
                    if (data[i] == data[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isUniqueSortingMethod(int[] data) {
        int[] temp;
        temp = Arrays.copyOf(data, data.length);
        Arrays.sort(temp);

        for (int i = 0; i < temp.length - 1; i ++) {
            if (temp[i] == temp[i + 1])
                return false;
        }
            return true;
    }
}


class CheckIfArrayIsDistinctTest {
    public static void main(String[] args) {

        int[] array = new int[] {1,2,3,4,1};
        Utilities.printIntArray(array);
        CheckIfArrayIsDistinct ch = new CheckIfArrayIsDistinct();
        System.out.println(ch.isUniqueAllDataCheck(array));
        System.out.println("----------------------------");
        System.out.println(ch.isUniqueCheckOnce(array));
        System.out.println("----------------------------");
        System.out.println(ch.isUniqueSortingMethod(array));
    }
}