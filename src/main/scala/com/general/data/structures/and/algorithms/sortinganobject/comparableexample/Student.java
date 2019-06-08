package com.general.data.structures.and.algorithms.sortinganobject.comparableexample;

public class Student implements Comparable {
    String name;
    int no;

    public Student ( String name, int no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student (name = \"" + name + "\" , no " + no + " )";
    }

    @Override
    public int compareTo(Object o) {

        int stringCompare = this.getName().compareTo (((Student) o).getName());

        if (this.getNo() < ((Student) o).getNo()) {
            return -1;
        } else if (this.getNo() == ((Student) o).getNo()) {
            return stringCompare;
        } else {
            return 1;
        }
    }
}
