package com.general.data.structures.and.algorithms.ch8trees;

import com.programmingscala.examples.implicits.implicitsAsExecutionContexts.Point;
import org.apache.avro.generic.GenericData;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    public Position<E> sibling(Position<E> position) throws IllegalArgumentException {
        Position<E> parent = parent(position);
        if (parent == null) return null;
        Position<E> sibling = null;
        if (position == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }


    public int numChildren(Position<E> position) {
        int count = 0;
        if (left(position) != null) {
            count++;
        }
        if (right(position) != null) {
            count++;
        }
        return count;
    }

    public Iterable<Position<E>> children(Position<E> position) {
        List<Position<E>> positionList = new ArrayList<>(2);
        Position<E> parentPosition = parent(position);

        if (left(parentPosition) != null) {
            positionList.add(left(position));
        }
        if (right(parentPosition) != null) {
            positionList.add(right(position));
        }
        return positionList;
    }

    public void inOrderSubTree(Position position, List<Position<E>> snapShot){
        if (left(position) != null) {
            inOrderSubTree(left(position), snapShot);
        }
        snapShot.add(position);
        if (right(position) != null) {
            inOrderSubTree(right(position), snapShot);
        }
    }

    public Iterable<Position<E>> inOrder() {
        List<Position<E>> snapShot = new ArrayList<>();
        inOrderSubTree(root(), snapShot);
        return snapShot;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return inOrder();
    }
}
