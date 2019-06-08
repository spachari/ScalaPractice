package com.general.data.structures.and.algorithms.javatutorial.callbynameandref;

public class CallByReference {

    int count;

    public CallByReference(int count) {
        this.count = count;
    }

    public int increment(int increment) {
        count = count + 100;
        return count;
    }

    public static void main(String[] args) {
        CallByReference call = new CallByReference(100);
        System.out.println(call.count);
        call.increment(100);     //We are calling it by reference
        System.out.println(call.count);
    }

}
