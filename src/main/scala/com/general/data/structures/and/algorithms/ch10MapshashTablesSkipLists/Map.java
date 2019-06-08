package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

public interface Map<K,V> {
    int size();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<Entry<K,V>> entrySet();
}
