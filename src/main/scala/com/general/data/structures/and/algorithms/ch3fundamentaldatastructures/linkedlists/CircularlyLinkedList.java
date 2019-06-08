package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.linkedlists;

import scalaz.Alpha;

public class CircularlyLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() { }

    public int size() { return size; }

    public boolean isEmpty() { if (size == 0) return true; else return false; }

    public E first() {
        if (isEmpty())
            return null;
        else return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty())
            return null;
        else return tail.getElement();
    }

    public void rotate() {
        if (!isEmpty())
        tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext()); //linking the head with the new element
            tail.setNext(newest); //setting the tail as the new element (this is the link between the tail to the new element)
        }
        size++;
    }

    public void addLast(E e) {
            addFirst(e);
            tail.setNext(tail.getNext()); //the new element becomes the tail
    }

    public E removeFirst() {
        Node<E> head = null;
        if (isEmpty()) return null;
        if (head == tail) {
            size = 0;
            tail = null;
        }
        else {
            head = tail.getNext(); //getting the head
            Node<E> firstElement = tail.getNext().getNext();
            tail.setNext(firstElement);
            size--;
        }
        return head.getElement();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> item = tail.getNext();

        sb.append("[ ");
        while(item.getElement() != tail.getElement()) {
            sb.append(item.getElement() + ", ");
            //System.out.println("item 1 " + item.element);
            item = item.getNext();
        }
        sb.append(tail.getElement() + " ]");

        StringBuilder sb1 = new StringBuilder();
        sb1.append("[ ");
        Node<E> item1 = tail;
        for (int i = 0; i < size; i ++) {
            item1 = item1.getNext();
            System.out.println(item1.getElement());
            sb.append(item1.getElement() + " ,");
        }
        return sb.toString();
    }

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}


class CircularlyLinkedListTest {
    public static void main(String[] args) {
        CircularlyLinkedList<Integer> list = new CircularlyLinkedList<>();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(14);
        list.addFirst(12);
        list.addFirst(13);
        list.addFirst(14);

        System.out.println(list.toString());

    }
}