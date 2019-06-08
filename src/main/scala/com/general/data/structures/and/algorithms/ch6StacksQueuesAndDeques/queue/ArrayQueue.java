package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue;

public class ArrayQueue<E> implements Queue<E> {

    private E[] data;
    private int f = 0;  //first position of the queue
    private int sz = 0; //size in number

    public ArrayQueue() {
        this(1000);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        if (sz == 0) return true; else return false;
    }

    //capacity = 10
    //items = 5,6,7 .i.e sz = 3
    //need to push the item in 8
    @Override
    public void enqueue(E e) throws IllegalArgumentException {
        if (sz == data.length) throw new IllegalArgumentException("Queue is full");
        int posToInsert = (sz + f) % data.length;
        System.out.print("Inside queue method posToInsert " + posToInsert);
        data[posToInsert] = e;
        System.out.print(" sz " + sz + " f " + f);
        System.out.println();
        sz++;
    }

    //capacity or data.length = 10
    //items = 5,6,7 .i.e sz = 3, f = 5
    //need to get the item from 5 and set f as 6
    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        System.out.println("Inside dequeue method new f " + f);
        sz--;
        return answer;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }

    public void printElements() {
        for (E e : data) {
            System.out.println(e);
        }
    }
}


class ArrayQueuetest {
    public static void main(String[] args) {
        ArrayQueue<String> aq = new ArrayQueue<>(10);
        aq.enqueue("Srinivas");
        aq.enqueue("Kirthika");
        aq.enqueue("Sadhana");

        System.out.println(aq.size());
        System.out.println(aq.isEmpty());
        aq.printElements();

        System.out.println("Dequeue output is " + aq.dequeue());

        aq.enqueue("Sadhiv");
        aq.printElements();
    }
}