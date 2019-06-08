package com.general.data.structures.and.algorithms.javatutorial;

public class Counter {

    private int count;  //instance variable

    public Counter() {
        System.out.println("Counter constructor");  //primary constructor
    }

    public Counter (int initial) {  //secondary constructor
        count = initial;
    }

    public int getCount() {  //accessor method
        return count;
    }

    public int increment() {  //update method 1
        return count++;
    }

    public int increment(int value) { //update method 1
        return value + count;
    }

    public void reset () { //update method 3
        count = 0;
    }
}
