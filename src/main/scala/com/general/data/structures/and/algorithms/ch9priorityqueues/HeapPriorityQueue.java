package com.general.data.structures.and.algorithms.ch9priorityqueues;

import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.Position;
import com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList.PositionalList;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    protected ArrayList<Entry<K,V>> heap = new ArrayList();

    HeapPriorityQueue() { super(); }

    HeapPriorityQueue(Comparator<K> comp) {super(comp); }

    protected int parent(int j) { return (j - 1) / 2;  }
    protected int left(int j) {return (j * 2) + 1; }
    protected int right (int j) { return (j * 2) + 2; }

    protected boolean hasLeft(int j) { return heap.size() > left(j); }
    protected boolean hasRight(int j) { return heap.size() > right(j); }

    protected void swap(int i, int j) {
        Entry<K,V> temp = heap.get(i);
        heap.set(j, heap.get(i));
        heap.set(i, temp);
    }

    protected void upHeap(int j) {
        while(j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) break;
            swap(j , p);
            j = p;
        }
    }

    protected void downHeap(int j) {
        while(hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildrenIndex = leftIndex;
            if (hasRight(j)) {
                if (compare(heap.get(smallChildrenIndex), heap.get(right(j))) > 0) {
                    smallChildrenIndex = right(j);
                }
            }
            if (compare(heap.get(smallChildrenIndex), heap.get(j)) >= 0) break;
            swap(j, smallChildrenIndex);
            j = smallChildrenIndex;
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> entry = new PQEntry(key, value);
        heap.add(entry);
        upHeap(heap.size() - 1);
        return entry;
    }

    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) return null;
        Entry<K,V> min = heap.get(0);
        swap(0, heap.size());
        heap.remove(heap.size() - 1);
        downHeap(0);
        return min;
    }

    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int i = 0; i <= Math.min(keys.length, values.length); i ++) {
            heap.add(new PQEntry<>(keys[i], values[i]));
        }
        heapify();
    }

    protected void heapify() {
        int parentSize = parent(size() - 1);
        for (int j = parentSize; j >= 0; j --) {
            downHeap(j);
        }
    }

    //This algorithm is sorting a list using a priorityqueue
    public static <E> void pqSort(PositionalList<E> list, PriorityQueue<E,?> queue) {
        int n = list.size();
        for (int j = 0; j <= n; j++) {
            E element = list.remove(list.first());
            queue.insert(element, null);
        }

        for (int j = 0; j <= n; j ++) {
            E element = queue.removeMin().getKey();
            list.addLast(element);
        }
    }
}
