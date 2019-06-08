package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

public interface SortedMap<K,V> extends Map<K,V> {
    public Entry<K,V> firstEntry();
    public Entry<K,V> lastEntry();
    public Entry<K,V> ceilingEntry(K key) throws IllegalArgumentException;
    public Entry<K,V> floorEntry(K key) throws IllegalArgumentException;
    public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException;
    public Entry<K,V> higherEntry(K key) throws IllegalArgumentException;

    Iterable<Entry<K,V>> subMap(K fromKey, K toKey) throws IllegalArgumentException;
}
