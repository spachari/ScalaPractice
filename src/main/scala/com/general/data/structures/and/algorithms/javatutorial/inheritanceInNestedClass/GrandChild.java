package com.general.data.structures.and.algorithms.javatutorial.inheritanceInNestedClass;

public class GrandChild<K> extends Child<K> {
    protected class PQEntry<K> extends Entry<K> {
        public PQEntry(K key) {
            super(key);
        }

        @Override
        public K getKey() {
            return super.getKey();
        }

        @Override
        public void setKey(K key) {
            super.setKey(key);
        }
    }
}
