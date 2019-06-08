package com.general.data.structures.and.algorithms.javatutorial.thisusage;


//This is similar to the fluent style programming
public class ThisInAReturnStatement {
    int myInt = 10;

    public ThisInAReturnStatement getThisObject () {
        return this;
    }

    public ThisInAReturnStatement add10() {
        System.out.println("This is the add10 method");
        this.myInt = this.myInt + 100;
        return this;
    }

    public ThisInAReturnStatement multiply() {
        System.out.println("This is the multiply method");
        this.myInt = this.myInt * 3;
        return this;
    }
}


class ThisInAReturnStatementTest {
    public static void main(String[] args) {
        ThisInAReturnStatement t = new ThisInAReturnStatement();
        t.getThisObject().add10().multiply();
        System.out.println(t.myInt);
    }
}