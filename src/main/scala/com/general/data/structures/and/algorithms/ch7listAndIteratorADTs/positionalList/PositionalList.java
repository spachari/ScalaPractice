package com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList;

public interface PositionalList<E> {
    int size();
    boolean isEmpty();
    Position<E> first();
    Position<E> last();
    Position<E> before(Position<E> position) throws IllegalStateException;
    Position<E> after(Position<E> position) throws IllegalStateException;
    Position<E> addFirst(E e);
    Position<E> addLast(E e);
    Position<E> addBefore(Position<E> position, E e) throws IllegalStateException;
    Position<E> addAfter(Position<E> position, E e) throws IllegalStateException;
    E set(Position<E> position, E element) throws IllegalStateException;
    E remove(Position<E> position) throws IllegalStateException;

}
