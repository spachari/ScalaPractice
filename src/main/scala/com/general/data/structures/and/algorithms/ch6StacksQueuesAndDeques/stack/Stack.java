package com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.stack;

public interface Stack<E> {

    int size();
    boolean isEmpty();
    void push(E e);
    E pop();
    E top();

}
