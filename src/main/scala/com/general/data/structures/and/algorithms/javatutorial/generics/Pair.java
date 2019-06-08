package com.general.data.structures.and.algorithms.javatutorial.generics;

public class Pair<A, B> {
    A a;
    B b;

    Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return  a;
    }

    public B getB() {
        return b;
    }
}

class PairTest {
    public static void main(String[] args) {
        Pair bid = new Pair("ORCL", 36.70);
        System.out.println(bid.a.getClass().getCanonicalName());
        System.out.println(bid.b.getClass().getCanonicalName());

        //Simple int array
        int[] intArr = new int[3];
        intArr[0] = 1;
        intArr[1] = 2;
        intArr[2] = 3;

        for (int a : intArr) {
            System.out.println(a);
        }

        //There is an important caveat related to generic types and the use of arrays. Although Java allows the declaration of an
        // array storing a parameterized type, it does not technically allow the instantiation of new arrays involving those types.

        //Fortunately, it allows an array defined with a parameterized type to be initialized with a newly created,
        // nonparametric array, which can then be cast to the parameterized type
        Pair<String, Double>[] pairs = new Pair[3];

        //Pair<String, Double> pairstest = new Pair<String, Double>[2]; //Illegal
        pairs[0] = new Pair<>("Facebook", 130.00);
        pairs[1] = new Pair<>("Google", 1000.00);
        pairs[2] = new Pair<>("Amazon", 1500.00);

        for (Pair p : pairs) {
            System.out.println("Stock name is " + p.a + " and it's price is " + p.b);
        }

    }
}