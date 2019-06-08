package com.general.data.structures.and.algorithms.ch9priorityqueues;

import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.LinkedPositionalList;
import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.Position;
import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.PositionalList;

import java.util.Comparator;

public class HeapAdaptablepriorityQueue<K,V> extends HeapPriorityQueue<K,V> implements AdaptablePriorityQueue<K,V> {

    protected static class AdaptablePQEntry<K,V> extends PQEntry<K,V> {

        K key;
        V value;
        int index;

        AdaptablePQEntry(K key, V value, int index ) {
            super( key, value);
            this.index = index;
        }

        public int getIndex() { return index; }

        public void setIndex(int index) { this.index = index; }
    }

    HeapAdaptablepriorityQueue() { super(); }

    HeapAdaptablepriorityQueue(Comparator<K> comp) { super(comp); }


    public AdaptablePQEntry<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException {
        if (!(entry instanceof AdaptablePQEntry)) {
            throw new IllegalArgumentException("Not valid entry");
        }
        AdaptablePQEntry<K,V> locator = (AdaptablePQEntry<K,V>) entry;
        int locatorIndex = locator.getIndex();
        if (locatorIndex >= heap.size() || heap.get(locatorIndex) != locator) {
            throw new IllegalArgumentException("Not a valid entry");
        }
        return locator;
    }

    public void swap(int i, int j) {
        super.swap(i, j);
        ((AdaptablePQEntry<K,V>) heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K,V>) heap.get(j)).setIndex(j);
    }

    protected void bubble(int i) {
        Entry<K,V> entry = heap.get(i);
        if (compare(heap.get(i), heap.get(parent(i))) < 0) {
            upHeap(i);
        } else {
            downHeap(i);
        }
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> entry = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(entry);
        upHeap(heap.size() - 1);
        return entry;
    }

    @Override
    public void remove(Entry<K, V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> toBeDeleted = validate(entry);
        int i = toBeDeleted.index;
        if (i == heap.size()) {
            heap.remove(i);
        } else {
            swap(i, heap.size() - 1);             //Move it to last position
            heap.remove(heap.size() - 1);     //Delete last position
            bubble(toBeDeleted.getIndex());         //Fix it
        }
    }

    @Override
    public void replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> toBeReplaced = validate(entry);

        checkKey(key);
        toBeReplaced.setKey(key);
        bubble(toBeReplaced.getIndex());
    }

    @Override
    public void replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {
        AdaptablePQEntry<K,V> toBeReplaced = validate(entry);
        toBeReplaced.setValue(value);
    }
}
