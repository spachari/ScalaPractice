package com.general.data.structures.and.algorithms.javatutorial.innerclass.accessingprivatemembers;

public class Outer_class {
    private int num = 100;

    //Inner class is used to access private members
    class Inner_class {
        public int get_Int() {
            System.out.println("Method in inner class ");
            return num;
        }
    }


}

class InnerClassTest2 {
    public static void main(String[] args) {
        Outer_class o = new Outer_class();
        Outer_class.Inner_class inner_class = o.new Inner_class();

        int result = inner_class.get_Int();

        System.out.println(result);

    }
}
