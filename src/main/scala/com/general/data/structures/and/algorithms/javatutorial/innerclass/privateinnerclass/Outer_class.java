package com.general.data.structures.and.algorithms.javatutorial.innerclass.privateinnerclass;

public class Outer_class {

    //In java this is the only way to create Inner_class as private
    private class Inner_class {
        public void print() {
            System.out.println("println in Inner class");
        }
    }

    public void access_inner_class () {
        Inner_class i = new Inner_class();
        i.print();
    }
}

class InnerClassTest {
    public static void main(String[] args) {
        Outer_class o = new Outer_class();
        o.access_inner_class();
    }
}
