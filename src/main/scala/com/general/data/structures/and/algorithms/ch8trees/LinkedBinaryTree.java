package com.general.data.structures.and.algorithms.ch8trees;

import com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue.LinkedQueue;
import com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue.Queue;

import java.util.*;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    public static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> right;
        private Node<E> left;

        public Node(Node parent, Node left, Node right, E e) {
            element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node<E> getParent() { return parent; }
        public Node<E> getLeft() { return left; }
        public Node<E> getRight() { return right; }

        public void setParent(Node parent) { this.parent = parent; }
        public void setRight(Node right) { this.right = right; }
        public void setLeft(Node left) { this.left = left; }
        public void setElement(E e) {this.element = e; }

        @Override
        public E getElement() throws IllegalArgumentException {
            return element;
        }
    }

    //Factory to create a Node
    protected Node<E> createNode(Node parent, Node left, Node right, E e) {
        return new Node<E>(parent, left, right, e);
    }

    protected Node<E> root = null; // same as head
    protected int size = 0;

    public LinkedBinaryTree() {}

    protected Node<E> validate(Position<E> position) throws IllegalArgumentException {
        if (!(position instanceof Node))
            throw new IllegalArgumentException(" Not a valid Node");

        Node<E> node = (Node<E> ) position;
        if (node.getParent() == node) {
            throw new IllegalArgumentException(" position is no longer valid");
        }
        return node;
    }


    @Override
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public Position<E> parent(Position<E> position) throws IllegalStateException {
        Node<E> node = validate(position);
        return node.getParent();
    }

    @Override
    public Position<E> right(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getRight();
    }

    @Override
    public Position<E> left(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return node.getLeft();
    }

    //Update methods for a tree
    public Position<E> addRoot(Position<E> position) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException();
        root = createNode(null, null, null, position.getElement());
        size++;
        return root;
    }

    public Position<E> addLeft(Position<E> position, E e) throws IllegalStateException {
        Node<E> parent = validate(position);
        if (parent.getLeft() != null) {
            throw new IllegalStateException("Left already exists");
        }
        Node<E> leftNode = createNode(parent, null, null, e);
        parent.setLeft(leftNode);
        size++;
        return leftNode;
    }

    public Position<E> addRight(Position<E> position, E e) throws IllegalStateException {
        Node<E> parent = validate(position);
        if (parent.getRight() != null)
            throw new IllegalStateException("Right already exists");
        Node<E> rightNode = createNode(parent, null, null, e);
        parent.setRight(rightNode);
        size++;
        return rightNode;
    }

    public E set(Position<E> position, E e) throws IllegalStateException {
        Node<E> node = validate(position);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    //Attaches the internal structure of trees T1 and T2 as the respective left and right subtrees of leaf position p and
    // resets T1 and T2 to empty trees; an error condition occurs if p is not a leaf.

    public void attach(Position<E> position, LinkedBinaryTree t1, LinkedBinaryTree t2)
            throws IllegalStateException {
        Node<E> node = validate(position);
        if (isInternal(node)) {
            throw new IllegalStateException("position has to be internal");
        }
        size += t1.size + t2.size;
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.size = 0;
            t1.root = null;
        }

        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.size = 0;
            t2.root = null;
        }
    }

    //Removes the node at position p, replacing it with its child (if any), and returns the element that had been stored
    // at p; an error occurs if p has two children.

    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> nodeToBEDeleted = validate(position);
        if (numChildren(position) == 2 ) {
            throw new IllegalArgumentException("Cannot remove a node with two children");
        }

        Node<E> parentOfNode = nodeToBEDeleted.getParent();
        Node<E> child = null;
        if (nodeToBEDeleted.getLeft() != null) {
            child = nodeToBEDeleted.getLeft();
        } else {
            child = nodeToBEDeleted.getRight();
        }



        if (child != null) {
            child.setParent(parentOfNode);
        }

        if (nodeToBEDeleted == root) {
            root = child;
        } else {
            if (nodeToBEDeleted.getLeft() != null) {
                parentOfNode.setLeft(child);
            } else {
                parentOfNode.setRight(child);
            }
        }
        size--;

        E temp = position.getElement();
        nodeToBEDeleted.setRight(null);
        nodeToBEDeleted.setLeft(null);
        nodeToBEDeleted.setParent(null);
        return temp;
    }

    //Element Iteration
    private class ELementIterator implements Iterator<E> {
        Iterator<Position<E>> positions = positions().iterator();

        @Override
        public boolean hasNext() { return positions.hasNext(); }

        @Override
        public E next() { return positions.next().getElement(); }

        @Override
        public void remove() { positions.remove(); }
    }



    @Override
    public Iterator<E> iterator() {
        return new ELementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }


}
