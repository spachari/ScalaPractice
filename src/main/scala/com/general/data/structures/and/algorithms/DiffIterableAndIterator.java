package com.general.data.structures.and.algorithms;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//
public class DiffIterableAndIterator {
    public static void main(String[] args) {

        //1. Iterable vs Iterator
        //Iterable represents a collection that can be traversed.
        List<String> list = new ArrayList<>(Arrays.asList("A","B","C"));
        for (String p : list) {
            System.out.println(p);
        }

        //The above command only works because foreach uses the iterator method, that is from
        // List -implements-> Collection -implements-> Iterable interface
        //and provides a implementation for iterator()

        //1. Iterator
        //It is used to iterate over some other object which is a collection of some kind.
        //In order to use an iterator, we need to use hasNext() + next()
        Iterator<Integer> iterList = Arrays.asList(1,2,3).iterator();

        while(iterList.hasNext()) {
            System.out.println(iterList.next());
        }

        //2. implementation
        //Iterable - implement the iterator() method - this returns an Iterator object
        //Iterator - implement the hasNext() and next() methods

        //3. meaning of both
        //Iterator instance provides a iteration state. It provides utility methods to get current element,
        //check if next element exists and move forward if it is present. In other words it remembers the current
        //position in a collection and returns an element, if present.

        //Iterable does not maintain any such state

        //4. The contract for Iterable is that it returns a new Iterator everytime the iterator() method is called
        //This is because the iteration method maintains iteration state.

        //5. An Iterable can move only in forward direction whereas, the Iterator can move it any direction (ListIterator)

        //6. An Iterable cannot modify the collection, but an Iterator has a remove() method with which we can modify the collection

    }
}
