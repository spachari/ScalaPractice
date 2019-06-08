package com.general.data.structures.and.algorithms.ch8trees;

public interface BinaryTree<E> extends Tree<E> {
    public Position<E> right(Position<E> position) throws IllegalArgumentException;
    public Position<E> left(Position<E> position) throws IllegalArgumentException;
    public Position<E> sibling(Position<E> position) throws IllegalArgumentException;
}
