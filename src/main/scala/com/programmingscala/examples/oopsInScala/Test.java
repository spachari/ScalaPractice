package com.programmingscala.examples.oopsInScala;

 class Animals {

     String name;
     Integer age;

     public Animals (String name, Integer age) {
         this.name = name;
         //System.out.println("name " + name);
         this.age = age;
         //System.out.println("age " + age);
     }

     public void printAnimalDetails() {
         System.out.println("name " + name);
         System.out.println("age " + age);
     }

}

public class Test {
    public static void main(String[] args) {
        Animals a = new Animals("Peter", 2);
        a.printAnimalDetails();

    }
}
