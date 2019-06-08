package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.DefaultComparator;
import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.Comparator;

public abstract class AbstractSortedMap<K,V> extends AbstractMap<K,V> implements SortedMap<K,V> {
    private Comparator<K> comp;

    protected AbstractSortedMap(Comparator comp) {
        this.comp = comp;
    }

    protected AbstractSortedMap() {
        this(new DefaultComparator<K>());
    }

    protected int compare(Entry<K,V> entry1, Entry<K,V> entry2) {
        return comp.compare(entry1.getKey(), entry2.getKey());
    }

    protected int compare(K key, Entry<K,V> entry) {
        return comp.compare(key, entry.getKey());
    }

    protected int compare(Entry<K,V> entry, K key) {
        return comp.compare(entry.getKey(), key);
    }

    protected int compare(K key1, K key2) {
        return comp.compare(key1, key2);
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Not a valid key");
        }
    }
}