package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.linkedlists;

public class DoublyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node ( Node<E> prev, E e, Node<E> next) {
            this.element = e;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() { return element; }
        public void setPrev(Node<E> prev) { this.prev = prev; }
        public void setNext(Node<E> next) { this.next = next; }
        public Node<E> getNext() {return next; }
        public Node<E> getPrev() {return prev; }
    }

    //Set header and trailer nodes
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        //Set header and trailer when creating
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, null, null);
        header.setNext(trailer);
    }

    public int size() { return size; }
    public boolean isEmpty() { if (size == 0) return true; else return false; }
    public E first() {
        if (isEmpty())
            return null;
        else {
            return header.getNext().getElement();
        }
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        else {
            return trailer.prev.getElement();
        }
    }

    public void addFirst(E e) {
        addBetween(header, e, header.getNext());
    }

    public void addLast(E e) {
        addBetween(trailer.getPrev(), e, trailer);
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }


    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private void addBetween(Node<E> prev, E e, Node<E> after) {
        Node<E> element = new Node<E>(prev, e, after);
        prev.setNext(element);
        after.setPrev(element);
        size ++;
    }

    private E remove(Node<E> deleteNode) {
        //Get prev node and next node of deleteNode
        Node<E> prevOfDeleteNode = deleteNode.getPrev();
        Node<E> nextOfDeleteNode = deleteNode.getNext();

        //Set prev node's next as nextOfDeleteNode
        prevOfDeleteNode.setNext(nextOfDeleteNode);
        nextOfDeleteNode.setPrev(prevOfDeleteNode);
        size--;
        return deleteNode.getElement();
    }

    private Node<E> getNext(Node<E> e) {
        return new Node<E>(e.getNext(), e.getNext().getElement(), e.getNext().getNext().getPrev());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> item = header.getNext();

        sb.append("[ ");

        for (int i = 0; i < size; i ++) {
            System.out.println(item.getElement());
            if (i == size - 1) sb.append(item.getElement() + " ");  else sb.append(item.getElement() + ", ");
            item = item.getNext();
        }

        sb.append(" ]");

        return sb.toString();
    }
}

class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        System.out.println(list.size());
        System.out.println(list.toString());

        list.removeFirst();
        list.removeLast();
        System.out.println(list.toString());



    }
}
