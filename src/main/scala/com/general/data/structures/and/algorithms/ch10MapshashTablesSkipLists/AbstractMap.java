package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;
import java.util.Iterator;

public abstract class AbstractMap<K,V> implements Map<K,V> {

    public static class MapEntry<K,V> implements Entry<K,V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() { return key; }

        @Override
        public V getValue() { return value; }

        protected void setKey(K key) { this.key = key; }
        protected V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    public class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K,V>> listEntry = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return listEntry.hasNext();
        }

        @Override
        public K next() {
            return listEntry.next().getKey();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class KeyIterable implements Iterable<K> {
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    public class ValueIterator implements Iterator<V> {

        Iterator<Entry<K,V>> valueList = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return valueList.hasNext();
        }

        @Override
        public V next() {
            return valueList.next().getValue();
        }
    }

    public class ValueIterable implements Iterable<V> {
        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }
}
