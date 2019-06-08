package com.general.data.structures.and.algorithms.ch5recursion;

public class FibonacciSeries {
    public int fibonacci(int n) {
        if (n <= 1) { //Base class for multiple variables
            return n;
        } else {
            System.out.println("n = " + n);
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

class FibonacciSeriesTest {
    public static void main(String[] args) {
        FibonacciSeries fs = new FibonacciSeries();
        System.out.println(fs.fibonacci(5));
    }
}
