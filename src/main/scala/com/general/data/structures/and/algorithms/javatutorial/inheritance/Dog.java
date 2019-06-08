package com.general.data.structures.and.algorithms.javatutorial.inheritance;

public class Dog implements Animal {
    @Override
    public void makeNoice() {
        System.out.println("Bow");
    }

    public void eat() {
        System.out.println("Biscuit");
    }
}
