package com.general.data.structures.and.algorithms.ch11SearchTrees;

import com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists.AbstractSortedMap;
import com.general.data.structures.and.algorithms.ch8trees.LinkedBinaryTree;
import com.general.data.structures.and.algorithms.ch8trees.Position;
import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;
import com.programmingscala.examples.Traits.E;

import java.util.ArrayList;
import java.util.Comparator;

public class TreeMap<K,V> extends AbstractSortedMap<K,V> {


    //Start of BalancableBinaryTree class
    protected static class BalancableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>> {

        protected static class BSTNode<E> extends Node<E> {
            int aux = 0;
            BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
                super(parent, leftChild, rightChild, e);
            }
            public void setAux(int aux) { this.aux = aux; }
            public int getAux() { return aux; }
        }

        public int getAux(Position<Entry<K,V>> position) {
            return ((BalancableBinaryTree.BSTNode<Entry<K,V>>) position).getAux();
        }

        public void setAux(Position<Entry<K,V>> position, int aux) {
            ((BalancableBinaryTree.BSTNode<Entry<K,V>>) position).setAux(aux);
        }

        protected Node<Entry<K,V>> createNode(Entry<K,V> e,
                                              Node<Entry<K,V>> leftChild,
                                              Node<Entry<K,V>> rightChild,
                                              Node<Entry<K,V>> parent) {
            return new BalancableBinaryTree.BSTNode<>(e, parent, leftChild, rightChild);
        }

        //relink a parent with it's orientated child node
        public void reLink(Node<Entry<K,V>> parent, Node<Entry<K,V>> child, boolean makeLeftChild) {
            child.setParent(parent);
            if (makeLeftChild == true) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        //Rotates a Position p above it's parent
        public void rotate(Position<Entry<K,V>> p) {
            Node<Entry<K,V>> node = validate(p);
            Node<Entry<K,V>> parent = node.getParent();
            Node<Entry<K,V>> grandParent = parent.getParent();

            if(grandParent == null) { //if grandParent == null
                root = node;          //node becomes the root of the tree
                node.setParent(null);
            } else {
                reLink(grandParent, node, parent == grandParent.getLeft()); //node becomes direct child of parent
            }

            //Now rotate node and parent, including transfer of middle tree
            if(node == parent.getLeft())
            {
                reLink(parent, node.getRight(), true); //node's right child becomes parent's left child
                reLink(node, parent,false); //parent becomes node's right child
            } else {
                reLink(parent, node.getLeft(), false); //node's left child becomes parent's left child
                reLink(node, parent, true);
            }
        }

        public Position<Entry<K,V>> restructure(Position<Entry<K,V>> node) {
            Position<Entry<K,V>> parent = parent(node);
            Position<Entry<K,V>> grandParent = parent(parent);

            if ((node == right(parent)) == (parent == right(grandParent))) {
                rotate(parent);
                return parent;
            } else {
                rotate(node);
                rotate(node);
                return node;
            }
        }
    }
    //End of BalancableBinaryTree class

    protected BalancableBinaryTree<K,V> tree = new BalancableBinaryTree<>();

    public TreeMap() {
        super();
        tree.addRoot(null);
    }

    public TreeMap(Comparator<K> comp) {
        super(comp);
        tree.addRoot(null);
    }

    @Override
    public int size() {
        return (tree.size() - 1) / 2; //only internal nodes have entries
    }

    private void expandExternal(Position<Entry<K,V>> position, Entry<K,V> entry) {
        tree.set(position, entry);

        //add new sentinel leaves as children
        tree.addLeft(position, null);
        tree.addRight(position, null);

    }

    //Simple protected metrics
    protected Position<Entry<K,V>> root() { return tree.root(); }
    protected Position<Entry<K,V>> left(Position<Entry<K,V>> position) { return tree.left(position); }
    protected Position<Entry<K,V>> right(Position<Entry<K,V>> position) { return tree.right(position); }
    protected Position<Entry<K,V>> sibling(Position<Entry<K,V>> position) { return tree.sibling(position); }
    protected Position<Entry<K,V>> parent(Position<Entry<K,V>> position) { return tree.parent(position); }
    protected boolean isRoot(Position<Entry<K,V>> position) {return tree.isRoot(position); }
    protected boolean isExternal(Position<Entry<K,V>> position) { return tree.isExternal(position); }
    protected boolean isInternal(Position<Entry<K,V>> position) { return tree.isInternal(position); }
    protected void set(Position<Entry<K,V>> position, Entry<K,V> entry) { tree.set(position, entry); }
    protected Entry<K,V> remove(Position<Entry<K,V>> position) { return tree.remove(position); }
    protected void rotate(Position<Entry<K,V>> position) { tree.rotate(position); }
    protected Position<Entry<K,V>> restructure(Position<Entry<K,V>> position) { return tree.restructure(position); }

    /**
     * Returns the position in p's subtree having given key (or else the
     * terminal leaf)
     */

