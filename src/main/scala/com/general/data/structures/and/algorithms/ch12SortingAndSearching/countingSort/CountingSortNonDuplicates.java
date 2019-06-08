package com.general.data.structures.and.algorithms.ch12SortingAndSearching.countingSort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;
import org.apache.commons.collections.map.LinkedMap;

import java.util.Map;
import java.util.Set;

public class CountingSortNonDuplicates extends AbstractCountingSort{

    public int[] countingSort(int[] array) {
        int min = getMin(array);
        int max = getMax(array);

        System.out.println(min);
        System.out.println(max);

        //Create a collection between 3 and 20
        Map<Integer, Integer> map = new LinkedMap();
        int tempCounter = min;
        while (tempCounter <= max) {
            int isPresent = findElementInArray(array, tempCounter);
            map.put(tempCounter, isPresent);
            tempCounter++;
        }
        printMap(map);

        //Iterate through each key and add all values and set the total till that key to each key
        int total = 0;
        Set<Integer> keys = map.keySet();
        for (Integer i : keys) {
            int value = map.get(i);
            total = total + value;
            map.replace(i, total);
        }

        printMap(map);

        int[] outputArray = new int[array.length];
        int currValue = 0;
        for (Integer i : array) {
            int temp = map.get(i);
            map.replace(i, --temp);
            outputArray[temp] = i;
        }
        printMap(map);
        return outputArray;
    }
}

class CountingSortTest {
    public static void main(String[] args) {
        CountingSortNonDuplicates c = new CountingSortNonDuplicates();
        int[] array = new int[]{12, 3, 5, 19, 8, 20, 7};
        Utilities.printIntArray(array);

        int[] output = c.countingSort(array);
        Utilities.printIntArray(output);
    }
}