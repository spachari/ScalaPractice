package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.linkedlists.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E>{

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    @Override
    public int size() {
        return list.size;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E first() {
        return list.first();
    }
}