    private Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> position, K key) {
        if (isExternal(position))
            return position;
        int comp = compare(position.getElement().getKey(), key);
        if (comp == 0) return position;
        else if (comp < 0) return treeSearch(left(position), key);
        else return treeSearch(right(position), key);
    }

    @Override
    public V get(K key) {
        checkKey(key);
        Position<Entry<K,V>> position = treeSearch(root(), key);
        rebalanceAccess(position);
        if (isExternal(position)) {
            return null;
        }
        return position.getElement().getValue();
    }

    @Override
    public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> entry = new MapEntry<>(key, value);
        Position<Entry<K,V>> position = treeSearch(root(), key);
        if (isExternal(position)) {
            expandExternal(position, entry);
            rebalanceInsert(position);
            return null;
        } else {
            V old = position.getElement().getValue();
            set(position, entry);
            rebalanceAccess(position);
            return old;
        }

    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> position = treeSearch(root(), key);

        if (isExternal(position)) {
            rebalanceAccess(position);
            return null;
        } else {
            V old = position.getElement().getValue();
            //Here we need to check if the element ha both left and right are present
            if (isInternal(left(position)) && isInternal(right(position))) {
                Position<Entry<K,V>> replacement = treeMax(left(position));
                set(position, replacement.getElement());
                position = replacement;
            }

            Position<Entry<K,V>> leaf = isExternal(position) ? left(position) : right(position);
            Position<Entry<K,V>> sibling = sibling(leaf);
            remove(leaf);
            remove(position);
            rebalanceDelete(sibling);
            return old;
        }
    }

    //it gives the parent of the last right (internal) position
    protected Position<Entry<K,V>> treeMax(Position<Entry<K,V>> position) {
        Position<Entry<K,V>> walk = position;

        while (isInternal(position)) {
            walk = right(walk);
        }
        return parent(walk);
    }

    protected Position<Entry<K,V>> treeMin(Position<Entry<K,V>> position) {
        Position<Entry<K,V>> walk = position;

        while(isInternal(walk)) {
            walk = left(walk);
        }
        return walk;
    }

    @Override
    public Entry firstEntry() {
        if (isEmpty()) return null;
        return root().getElement();
    }

    @Override
    public Entry<K,V> lastEntry() {
        if (isEmpty()) return null;
        return treeMax(root()).getElement();
    }

    /**
     * Returns the entry with least key greater than or equal to given key (or
     * null if no such key exists).
     *
     * @return entry with least key greater than or equal to given (or null if
     * no such entry)
     * @throws IllegalArgumentException if the key is not compatible with the
     * map
     */

    @Override
    public Entry<K,V> ceilingEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> position = treeSearch(root(), key);
        if (isInternal(position)) return position.getElement(); //exact match
        while(!(isRoot(position))) { //treeSearch(root(), key); returns the leaf if no match is there, so we need to traverse upwards

            if(position == left(parent(position))) { //here we are checking if the left side of the parent position of the leaf
                                                     //is equal to the result of the treeSearch(root(), key)
                return parent(position).getElement(); //parent has the next greater key
            } else {
                position = parent(position);
            }
        }
        return null;
    }

    /**
     * Returns the entry with greatest key less than or equal to given key (if
     * any).
     */

    @Override
    public Entry<K,V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> position = treeSearch(root(), key);
        if (isInternal(position)) return position.getElement();

        while(!isRoot(position)) {
            if(position == right(parent(position))) {
                return parent(position).getElement(); //parent has the greatest key less than the key.
            } else {
                position = parent(position);
            }
        }
        return null;
    }

    @Override
    public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> position = treeSearch(root(), key);

        if (isInternal(position) && isInternal(left(position))) { return treeMax(left(position)).getElement(); }

        while(!isRoot(position)) {
            if(position == right(parent(position))) {
                return parent(position).getElement();
            }
            else {
                position = parent(position);
            }
        }
        return null;
    }

    @Override
    public Entry<K,V> higherEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K,V>> position = treeSearch(root(), key);

        if (isInternal(position) && isInternal(right(position))) {
            return treeMin(right(position)).getElement();
        }

        while(!isRoot(position)) {
            if (position == left(parent(position))) {
                return parent(position).getElement();
            }
            else {
                position = parent(position);
            }
        }
        return null;
    }

    private void subMarRecurse(K fromKey, K toKey, Position<Entry<K,V>> position, ArrayList<Entry<K,V>> buffer) {
        if(isInternal(position)) {
            if (compare(position.getElement(), fromKey) < 0) { //position is less than key, so get entries to the right
                subMarRecurse(fromKey, toKey, right(position), buffer);
            } else {
                subMarRecurse(fromKey, toKey, left(position), buffer);
            }

            if (compare(position.getElement(), toKey) < 0) {
                buffer.add(position.getElement());
                subMarRecurse(fromKey, toKey, right(position), buffer);
            }
        }
    }

    @Override
    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        if (compare(fromKey, toKey) < 0) { //ensure that fromKey < toKey
            subMarRecurse(fromKey, toKey, root(), buffer);
        }
        return buffer;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty();
    }



    @Override
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> entrySet = new ArrayList<>();
        for (Position<Entry<K,V>> entry : tree.inOrder()) {
            if (isInternal(entry)) {
                entrySet.add(entry.getElement());
            }
        }
        return entrySet;
    }

    protected void rebalanceAccess(Position<Entry<K, V>> p) {
    }

    protected void rebalanceInsert(Position<Entry<K, V>> p) {
    }

    protected void rebalanceDelete(Position<Entry<K,V>> p) {
    }
}
