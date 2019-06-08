package com.general.data.structures.and.algorithms.ch12SortingAndSearching.countingSort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;
import org.apache.commons.collections.map.LinkedMap;
import org.apache.spark.sql.sources.In;

import javax.rmi.CORBA.Util;
import java.util.Map;

public class CountingSortDuplicates extends AbstractCountingSort {

    @Override
    public int[] countingSort(int[] array) {
        int max = getMax(array);
        int min = getMin(array);

        System.out.println(min);
        System.out.println(max);

        Map<Integer, Integer> map = new LinkedMap();
        int tempCounter = min;
        while (tempCounter <= max) {
            if (map.get(tempCounter) == null) {
                int isPresent = findElementInArray(array, tempCounter);
                map.put(tempCounter, isPresent);
            } else {
                int value = map.get(tempCounter);
                map.replace(tempCounter, ++value);
            }
            tempCounter++;
        }
        printMap(map);

        int total = 0;
        for (Integer i : map.keySet()) {
            int temp = map.get(i);
            total = total + temp;
            map.replace(i, total);
        }
        printMap(map);

        int[] outputArray = new int[array.length];

        for (Integer i : array) {
            int position = map.get(i);
            outputArray[--position] = i;
            map.replace(i, position);
        }
        printMap(map);

        return outputArray;
    }
}

class CountingSortDuplicatesTest {
    public static void main(String[] args) {
        CountingSortDuplicates c = new CountingSortDuplicates();
        int[] array = new int[]{12, 3, 5, 19, 8, 20, 7, 5, 12};
        Utilities.printIntArray(array);
        int[] output = c.countingSort(array);

        Utilities.printIntArray(output);

    }
}