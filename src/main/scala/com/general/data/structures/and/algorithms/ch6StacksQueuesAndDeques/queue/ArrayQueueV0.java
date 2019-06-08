package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue;

public class ArrayQueueV0<E> implements Queue<E> {


    private static int CAPACITY = 1000;
    private E[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayQueueV0() {
        this(CAPACITY);
    }

    public ArrayQueueV0(int capacity) {
        data = (E[]) new Object[capacity];
    }

    private int getNonNullItems() {
        int size = 0;
        for (E s : data) {
            if (s != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public int size() {
        if (data == null) return 0;
        else  {
            return getNonNullItems();
        }
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) return true; else return false;
    }

    @Override
    public void enqueue(E element) {
        int size = getNonNullItems();
        if (size < CAPACITY) {
            data[size] = element;
        }
    }

    private E getlastNonNullElement() {
        int size = size();
        return data[size];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            E temp = data[0];
            //Create a new array
            E[] newArrray = (E[]) new Object[data.length - 1];
            for (int i = 1; i < data.length; i ++) {
                newArrray[i - 1] = data[i];
            }
            data = newArrray;
            return temp;
        }
    }

    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        } else {
            return data[size()];
        }
    }

    public void printArrayElements() {
        for (E e : data) {
            if (e != null) {
                System.out.println(e);
            }
        }
    }
}

class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueueV0<String> arrayQueue = new ArrayQueueV0<>(4);
        arrayQueue.enqueue("Srinivas");
        arrayQueue.enqueue("Kirthika");
        arrayQueue.enqueue("Sachin");

        System.out.println(arrayQueue.size());

        arrayQueue.printArrayElements();

        System.out.println();
        System.out.println();

        arrayQueue.dequeue();
        arrayQueue.printArrayElements();
        System.out.println(arrayQueue.size());

    }
}