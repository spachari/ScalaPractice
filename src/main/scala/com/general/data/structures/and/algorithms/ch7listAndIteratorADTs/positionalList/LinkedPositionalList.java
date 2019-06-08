package com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

    private class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> prev, Node<E> next) {
            element = e;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) throw  new IllegalStateException("Position no longer valid");
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setPrev(E e) {
            prev.setElement(e);
        }

        public void setNext(E e) {
            next.setElement(e);
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    //Constructs an empty list
    public LinkedPositionalList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, null, null);
        header.setNext(trailer.getElement());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true; else return false;
    }

    @Override
    public Position<E> first() {
        return header;
    }

    @Override
    public Position<E> last() {
        return trailer;
    }

    //This is just a conversion method from position ot Node. because Node already implements
    //Position, conversion is easy. After calling this using a position, users can work with Nodes from a position
    private Node<E> validate(Position<E> position) throws IllegalStateException {
        if (!(position instanceof Node)) throw new IllegalStateException("Position is not a Node object");
        Node<E> node = (Node<E>) position;
        if (node.getNext() == null) throw new IllegalStateException("Invalid state");
        return node;
    }

    private Position<E> position(Node<E> node) throws IllegalStateException {
        if (node == header || node == trailer) return null;
        else {
            return (Position<E>) node;
        }
    }

    private Position<E> addBetween(E e, Node<E> prevnode, Node<E> nextNode) {
        Node<E> currentNode = new Node<E>(e,null, null);
        prevnode.setNext(prevnode.getElement());
        nextNode.setPrev(prevnode.getElement());
        size++;
        return currentNode;
    }

    @Override
    public Position<E> before(Position<E> position) throws IllegalStateException {
        if (position == first()) throw new IllegalStateException("Position is already the first one");
        Node<E> node = validate(position);
        return position(node.prev);
    }

    @Override
    public Position<E> after(Position<E> position) throws IllegalStateException {
        if (position == last()) throw new IllegalStateException("Position is already the first one");
        Node<E> node = validate(position);
        return position(node.next);
    }


    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.next);
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.prev, trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> position, E e) throws IllegalStateException {
        Node<E> currentNode = validate(position);
        Node<E> prevNode = currentNode.prev;

        return addBetween(e, prevNode, currentNode);
    }

    @Override
    public Position<E> addAfter(Position<E> position, E e) throws IllegalStateException {
        Node<E> currentNode = validate(position);
        Node<E> nextNode = currentNode.next;

        return addBetween(e, nextNode, currentNode);
    }

    @Override
    public E set(Position<E> position, E element) throws IllegalStateException {
        Node<E> currentNode = validate(position);
        currentNode.setElement(element);
        return element;
    }

    @Override
    public E remove(Position<E> position) throws IllegalStateException {
        Node<E> currentNode = validate(position);
        Node<E> prevNode = currentNode.getPrev();
        Node<E> nextNode = currentNode.getNext();

        prevNode.setNext(nextNode.getElement());
        nextNode.setPrev(prevNode.getElement());
        size--;

        E answer = currentNode.getElement();
        currentNode.element = null;
        currentNode.prev = null;
        currentNode.next = null;

        return answer;
    }

    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first(); //maintain latest element
        private Position<E> recent = null; //get value from cursor and return


        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("No valid element");
            recent = cursor;
            cursor = after(cursor);
            return validate(recent);
        }

        @Override
        public void remove() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("No valid element");
            LinkedPositionalList.this.remove(recent);
            recent = null;
        }
    }

    private class PositionIterable implements Iterable<Position<E>> {
        @Override
        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    }

    public Iterable<Position<E>> positions() {
        return new PositionIterable();
    }

    private class ElementIterator implements Iterator<E> {
        Node<E> cursorElements = header;
        Node<E> recent = null;


        @Override
        public boolean hasNext() {
            return cursorElements != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (recent == null) throw new NoSuchElementException("Not a valid element");
            recent = cursorElements;
            cursorElements = cursorElements.next;
            return recent.element;
        }

        @Override
        public void remove() {
            Position<E> position = position(recent);
            LinkedPositionalList.this.remove(position);
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public static void insertionSort(PositionalList<Integer> list) {
        Position<Integer> marker = list.first();
        //Here marker is the i
        //It's job is to loop through the list

        while(marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if (value > marker.getElement()) {
                marker = pivot;
            } else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() > value) {
                    walk = list.before(walk);
                }
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }

    }
}

class LinkedPositionalListTest {
    public static void main(String[] args) {
        LinkedPositionalList<String> positionalList = new LinkedPositionalList<>();
        positionalList.addFirst("Srinivas");
        positionalList.addAfter(new Position<String>() {
            @Override
            public String getElement() throws IllegalStateException {
                return "A";
            }
        }, "Kirthika");
    }
}