package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.ArrayList;

public class ChainHashMap<K,V> extends AbstractHashMap<K,V> {
    //Here we are creating a UnsortedTableMap array
    int[] intArray; //like this will create an array of integers
    private UnsortedTableMap<K,V>[] table;
    public ChainHashMap() { super(); }
    public ChainHashMap(int cap) { super(cap); }
    public ChainHashMap(int cap, int prime) { super(cap, prime); }


    @Override
    protected void createTable() {
        table =  (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K key) {
        UnsortedTableMap<K,V> element = table[h];
        if (element == null) return null;
        return table[h].get(key);
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        UnsortedTableMap<K,V> element = table[h];
        if (element == null) { //None found. So add the element to the array
            element = table[h] = new UnsortedTableMap<>();
        }
        int oldSize = element.size();
        V answer = element.put(key, value);
        n += element.size() - oldSize;
        return answer;
    }

    @Override
    protected V bucketRemove(int h, K key) {
        UnsortedTableMap<K,V> element = table[h];
        if (element == null) { return null; }
        int oldSize = element.size();
        V answer = remove(key);
        n -= (oldSize - element.size()); //Subtracting the number of elements removed
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty();
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K,V>> list = new ArrayList<>();
        for (int h = 0; h <= capacity; h ++) {
            if (table[h] != null) {
                for (Entry<K,V> entry : table[h].entrySet()) {
                    list.add(entry);
                }
            }
        }
        return list;
    }
}
