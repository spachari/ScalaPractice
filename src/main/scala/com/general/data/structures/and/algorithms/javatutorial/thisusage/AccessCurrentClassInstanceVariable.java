package com.general.data.structures.and.algorithms.javatutorial.thisusage;

public class AccessCurrentClassInstanceVariable {

    //This in a Student class
    int roll;
    String name;
    float fee;

    //Default constructor
    AccessCurrentClassInstanceVariable(int roll, String name, float fee) {
        this.roll = roll;
        this.name = name;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return this.fee + " " +  this.name +  " " +  this.roll;
    }
}

 class AccessCurrentClassInstanceVariableDemo {
    public static void main(String[] args) {
        AccessCurrentClassInstanceVariable a = new AccessCurrentClassInstanceVariable(100, "Srinivas", 100);
        System.out.println(a);
    }
}
