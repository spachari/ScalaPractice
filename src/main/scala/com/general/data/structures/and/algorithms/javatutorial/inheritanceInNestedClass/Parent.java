package com.general.data.structures.and.algorithms.javatutorial.inheritanceInNestedClass;

public class Parent<K> {
    protected static class Entry<K> {
        K key;

        Entry(K key) {
            this.key = key;
        }

        public void setKey (K key) { this.key = key; }
        public K getKey () { return key; }
    }
}
