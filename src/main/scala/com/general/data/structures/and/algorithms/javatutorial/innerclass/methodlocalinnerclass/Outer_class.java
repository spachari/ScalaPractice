package com.general.data.structures.and.algorithms.javatutorial.innerclass.methodlocalinnerclass;

public class Outer_class {

    public void my_method_containing_class() {
        int num = 23;

        class Inner_Class {
            public void print() {
                System.out.println("Inner class method ... " + num);
            }
        }

        Inner_Class i = new Inner_Class();
        i.print();
    }

}

 class Outer_class_test {
     public static void main(String[] args) {
         Outer_class o = new Outer_class();
         o.my_method_containing_class();
     }
}


