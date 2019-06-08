package com.general.data.structures.and.algorithms.sortinganobject;

import org.datanucleus.store.types.backed.Collection;

import java.util.*;

public class SortingBasicIntegers {
    public static void main(String[] args) {
        //SOrting Integers stores in ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(-1);

        System.out.println("Original List " + list);
        Collections.sort(list);
        System.out.println("Original List " + list);

        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(-1);

        System.out.println("Original set " + set);
        Set<Integer> reverseOrderSet = new TreeSet<>(Collections.reverseOrder());

        reverseOrderSet.add(5);
        reverseOrderSet.add(10);
        reverseOrderSet.add(15);
        reverseOrderSet.add(-1);
        System.out.println("Reversed set " + reverseOrderSet);
    }
}
