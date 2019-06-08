package com.general.data.structures.and.algorithms.ch11SearchTrees;

import com.general.data.structures.and.algorithms.ch8trees.Position;
import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.Comparator;

public class SplayTreeMap<K,V> extends TreeMap<K,V> {
    public SplayTreeMap() { super(); }

    public SplayTreeMap(Comparator<K> comp) { super(comp); }

    protected void splay(Position<Entry<K,V>> position) {
        while(!isRoot(position)) {
            Position<Entry<K,V>> parent = parent(position);
            Position<Entry<K,V>> grandParent = parent(parent(position));

            if (grandParent == null) {
                rotate(position);
            } else if (parent == left(grandParent) && position == left(parent)) { //zig zig case
                rotate(parent);
                rotate(position);
            } else {
                rotate(position);
                rotate(position);
            }
        }
    }

    protected void rebalanceAccess(Position<Entry<K,V>> position) {
        if (!isExternal(position)) splay(parent(position));
        if (position != null) { splay(position); }
    }

    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        splay(p);
    }

    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!isRoot(p)) splay(p);
    }
}
