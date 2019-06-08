package com.general.data.structures.and.algorithms.javatutorial.thisusage;

public class CallingParameterizedConstructorFromDefaultCons {

    CallingParameterizedConstructorFromDefaultCons() {
        this(10);
        //this("Srinivas"); only one this is allowed
    }

    CallingParameterizedConstructorFromDefaultCons(int num) {
        System.out.println("Int Constructor" + num);
    }

    CallingParameterizedConstructorFromDefaultCons(String name) {
        System.out.println("String Constructor" + name);
    }
}

class CallingParameterizedConstructorFromDefaultConsTest {
    public static void main(String[] args) {
        CallingParameterizedConstructorFromDefaultCons c = new CallingParameterizedConstructorFromDefaultCons();

    }
}