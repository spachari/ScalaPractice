package com.general.data.structures.and.algorithms.ch11SearchTrees;

import com.general.data.structures.and.algorithms.ch8trees.Position;
import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.Comparator;

public class AVLTreeMap<K,V> extends TreeMap<K,V> {
    public AVLTreeMap() {super();}

    public AVLTreeMap(Comparator<K> comp) {super(comp);}

    protected int height(Position<Entry<K,V>> position) { return tree.getAux(position); }

    protected void recomputeHeight(Position<Entry<K,V>> position) {
        tree.setAux(position, 1 + Math.max(height(left(position)), height(right(position))));
    }

    protected boolean isBalanced(Position<Entry<K,V>> position) {
        return Math.abs(height(left(position)) - height(right(position))) <= 1;
    }

    //Returns a child of height no smaller than that of the other child
    protected Position<Entry<K,V>> tallerChild(Position<Entry<K,V>> position) {
        if (height(left(position)) > height(right(position))) return left(position);
        if (height(right(position)) > height(left(position))) return right(position);

        if (isRoot(position)) return left(position);
        if (position == left(parent(position))) return left(position);
        else return right(position);
    }

    //Utility to rebalance after an Insert or Delete. This traverses the path upward from p, performing a trinode restructuring
    //when imbalance is found, continuing until a balance is restored

    protected void reBalance(Position<Entry<K,V>> position) {
        int oldHeight, newHeight;
        do {
            oldHeight = height(position); //not yet recalculated
            if (!isBalanced(position)) {
                //Perform trinode restructuring, setting position to resulting root
                //and recompute new local heights after restructiring
                position = restructure(tallerChild(tallerChild(position)));
                recomputeHeight(left(position));
                recomputeHeight(right(position));
            }
            recomputeHeight(position);
            newHeight = height(position);
            position = parent(position);
        } while(oldHeight != newHeight && position != null);
    }

    protected void rebalanceInsert(Position<Entry<K,V>> position) {
        reBalance(position);
    }

    protected void rebalanceDelete(Position<Entry<K,V>> position) {
        if (!isRoot(position)) {
            reBalance(position);
        }
    }
}
