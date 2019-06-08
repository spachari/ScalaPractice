package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.stack;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.linkedlists.SinglyLinkedList;


//The manner of importing a class's methods in your class (by creating a variable as an object in your class)
// is called adapter pattern

public class LinkedStack<E> implements Stack<E> {

    SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack() { }

    public int size() {
        return list.size;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
        list.addFirst(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E top() {
        return list.first();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(70);
        linkedStack.push(80);
        linkedStack.push(90);

        System.out.println(linkedStack);
        System.out.println(linkedStack.size());
        System.out.println(linkedStack.top());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack);


    }
}

