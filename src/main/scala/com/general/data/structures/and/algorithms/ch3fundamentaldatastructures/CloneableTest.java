package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

class Employee {
    private int id;
    private String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId () { return id; }
    public void setId (int i) {id = i;}
    public String getName () { return name; }
    public void setName (String name) {this.name = name; }

    @Override
    public String toString() {
        return "id = " + id + " name = " + name;
    }


}



public class CloneableTest {
    public static void main(String[] args) {
        Employee srini = new Employee(100, "Srinivas");
        System.out.println(srini);
        Employee sriniDup = srini;
        sriniDup.setName("Srinivas Duplicate");
        System.out.println(srini);

        int[] testArr = new int[2];
        testArr = new int[]{1,2};

        int[] clonedArray = testArr.clone();

        clonedArray[0] = 100;

        Utilities.printIntArray(testArr);
        Utilities.printIntArray(clonedArray);

        //Creating a two dimensional array
        int[][] twoDimensionalArray = new int[2][2];
        twoDimensionalArray = new int[][] {
                {1,2},
                {3,4}
        };

        Utilities.printTwoDimensionalArray(twoDimensionalArray);

        int[][] twoDimensionalArray2 = new int[][] {
                {1,2},
                {2,3}
        };

        int[][] clonedTwoDimensionalArray = Utilities.cloneTwoDimensionalArray(twoDimensionalArray);
        Utilities.printTwoDimensionalArray(clonedTwoDimensionalArray);
    }
}
