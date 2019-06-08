package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.linkedlists.SinglyLinkedList;

public class ListQueue<E> implements Queue<E> {


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
        E removedItem  = list.removeFirst();
        return removedItem;
    }

    @Override
    public E first() {
        return list.first();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SinglyLinkedList<E> tempList = list;


        return tempList.toString();
    }
}


class ListQueueTest {
    public static void main(String[] args) {
        ListQueue<String> listQueue = new ListQueue<>();
        listQueue.enqueue("Srinivas");
        listQueue.enqueue("Kirthika");
        listQueue.enqueue("Sadhana");
        listQueue.enqueue("Zoe");
        System.out.println(listQueue.size());

        System.out.println(listQueue.toString());
    }
}