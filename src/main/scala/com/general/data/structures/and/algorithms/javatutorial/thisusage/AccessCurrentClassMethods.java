package com.general.data.structures.and.algorithms.javatutorial.thisusage;

public class AccessCurrentClassMethods {
    //This in a Student class
    int roll;
    String name;
    float fee;
    int engMark, tamMark;

    AccessCurrentClassMethods(int roll, String name, float fee) {
        this.roll = roll;
        this.name = name;
        this.fee = fee;
    }

    public AccessCurrentClassMethods studentDetails() {
        return new AccessCurrentClassMethods(this.roll, this.name, this.fee);
    }

    private void getStudentMarks() {
        this.engMark = 80;
        this.tamMark = 90;
    }

    public void printStudentDetails() {
        AccessCurrentClassMethods m = this.studentDetails();
        this.getStudentMarks();
        System.out.println(m.roll);
        System.out.println(m.name);
        System.out.println(m.fee);
        System.out.println(this.engMark);
        System.out.println(this.tamMark);
    }
}

class AccessCurrentClassMethodsTest {
    public static void main(String[] args) {
        AccessCurrentClassMethods a = new AccessCurrentClassMethods(100, "Srinivas", 100);
        a.printStudentDetails();
    }
}
