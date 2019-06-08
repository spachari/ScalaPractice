package com.general.data.structures.and.algorithms.ch8trees;

import com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue.LinkedQueue;
import com.general.data.structures.and.algorithms.ch6StacksQueuesAndDeques.queue.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E>  {
    public boolean isInternal(Position<E> position) { return  (numChildren(position) != 0); }
    public boolean isExternal(Position<E> position) { return (numChildren(position) == 0);}
    public boolean isRoot(Position<E> position) { return position == root(); }
    public boolean isEmpty() {if (size() == 0) return true; else return false; }

    public int depth(Position<E> position) {
        if(isRoot(position)) {
            return 0;
        } else {
            return 1 + depth(parent(position));
        }
    }

    private int heightBad() {
        int h = 0;
        for(Position<E> p : positions()) {
            if (isExternal(p)) {               //Only consider leaf positions
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    public int height(Position<E> position) {
        int h = 0;
        for (Position<E> p: children(position)) {
            h = Math.max(h, 1 + height(p));
        }
        return h;
    }

    public void preOrderSubTree(Position<E> p, List<Position<E>> snapShot) {
        snapShot.add(p);
        for (Position pos : children(p)) {
            preOrderSubTree(pos, snapShot);
        }
    }

    public void postOrderSubTree(Position<E> p, List<Position<E>> snapShot) {
        for (Position<E> pos : children(p)) {
            preOrderSubTree(pos, snapShot);
        }
        snapShot.add(p);
    }

    public Iterable<Position<E>> postOrder() {
        List<Position<E>> snapShot = Arrays.asList();
        postOrderSubTree(root(), snapShot);
        return snapShot;
    }

    public Iterable<Position<E>> breadthFirst() {
        List<Position<E>> snapShot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());

            while(!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue();
                snapShot.add(p);

                for (Position<E> s : children(p)) {
                    fringe.enqueue(s);
                }
            }

        }
        return snapShot;
    }

    private static String makeSpace(int depth) {
        String initialString = "";
        for (int i = 0; i <= depth; i ++) {
            initialString = initialString + " ";
        }
        return initialString;
    }

    public void printSubTree() {
        List<Position<E>> snapShot = new ArrayList<>();

        preOrderSubTree(root(), snapShot);
        for (Position<E> p : snapShot) {
            System.out.println(makeSpace(depth(p)) + p.getElement());
        }
    }

    public void printPreOrderIndent(Tree tree, Position<E> position, int depth) {
        System.out.println(makeSpace(2*depth) + position.getElement());

        for (Position<E> p : children(position)) {
            printPreOrderIndent(tree, position, depth + 1);
        }
    }

    public static <E> void printPreOrderLabeled(Tree T, Position<E> position, ArrayList<Integer> path) {

        int d = path.size();
        System.out.print(makeSpace(d * 2));

        for (int i = 0; i < d ; i ++) { System.out.print(path.get(i) + (i == d - 1 ? " " : ".")); }
        System.out.println(position.getElement());
        path.add(1);

        for (Object p : T.children(position)) {
            printPreOrderLabeled(T, (Position<E>) p, path);
            path.set(d, path.get(d));
        }

        path.remove(d);

    }

    public static<E> int diskSpaceAsTree(Tree<E> T, Position<E> position) {
        int subTotal = (Integer) position.getElement();
        for (Position<E> p :  T.children(position)) {
            subTotal += diskSpaceAsTree(T, p);
        }
        return subTotal;
    }

    //Electronics R'Us (R&D, Sales (Domestic, International (Canada,
    //S. America, Overseas (Africa, Europe, Asia, Australia))),
    //Purchasing, Manufacturing (TV, CD, Tuner))

    public void paranthesis(Tree T, Position<E> p) {
        System.out.print(p.getElement());
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Object c : T.children(p)) {
                System.out.print(firstTime ? "(" : ",");
                firstTime = false;
                paranthesis(T, (Position<E>) c);
            }
            System.out.print(")");
        }
    }
}
