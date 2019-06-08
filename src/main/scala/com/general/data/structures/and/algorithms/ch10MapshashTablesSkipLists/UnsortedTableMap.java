package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.ArrayList;
import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K,V> extends AbstractMap<K,V> {
    private ArrayList<MapEntry<K,V>> arrayList = new ArrayList<>();

    public UnsortedTableMap() {}

    public int findKey(K key) {
        int sizeOfArray = arrayList.size();
        for (int i = 0; i <= arrayList.size(); i ++) {
            Entry<K,V> currentEntry = arrayList.get(i);
            if (currentEntry.getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return (arrayList.size() == 0);
    }

    @Override
    public V get(K key) {
        int position = findKey(key);
        if (position != -1) {
            return arrayList.get(position).getValue();
        } else {
            return null;
        }
    }

    @Override
    public V put(K key, V value) {
        int position = findKey(key);
        MapEntry<K,V> mapEntry = new MapEntry<>(key, value);
        if (position != -1) {
            arrayList.get(position).setValue(value);
            return value;
        } else {
            arrayList.add(arrayList.size() + 1, mapEntry );
            return null;
        }
    }

    @Override
    public V remove(K key) {
        int position = findKey(key);
        if (position == -1) return null;
        int s = size();
        V answer = arrayList.get(position).getValue();
        if (position != s - 1) {
            arrayList.set(position, arrayList.get(s - 1));
        }
        arrayList.remove(s - 1);
        return answer;
    }

    public class EntryIterator implements Iterator<Entry<K,V>> {

        private int j = 0;
        @Override
        public boolean hasNext() {
            return j < arrayList.size();
        }

        @Override
        public Entry<K, V> next() {
            MapEntry<K,V> mapEntry = null;
            if (j == arrayList.size()) { throw new NoSuchElementException(); }
            return  arrayList.get(j++);
        }
    }

    public class EntryIterable implements Iterable<Entry<K,V>> {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}