package com.scalaCookbook.examples.Methods;

public class ProvingThatThisReturnsTheSameObject {
    public void printThisObject() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        ProvingThatThisReturnsTheSameObject p = new ProvingThatThisReturnsTheSameObject();
        p.printThisObject();
        System.out.println(p);
    }
}
