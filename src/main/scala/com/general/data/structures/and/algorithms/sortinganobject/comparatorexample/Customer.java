package com.general.data.structures.and.algorithms.sortinganobject.comparatorexample;

import com.general.data.structures.and.algorithms.sortinganobject.comparableexample.Student;

import java.util.Comparator;

class Customer implements Comparable {
    String name;
    int no;

    public Customer ( String name, int no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Customer (name = \"" + name + "\" , no " + no + " )";
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Customer) o).getName());
    }
}

class NameComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return ((Customer) o1).getName().compareTo(((Customer) o2).getName());
    }

    @Override
    public boolean equals(Object obj) {
        return this.equals(obj);
    }
}