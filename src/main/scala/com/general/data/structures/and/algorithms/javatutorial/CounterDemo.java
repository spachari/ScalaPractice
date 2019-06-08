package com.general.data.structures.and.algorithms.javatutorial;

public class CounterDemo {
    public static void main(String[] args) {
        Counter c ;  //Declares a variable named Counter and does nothing more than that
        c = new Counter();  //Creates a new object for Counter class and assigns the value to a variable c

        //Classes are known as reference types in Java, and a variable of that type (such as c in our example) is known as a
        // reference variable.

        //A reference variable is capable of storing the location (memory address) of an object from a declared class. Or c can store a Counter
        //We can assign an existing instance of a counter or a new instance of a Counter.
        //c = new Counter();
        //or
        //Counter d = c;

        c.increment();
        c.increment(10);
        int temp = c.getCount();
        System.out.println(temp);
        c.reset();

        Counter d = new Counter(10); //
        d.increment();
        Counter e = d;
        Counter f = d;
        temp = e.getCount();
        System.out.println(temp);
        System.out.println(f.getCount());
        e.increment();
    }
}


//Three event s occur as part of creating a new instance of a class

//Counter c = new Counter();

//1. A new object is allocated in memory ( address = 00001), all it's instance variables are allocated default variables
//2. The constructor for the object is called with the parameters specified. It may even assign a few variables or perform a lot of actions
//3. After the constructor returns, the new operator returns the reference  of the newly created object (in step 1 (memory address 00001))
//and assigns it to the variable (c)