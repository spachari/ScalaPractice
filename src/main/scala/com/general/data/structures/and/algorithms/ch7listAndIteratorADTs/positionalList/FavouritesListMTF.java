package com.general.data.structures.and.algorithms.ch7listAndIteratorADTs.positionalList;

public class FavouritesListMTF<E> extends FavouritesList<E> {
    protected void moveUp(Position<Item<E>> position) {
        if (position != list.first()) {
            list.addFirst(list.remove(position));
        }
    }

}
