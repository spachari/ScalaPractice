package com.general.data.structures.and.algorithms.javatutorial.inheritance;

public class Test {
    public static void main(String[] args) {
        Animal dog = new Dog();

        ((Dog) dog).eat();
        dog.makeNoice();
    }
}
