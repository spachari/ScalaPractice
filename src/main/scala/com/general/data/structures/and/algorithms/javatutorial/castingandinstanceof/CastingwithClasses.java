package com.general.data.structures.and.algorithms.javatutorial.castingandinstanceof;

class Student implements Person {

    String id;
    String name;
    int age;

    Student(String id, String anme, int age) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Person other) { //Because this takes an object, any object can be passed to equals method

        if (other instanceof Person) {
            if (other instanceof Student) {
                Student otherStudent = (Student) other; //So we need to do explicit conversion to Student
                if (((Student) other).age == age && ((Student) other).name == name && ((Student) other).id == id) {
                    return true;
                }
                else {
                    return false;
                }
            } else {
                return false;
            }
        }
        else {
                 return false;
            }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    protected int studyHours() {
        return age / 2;
    }
}

class Teacher implements Person {

    @Override
    public boolean equals(Person person) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }
}

public class CastingwithClasses {
    public static void main(String[] args) {

        //Create two students
        Student s1 = new Student("100", "Srinivas", 38);
        Student s2 = new Student("101", "Kirthika", 38);

        System.out.println(s1.equals(s1));
        System.out.println(s1.equals(s2));

        Teacher t = new Teacher();
        System.out.println(s1.equals(t));

    }
}
