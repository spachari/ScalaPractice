package com.general.data.structures.and.algorithms.ch9priorityqueues;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    protected static class PQEntry<K,V> implements Entry<K,V> {
        K key;
        V value;

        public PQEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() { return key; }

        @Override
        public V getValue() { return value; }

        protected void setKey(K key) {this.key = key; }
        protected void setValue(V value) {this.value = value; }
    }

    private Comparator<K> comp;

    protected AbstractPriorityQueue(Comparator<K> c) { comp = c; }

    protected AbstractPriorityQueue() { this(new DefaultComparator<K>()); }

    protected int compare(Entry<K,V> a , Entry<K,V> b) {
        return ((Comparable<K>) a.getKey()).compareTo(b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);
        } catch (ClassCastException o) {
            throw new ClassCastException("Incompatible key");
        }
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

}
