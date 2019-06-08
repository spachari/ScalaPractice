package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

public class CostPerformanceDatabase {

    SortedMap<Integer, Integer> map = new SortedTableMap<>();

    public CostPerformanceDatabase() {}

    public Entry<Integer, Integer> best(int cost) {
        return map.floorEntry(cost);
    }

    public void add(int cost, int performance) {
        Entry<Integer, Integer> other = map.floorEntry(cost);

        if (other != null && other.getKey() >= performance) {
            return;
        }
        map.put(cost,performance);

        other = map.higherEntry(cost);
        while (other != null && other.getValue() <= performance) {
            map.remove(other.getKey());
            other = map.higherEntry(cost);
        }
    }

}
