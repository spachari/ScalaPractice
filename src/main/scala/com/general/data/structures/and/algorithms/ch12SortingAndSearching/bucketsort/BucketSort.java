package com.general.data.structures.and.algorithms.ch12SortingAndSearching.bucketsort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;
import org.datanucleus.store.types.backed.ArrayList;

import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class BucketSort {

    public int getMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i ++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i ++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private Map<Integer, List<Integer>> addMap(Map<Integer, List<Integer>> map, int key, int value) {
        if (map.get(key) == null) {
            List<Integer> listA = new LinkedList();
            listA.add(value);
            map.put(key, listA);
        } else {
            List<Integer> list = map.get(key);
            list.add(value);
            map.put(key, list);
        }
        return map;
    }

    private List<Integer> insertionSort(List<Integer> list) {
        int[] tempArray = new int[list.size()];
        for (int i = 0; i < tempArray.length; i ++) {
            tempArray[i] = list.get(i);
        }

        for (int i = 0; i < tempArray.length; i ++) {
            int temp = tempArray[i]; //get current element
            int j = i; //assign position to a temp variable

            while (j > 0 && temp < tempArray[j - 1]) { //get elements before the current element till end
                tempArray[j] = tempArray[j - 1];       //move it to the current location i.e. right
                j--;
            }
            tempArray[j] = temp;
        }
        Utilities.printIntArray(tempArray);


        List<Integer> sortedList = new LinkedList<>();
        for (int i = 0; i < tempArray.length; i ++) {
            sortedList.add(i, tempArray[i]);
        }

        return sortedList;
    }


    private void printMap(Map<Integer, List<Integer>> map) {
        Set<Integer> list = map.keySet();

        for (Integer i : list) {
            System.out.print(i + " ");
            if (map.get(i) != null) {
                List<Integer> ints =  map.get(i);

                for(Object o : ints) {
                    System.out.print(o + " ");
                }
            }
            System.out.println();
        }
    }

    public int[] convertMapToArray(Map<Integer, List<Integer>> map, int sourceArrayLength) {
        int[] outputArray = new int[sourceArrayLength];

        int counter = 0;
        for (Integer lst : map.keySet()) {
            List<Integer> list = map.get(lst);
            for (int i = 0; i < list.size(); i ++) {
                outputArray[counter++] = list.get(i);
            }
        }
        //Utilities.printIntArray(outputArray);
        return outputArray;
    }

    public int[] bucketSort(int[] array) {
        int max = getMax(array);
        int min = getMin(array);
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        System.out.println(max);
        int divider = (int) Math.ceil((max + 1) / 10);

        for (int i = 0; i < array.length; i ++) {
            int j = (int) Math.floor((array[i] / divider));
            addMap(map, j, array[i]);
        }

        printMap(map);

        Set<Integer> keySet = map.keySet();
        for (Integer lst : keySet) {
            List<Integer> list = map.get(lst);
            List<Integer> sortedList = insertionSort(list);
            map.replace(lst, sortedList);
        }
        System.out.println("After sorting ");
        printMap(map);

        return convertMapToArray(map, array.length);
    }
}

class BucketSortTest {
    public static void main(String[] args) {
        int[] array = new int[] {22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14};
        Utilities.printIntArray(array);

        BucketSort b = new BucketSort();
        int[] output = b.bucketSort(array);
        Utilities.printIntArray(output);
    }
}
