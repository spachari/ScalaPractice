package com.general.data.structures.and.algorithms.ch7listAndIteratorADTs;

import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(0, "Srinivas");
        list.add(1, "Kirthika");
        list.add(2, "Sadhiv");
        list.add(2, "Sadhana");
        list.add(3, "Zoe");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
        list.set(3, "Rani"); //set will replace the current item
        for (String s : list) {
            System.out.println(s);
        }

        list.add(3, "Rani mum");
        System.out.println();
        System.out.println();

        for (String s : list) {
            System.out.println(s);
        }

        MyLinkedList<String> myList = new MyLinkedList<>();
        myList.add(0, "Srinivas");
        myList.add(1, "Kirthika");
        myList.add(2, "Sadhiv");
        myList.add(2, "Sadhana");
        myList.add(3, "Zoe");

        for (String s : myList) {
            System.out.println(s);
        }

    }
}
