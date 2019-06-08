package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Srinivas");
        map.put(2, "Sachin");
        map.put(3, "Shankar");

        System.out.println(map.get(4));
        System.out.println(map.get(3));

        //System.out.print(map.get(4).getClass());
        System.out.println(map.get(3).getClass());
        if (map.get(4) == null) {
            System.out.println("Null value");
        }
    }
}
