package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {

    protected int n = 0;    //number of entries in the dictionary
    protected int capacity; //length of the table
    private int prime;      //prime factor
    private long scale, shift; //the shift and scaling factors

    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int cap) {
        this(cap, 109345121);
    }

    public AbstractHashMap() { this(17); }

    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
        for (Entry<K,V> entry : entrySet()) {
            buffer.add(entry);
        }
        capacity = newCap;
        createTable();
        n = 0;
        for (Entry<K,V> entry : buffer) {
            put(entry.getKey(), entry.getValue());
        }
    }


    public int size() { return n; }
    public V get(K key) { return bucketGet(hashValue(key), key); }
    public V remove(K key) {return bucketRemove(hashValue(key), key); }
    public V put(K key, V value) {
        V v = bucketPut(hashValue(key), key, value);
        if (n >= capacity / 2) {
            resize(2 * capacity - 1);
        }
        return v;
    }

    protected abstract void createTable();
    protected abstract V bucketGet(int h, K key);
    protected abstract V bucketPut(int h, K key, V value);
    protected abstract V bucketRemove(int h, K key);


}
