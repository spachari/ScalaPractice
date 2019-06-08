package com.general.data.structures.and.algorithms.javatutorial.thisusage;

class A4 {
    B obj;
   public A4 (B obj) {
        this.obj = obj;
    }

    public void display() {
       System.out.println("display in A4");
    }
}

class B {
   public B() {
     A4 a4 = new A4(this); //THis is use d to pass the current object in a constructor call
     a4.display();
    }
}

public class PassAsAnArguementToTheConstructorCall {
    public static void main(String[] args) {
        B b = new B();

    }
}
