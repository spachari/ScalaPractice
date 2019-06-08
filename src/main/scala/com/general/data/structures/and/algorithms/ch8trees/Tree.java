package com.general.data.structures.and.algorithms.ch8trees;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> position) throws IllegalStateException;
    Iterable<Position<E>> children(Position<E> position) throws IllegalStateException;
    int numChildren(Position<E> position);

    boolean isInternal(Position<E> position);
    boolean isExternal(Position<E> position);
    boolean isRoot(Position<E> position);

    int size();
    boolean isEmpty();

    @Override
    Iterator<E> iterator();

    Iterable<Position<E>> positions(); //This means we will produce our code for the iterator method +
                                       //Lists are iterable (they have iterator method in them)
                                       //we can return a list where we need an Iterable
}
