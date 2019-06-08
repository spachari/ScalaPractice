package com.general.data.structures.and.algorithms.javatutorial.examples.java.progression;


//series to print
//0, 1,1,2,3,5

public class FibonacciProgression extends Progression {

    protected long prev;

    FibonacciProgression() {
        super(0);
        this.prev = 1;
    }

    FibonacciProgression(long first, long second) {
        super(first);
        prev = second;
    }

    public void advance() {
        long temp = prev;
        prev = current;
        current = current + temp;
    }
}

class FibonacciProgressionTest {
    public static void main(String[] args) {
        Progression f = new FibonacciProgression();
        f.printProgression(10);
    }
}