package com.general.data.structures.and.algorithms.ch9priorityqueues;

import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.LinkedPositionalList;
import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.Position;
import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.PositionalList;

import java.util.Comparator;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue() {super();}

    public UnsortedPriorityQueue(Comparator<K> comp) { super(comp); }

    private Position<Entry<K,V>> findMin() {
        Position<Entry<K,V>> small = list.first();
        for (Object walk : ((LinkedPositionalList) list).positions()) {
            if (compare(small.getElement(), ((Position<Entry<K,V>>) walk).getElement()) < 0) {
                small = ((Position<Entry<K,V>>) walk);
            }
        }
        return small;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> entry = new PQEntry<K,V>(key, value);
        list.addLast(entry);
        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) return null;
        return findMin().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) return null;
        return list.remove(findMin());
    }


}
