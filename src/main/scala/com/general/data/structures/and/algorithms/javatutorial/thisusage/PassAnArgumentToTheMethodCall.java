package com.general.data.structures.and.algorithms.javatutorial.thisusage;

public class PassAnArgumentToTheMethodCall {
    public void m(PassAnArgumentToTheMethodCall p) {
        System.out.println("method is invoked");
    }

    public void p() {
        m(this); //This is used to pass the current object as an argument to the method
    }

}

class PassAnArgumentToTheMethodTest {
    public static void main(String[] args) {
        PassAnArgumentToTheMethodCall p = new PassAnArgumentToTheMethodCall();

        p.p();
    }

}
