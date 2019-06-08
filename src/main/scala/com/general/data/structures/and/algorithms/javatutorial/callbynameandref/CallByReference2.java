package com.general.data.structures.and.algorithms.javatutorial.callbynameandref;

public class CallByReference2 {
    int count = 50;

    public int increment(CallByReference2 call, int num) {
        call.count = call.count + num;
        return call.count;
    }

    public static void main(String[] args) {
        CallByReference2 call = new CallByReference2();

        System.out.println("before incrementing " + call.count);
        call.increment(call, 100);
        System.out.println("after incrementing " + call.count);
    }
}
