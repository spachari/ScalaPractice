package com.general.data.structures.and.algorithms.sortinganobject.comparableexample;

import com.general.data.structures.and.algorithms.sortinganobject.comparableexample.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingACollection {
    public static void main(String[] args) {
        Student s1 = new Student("Srinivas", 10);
        Student s2 = new Student("Sachin", 5);
        Student s3 = new Student("Shankar", 15);
        Student s4 = new Student("Sadhana", -1);

        List<Student> list = new ArrayList<>();

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        System.out.println("Original list " + list);

        //THis will not work by default
        Collections.sort(list);

        System.out.println("Sorted list" + list);
    }
}
