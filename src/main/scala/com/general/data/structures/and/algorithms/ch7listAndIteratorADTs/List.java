package com.general.data.structures.and.algorithms.ch7listAndIteratorADTs;

public interface List<E> {
    int size();
    boolean isEmpty();
    E get (int i) throws IllegalStateException;
    E set(int i, E element) throws IllegalStateException;
    void add(int i, E element) throws IllegalStateException;
    E remove(int i) throws IllegalStateException;

}
