package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import java.util.ArrayList;
import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.Comparator;

public class SortedTableMap<K,V> extends AbstractSortedMap<K,V> {
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

    public SortedTableMap(Comparator comp) { super(comp); }
    public SortedTableMap() { super(); }

    private int findIndex(K key, int low, int high) {
        if (high < low) return high + 1; //this means no match
        int mid = (high + low) / 2;
        int comp = compare(key, table.get(mid));
        if (comp == 0) {
            return mid;
        } else if (comp < 0) {
            return findIndex(key, low, mid - 1);
        } else {
            return findIndex(key, mid + 1, high);
        }
    }

    private int findIndex(K key) { return findIndex(key, 0, table.size() - 1); }


    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        int position = findIndex(key);
        if (position == size() || compare(key, table.get(position)) != 0) { return null; }
        return table.get(position).getValue();
    }

    @Override
    public V put(K key, V value) {
        int position = findIndex(key);
        if (position < size() && compare(key, table.get(position)) == 0) { //position exists
            return table.get(position).setValue(value);
        }
        table.add(position, new MapEntry<>(key, value));
        return null;
    }

    @Override
    public V remove(K key) {
        int position = findIndex(key);
        if (position < size() && compare(key, table.get(position)) == 0) {
            return table.remove(position).getValue();
        }
        return null;
    }

    private Entry<K,V> safeEntry(int i) {
        if (i > 0 && i < table.size())
        {
            return table.get(i);
        }
        return null;
    }

    @Override
    public Entry<K, V> firstEntry() {
        return safeEntry(0);
    }

    @Override
    public Entry<K, V> lastEntry() {
        return safeEntry(table.size());
    }

    @Override
    public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
        return safeEntry(findIndex(key));
    }

    @Override
    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
        int position = findIndex(key);
        if (position < size() && compare(key, table.get(position)) == 0) {
            position--;
        }
        return safeEntry(position);
    }

    @Override
    public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
        return safeEntry(findIndex(key) - 1);
    }

    @Override
    public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
        int position = findIndex(key);
        if (position < size() && compare(key, table.get(position)) == 0) {
            position ++;
        }
        return safeEntry(position);
    }

    private Iterable<Entry<K,V>> snapShot(int startKeyPosition, K stopKey) {
        int endPosition = findIndex(stopKey);
        ArrayList<Entry<K,V>> subTable = new ArrayList<>();
        int counter = 0;
        while(startKeyPosition < size() && (stopKey == null || compare(stopKey, table.get(startKeyPosition)) == 0) )
        {
            subTable.add(table.get(startKeyPosition++));
        }
        return subTable;
    }

    @Override
    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
        return snapShot(findIndex(fromKey), toKey);
    }


    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }




    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return snapShot(0, null);
    }
}
