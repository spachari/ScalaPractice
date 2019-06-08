package com.general.data.structures.and.algorithms.javatutorial.innerclass.staticinnerclass;

public class StaticOuterClass {
    static class InnerClass {
        public void myMethod() {
            System.out.println("Static Inner class method");
        }
    }
}


class Test {
    public static void main(String[] args) {
        StaticOuterClass.InnerClass myObject = new StaticOuterClass.InnerClass();
        myObject.myMethod();
    }
}
