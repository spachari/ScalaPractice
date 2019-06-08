package com.general.data.structures.and.algorithms.ch7listAndIteratorADTs;


import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    public static int CAPACITY = 16;
    private E[] data;
    private int size = 0;



    public ArrayList(int itemsList) {
        data = (E[]) new Object[itemsList];
    }

    public ArrayList() {
        this(CAPACITY); //constructs List with default capacity. i.e this will call the default constructor with CAPACITY = 16
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) return true; else return false;
    }

    @Override
    public E get(int i) throws IllegalStateException {
        if (i > data.length) throw new IllegalStateException("List is full");
        return data[i];
    }

    @Override
    public E set(int i, E element) throws IllegalStateException {
        if (i >= data.length) throw new IllegalStateException("List is full");
        data[i] = element;
        return element;
    }

    private int getLastNonNullItem() {
        int counter = 0;
        for (int i = 0; i < data.length; i ++) {
            if (data[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public void add(int i, E element) throws IllegalStateException {
        if ( i >= data.length) throw new IllegalStateException("List is full");

        //Now push all the elements till the end of the list to one more out
        if (i >= getLastNonNullItem()) { //straight forward add
            data[i] = element;
        }
        else {
            for ( int j = data.length - 1; j >= i; j --) {
                data[j] = data[j - 1];
            }
            data[i] = element;
        }
        E temp = data[i];
        data[i] = element;
        size++;
    }

    @Override
    public E remove(int i) throws IllegalStateException {
        if (data.length <= i) throw new IllegalStateException("List contains only " + CAPACITY + " elements");
        E temp = data[i];
        data[i] = null;
        for (int j = i; j < size() - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size() - 1] = null;
        size--;
        return temp;
    }

    public void printItems () {
        int c = 0;
        for (E e : data) {
            System.out.print(e + " " );
            c ++;
        }
        System.out.println();
    }

    //Non-static inner class. Note that each instance contains an implicit reference to the containing list,
    //allowing access to the list members

    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;

        @Override
        public boolean hasNext() {
            return j < size;
        }

        @Override
        public E next() throws IllegalStateException {
            E nextItem = null;
            if (j == size) throw new IllegalStateException("No more items in the ArrayList");
            removable = true;
            return data[j++];
            }

        @Override
        public void remove() {
            if (!removable) throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j - 1); //This is how you can call a method from a private class
            j --;
            removable = false;
        }
    }

    public Iterator<E> ArrayIterator() {
        return new ArrayIterator();
    }
}


class ArrayListTest {
    public static void main(String[] args) {
        String[] strArray = new String[]{"A","B","C"};
        System.out.println(strArray.length);


        ArrayList<String> arrayList = new ArrayList<>(4);
        arrayList.add(0, "Srinivas");
        arrayList.add(1, "Kirthika");
        arrayList.printItems();
        System.out.println();
        System.out.println();

        arrayList.add(1, "Sadhana");
        arrayList.printItems();
        System.out.println();

        arrayList.add(1, "Sadhiv");
        arrayList.printItems();

        System.out.println("Removing items .... ");
        arrayList.remove(1);
        arrayList.printItems();

        System.out.println(arrayList.ArrayIterator().hasNext());
        System.out.println(arrayList.ArrayIterator().next());


    }
}