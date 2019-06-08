package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.linkedlists;

public class SinglyLinkedList<E> implements Cloneable{

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

    private Node<E> head = null;
    private Node<E> tail = null;
    public int size = 0;
    public boolean isEmpty() {
        if (size == 0) return true; else return false;
    }

    public SinglyLinkedList() { }

    public E first() {
        if (isEmpty()) return null; else return head.element;
    }

    public E last() {
        if (isEmpty()) return null; else return tail.element;
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            tail = newest;
            head = tail;
        }
        else {
            tail.setNext(newest);
            tail = newest;
        }
        size++;
    }

    public E removeFirst() {
        Node<E> temp = null;
        if(isEmpty()) return null;
        else {
            temp = head;
            head = head.next;
            size--;

            if (size == 0) {
                tail = null;
            }
        }
        return temp.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        E current = null;
        Node<E> next = head;

        sb.append("[");
        if(next == null) sb.append(" ");
        while(next.getNext() != null) {
            current = next.element;
            sb.append(current + ", ");
            next = next.getNext();
            if(next.getNext() == null) {
                sb.append(next.element);
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public boolean equals(Object list) {
        boolean isTrue = true;
        Node<E> item = head;
        SinglyLinkedList<E> thisItem = (SinglyLinkedList) list;
        Node<E> thisItemAsNode = thisItem.head;

        if (this == null || list == null) {
            return false;
        } else if (this.size != thisItem.size) {
            return false;
        } else if (this.getClass() != list.getClass()) {
            return false;
        }
        else {
            for (int i = 0; i < thisItem.size ; i ++) {
                if (item.getElement() != thisItemAsNode.getElement())
                {
                    isTrue = false;
                }
                item = item.getNext();
                thisItemAsNode = thisItemAsNode.getNext();
            }
            return isTrue;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //SinglyLinkedList<E> newList = (SinglyLinkedList<E>) super.clone(); this just copies the whole thing
        SinglyLinkedList<E> other = new SinglyLinkedList<E>();

        if(size > 0) {
            other.head = new Node<E>(head.getElement(), null); //Creating the head
            Node<E> walk = head.getNext();
            Node<E> otherHead = other.head;

            while(walk != null) {
                Node<E> newest = new Node<E>(walk.getElement(), null); //Creating a node with the current element
                otherHead.setNext(newest); //set it as a next element to the head
                otherHead = newest;  //set the head to the newest
                walk = walk.getNext();
            }
        }

        return other;
    }

    public int hashCode() {
        int h = 0;
        for (Node walk = head; walk != null; walk = walk.getNext()) {
            h = walk.getElement().hashCode();
            h = (h << 5) | (h >>> 27);
        }
        return h;
    }
}

class SinglyLinkedListTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        //list.addFirst(10);
        list.addFirst(11);
        list.addFirst(12);
        list.addFirst(13);
        list.addFirst(14);
        list.addFirst(15);
        list.addLast(10);
        System.out.println(list.size);
        System.out.println(list.toString());

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        System.out.println(list.toString());


        //list1 object


        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        //list.addFirst(10);
        list1.addFirst(11);
        list1.addFirst(12);
        list1.addFirst(13);
        list1.addFirst(14);
        list1.addFirst(15);
        list1.addLast(10);

        System.out.println(list1);

        System.out.println(list.equals(list1));
        System.out.println(list1);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        //list.addFirst(10);
        list2.addFirst(11);
        list2.addFirst(12);
        list2.addFirst(13);
        list2.addFirst(14);
        list2.addFirst(15);
        list2.addLast(10);

        System.out.println(list1.equals(list2));

        SinglyLinkedList myList = (SinglyLinkedList) list1.clone();

        System.out.println("=================");
        System.out.println(myList);
    }
}