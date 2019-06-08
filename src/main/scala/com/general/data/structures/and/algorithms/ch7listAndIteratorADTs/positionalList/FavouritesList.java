package com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList;

import java.util.Iterator;

public class FavouritesList<E> {
    protected static class Item<E> {
        private E value;
        private int count = 0;

        public Item(E e) {value = e; }
        public E getValue() { return value; }
        public void setValue(E value) { this.value = value; }

        public int getCount() { return count; }
        public void setCount(int count) {this.count = count; }
        public void increment() {this.count ++; }

    }

    PositionalList<Item<E>> list = new LinkedPositionalList<>();

    public FavouritesList() {

    }

    protected E value (Position<Item<E>> p) { return p.getElement().getValue(); }

    protected int count(Position<Item<E>> p) { return p.getElement().getCount(); }

    protected Position<Item<E>> findPosition(E e) {
        Position<Item<E>> walk = list.first();
        while(walk != null && e.equals(walk.getElement())) {
            walk = list.after(walk);
        }
        return walk;
    }

    protected void moveUp(Position<Item<E>> p) {
        Position<Item<E>> walk = p;
        int cnt = count(p);

        while(walk != list.first() && count(list.before(walk)) < cnt) {
            walk = list.before(walk);
        }

        if (walk != p) {
            list.addBefore(walk, list.remove(p));
        }
    }

    public int size() { return list.size(); }

    public boolean isEmpty() { return list.isEmpty(); }

    public void access(E e) {
        Position<Item<E>> position = findPosition(e);

        if (position == null) {
            list.addLast(new Item<E>(e));
        }
        position.getElement().increment();
        moveUp(position);
    }

    public void remove(Position<Item<E>> position) {
        Position<Item<E>> p = findPosition(position.getElement().getValue());
        if (p != null) {
            list.remove(position);
        }
    }

    public Iterator<E> getFavourites(int k) throws IllegalArgumentException {
        if (k < 0 || k > size())
            throw new IllegalArgumentException("Imporper proper value" + k);

        PositionalList<E> result = new LinkedPositionalList<>();
        Iterator<E> iter = ((LinkedPositionalList<E>) list).iterator();
        int counter = 0;

        for (int i = 0; i <= k; i ++) {
            result.addLast(iter.next());
        }

        return ((LinkedPositionalList<E>) result).iterator();

    }
}
