package com.general.data.structures.and.algorithms.javatutorial.innerclass.anonymousinnerclassasargs;

public interface Message {
    String greet();
}

class My_class {
    public void displayMessage(Message m) {
        System.out.println(m.greet() + "this is an example of an inner class argument");
    }
}

class Test {
    public static void main(String[] args) {
        My_class myObject = new My_class();
        myObject.displayMessage(new Message() {
            @Override
            public String greet() {
                return "Hello, ";
            }
        });
    }
}
