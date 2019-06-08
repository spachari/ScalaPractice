package com.general.data.structures.and.algorithms.javatutorial.callbynameandref;

public class CallByNameAndRef {
    int data = 50;

    //All parameters in Java are passed by value, that is, any time we pass a parameter to a method, a copy of that parameter
    // is made for use within the method body. So if we pass an int variable to a method, then that variable's integer value
    // is copied. The method can change the copy but not the original. If we pass an object reference as a parameter to a
    // method, then the reference is copied as well.

     void change(int data) { //THis will only change the local copy of the variable
         data = data + 100;
         System.out.println("Inside change method" + data);

    }

    void changeByRef(int num) {
         data = data + num;
    }



    public static void main(String[] args) {
        CallByNameAndRef call = new CallByNameAndRef();
        System.out.println("before addition " + call.data);
        call.change(100);
        System.out.println("after addition by name " + call.data);
        call.changeByRef(100);
        System.out.println("after addition by ref " + call.data);
    }
}
