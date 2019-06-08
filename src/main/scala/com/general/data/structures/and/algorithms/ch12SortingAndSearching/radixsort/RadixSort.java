package com.general.data.structures.and.algorithms.ch12SortingAndSearching.radixsort;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;
import com.srinivas.utils.StringUtils;
import org.apache.commons.collections.map.LinkedMap;
import scala.tools.scalap.scalax.util.StringUtil;

import java.util.*;

public class RadixSort {

    private int getMaxItem(int[] array) {
        int max = array[0];
        for(int i = 0; i < array.length; i ++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private String lPad(int number, int maxElement) {
        String itemAsString = Integer.toString(number);
        int digitsToPad = Integer.toString(maxElement).length();
        StringBuilder sb = new StringBuilder(itemAsString);
        while(sb.length() < digitsToPad) {
            sb.insert(0, "0");
        }

        return sb.toString();
    }

    private String[] convertIntToPaddedStringArray(int[] array, int maxElement) {
        String[] output = new String[array.length];
        for (int i = 0; i < array.length; i ++) {
            output[i] = lPad(array[i], maxElement);

        }

        for (String s : output) {
            System.out.print(s + " ");
        }
        System.out.println();
        return output;
    }

    private void printMap(Map<Integer, List<String>> map) {
        List<String> templist = new ArrayList<>();
        List<String> defaultList = new ArrayList<>();
        defaultList.add("null");
        for (Integer i : map.keySet()) {
            System.out.print(i + "\t");
            if (map.get(i) != null) {
                List<String> str =  map.getOrDefault(i, defaultList);
                for (String s : str) {
                    System.out.print(s + "\t");
                }
                System.out.println();
            } else {
                for (String s : defaultList) {
                    System.out.println(s);
                }
            }
        }
        System.out.println();
        for (String str : templist) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    private String[] sortBasedOnDigit(String[] array, int digit) {
        Map<Integer, List<String>> map = new LinkedMap();
        for(int i = 0; i < 10; i ++) {
            map.put(i, null);
        }


        for (String s : array) {
            Integer i = Integer.parseInt(String.valueOf(s.charAt(digit)));
            if (map.get(i) == null) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.replace(i, list);
            } else {
                List<String> list = map.get(i);
                list.add(s);
                map.replace(i, list);
            }
        }
        printMap(map);

        int stringCoutner = 0;
        String[] stringArray = new String[array.length];
        for (Integer i : map.keySet()) {
            if (map.get(i) != null) {
                for (String s : map.get(i)) {
                    stringArray[stringCoutner++] = s;
                }
            }
        }

        for (String s : stringArray) {
            System.out.print(s + "\t");
        }
        System.out.println();
        return stringArray;
    }

    private int[] convertStringArrayToInt(String[] stringArray) {
        int[] intArray = new int[stringArray.length];
        int counter = 0;

        for (String s : stringArray) {
            intArray[counter++] = Integer.parseInt(s);
        }
        return intArray;
    }


    public int[] radixSort(int[] array) {
        int[] outputArray = new int[array.length];
        int max = getMaxItem(array);
        String[] stringArray = convertIntToPaddedStringArray(array, max);

        String maxItem = String.valueOf(max);

        for (int i = maxItem.length() - 1; i >= 0; i --) {
            stringArray = sortBasedOnDigit(stringArray, i);
        }

        outputArray = convertStringArrayToInt(stringArray);
        return outputArray;
    }
}

class RadixSortTest {
    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 1, 60, 5, 100, 25, 50};
        RadixSort r = new RadixSort();
        int[] output = r.radixSort(array);

        Utilities.printIntArray(output);
    }
}