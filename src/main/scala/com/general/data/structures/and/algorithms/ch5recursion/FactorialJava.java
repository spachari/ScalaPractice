package com.general.data.structures.and.algorithms.ch5recursion;

public class FactorialJava {
    public int recursion(int num) throws IllegalArgumentException{
        if (num < 0) {
            throw new IllegalArgumentException("");
        }
        else if (num == 0)
            return 1;   //base case
        else
        {
            return num * recursion(num - 1);  //recursive case
        }
    }
}

class FactorialTest {
    public static void main(String[] args) {
        FactorialJava f = new FactorialJava();
        System.out.println(f.recursion(5));
        System.out.println(f.recursion(-1));
    }
}