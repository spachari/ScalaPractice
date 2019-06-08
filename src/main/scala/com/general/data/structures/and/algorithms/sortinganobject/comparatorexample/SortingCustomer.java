package com.general.data.structures.and.algorithms.sortinganobject.comparatorexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingCustomer {
    public static void main(String[] args) {
        List<Customer> list= new ArrayList<>();
        list.add(new Customer("Srinivas", 10));
        list.add(new Customer("Srinivas", 10));
        list.add(new Customer("Sachin", 10));
        list.add(new Customer("Amithab", 10));

        Collections.sort(list);
    }
}
