package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.ArrayList;

public class ProbeHashMap<K,V> extends AbstractHashMap<K,V> {
    private MapEntry<K,V>[] table;
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);

    public ProbeHashMap() { super(); }
    public ProbeHashMap(int cap) { super(cap); }
    public ProbeHashMap(int cap, int p) { super(cap, p); }

    @Override
    protected void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }

    //returns true if entry is null or entry is DEFUNCT
    public boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    private int findSlot(int h, K key) {
        int avail = -1;
        int j = h;
        do {
            if (isAvailable(j)) {
                if(avail == -1) avail = j;
                if (table[j] == null) break;
            } else if (table[j].getKey() == key) {
                return j;
            }
            j = (j + 1) % capacity;
        } while (j != h);
        return -(avail + 1);
    }

    @Override
    protected V bucketGet(int h, K key) {
        int slot = findSlot(h, key);
        if (slot < 0) return null;
        return table[slot].getValue();
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        int slot = findSlot(h, key);
        if (slot >= 0) {
            table[slot].setValue(value);
        }
        table[-slot + 1] = new MapEntry<>(key, value);
        n++;
        return null;
    }

    @Override
    protected V bucketRemove(int h, K key) {
        int slot = findSlot(h, key);
        if (slot < 0) {
            return null;
        }
        V answer = table[slot].getValue();
        table[slot] = DEFUNCT;
        n--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty();
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K,V>> list1 = new ArrayList<>();
        for (int i = 0; i < capacity; i ++) {
            if(isAvailable(i)) {
                list1.add( table[i]);
            }
        }
        return list1;
    }
}
