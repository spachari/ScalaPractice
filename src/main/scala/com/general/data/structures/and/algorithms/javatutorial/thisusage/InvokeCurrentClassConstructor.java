package com.general.data.structures.and.algorithms.javatutorial.thisusage;

public class InvokeCurrentClassConstructor {
    String name;

    InvokeCurrentClassConstructor(int num) {
        System.out.println("In CurrentClass Constructor");
    }

    InvokeCurrentClassConstructor(String name) {
        this(10);
        this.name = name; //Current class constructor called
    }
}

class InvokeCurrentClassConstructorTest {
    public static void main(String[] args) {
        InvokeCurrentClassConstructor i = new InvokeCurrentClassConstructor("Srinivas");
        System.out.println(i.name);
        System.out.println();
    }
}

