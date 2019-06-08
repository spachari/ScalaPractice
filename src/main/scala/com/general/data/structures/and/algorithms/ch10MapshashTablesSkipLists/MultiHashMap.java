package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class MultiHashMap<K,V> {
    Map<K, List<V>> map = new HashMap();

    int total = 0;
    public MultiHashMap() {}
    public int size() { return total; }

    public boolean isEmpty() { return (total == 0);}

    Iterable<V> get (K key) {
        List<V> values = map.get(key);
        if (values != null) return values;
        return new ArrayList<>();
    }

    void put(K key, V value) {
        List<V> values = map.get(key);
        if (values != null) {
            map.get(values).add(value);
        } else {
            map.put(key, new ArrayList<>(values));
        }
        total++;
    }

    //Removes the (key, value) entry, if exists
    boolean remove(K key, V value) {
        boolean wasRemoved = false;
        List<V> values = map.get(key);
        if (values != null) {
            wasRemoved = values.remove(value); //remove the value from the List<V>
        }
        if (wasRemoved) { //After removing, if value is empty, remove key too
            total--;
            if (values.isEmpty()) {
                map.remove(key);
            }
        }
        return wasRemoved;
    }

    Iterable<V> removeAll(K key) {
        List<V> values = map.get(key);
        if (values != null) {
            total -= values.size();
            map.remove(key);
        } else {
            values = new ArrayList<>();
        }
        return values;
    }

    Iterable<Map.Entry<K,V>> entries() {
        List<Map.Entry<K,V>> result = new ArrayList<>();
        for (Map.Entry<K,List<V>> secondary : map.entrySet()) {
            K key = secondary.getKey();
            for (V value : secondary.getValue()) {
                result.add(new AbstractMap.SimpleEntry<>(key, value));
            }
        }
        return result;
    }
}
