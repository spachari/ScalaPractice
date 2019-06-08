package com.general.data.structures.and.algorithms.ch9priorityqueues;

import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.LinkedPositionalList;
import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.Position;
import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.PositionalList;

import java.util.Comparator;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();

    SortedPriorityQueue() { super();}

    SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new PQEntry<>(key, value);
        Position<Entry<K,V>> walk = list.last();

        while(walk != null  && compare(((PQEntry<K, V>) newest), walk.getElement()) < 0) {
            walk = list.before(walk);
            if (walk == null) {
                list.addBefore(walk, newest);
            } else {
                list.addAfter(walk, newest);
            }
        }
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        return list.first().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        return list.remove(list.first());
    }
}
