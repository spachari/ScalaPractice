package com.general.data.structures.and.algorithms.ch12SortingAndSearching.countingSort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

import java.util.Map;
import java.util.Set;

abstract class AbstractCountingSort {
    public int getMin(int[] array) {
        int element = array[0];
        for (int i = 1; i < array.length; i ++) {
            if (array[i] < element) {
                element = array[i];
            }
        }
        return element;
    }

    public int getMax(int[] array) {
        int element = array[0];
        for (int i = 1; i < array.length; i ++) {
            if (array[i] > element) {
                element = array[i];
            }
        }
        return element;
    }

    public int findElementInArray(int[] array, int element) {
        int counter = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == element) {
                counter++;
            }
        }
        return counter;
    }

    public void printMap(Map<Integer, Integer> map) {
        Set<Integer> keys = map.keySet();
        Utilities.printIntSet(keys);
        System.out.println();
        Utilities.printIntSet(map.values());
        System.out.println();
    }

    abstract public int[] countingSort(int[] array);
}
