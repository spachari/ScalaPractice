package com.general.data.structures.and.algorithms.javatutorial.incrementanddecrementoperators;

public class Example2 {
    public static void main(String[] args) {
        int[] array = new int[]{5,1,15,20,25};
        int i,j,m, n;
        System.out.println(array[1]);
        i = ++array[1];   //This becomes array[1] + array[1]. array[1] is 2
        System.out.println(i);
        j = array[1]++;   //array[1] is 3
        m = array[i++];   //Assign array[2] to m and do 2++. i is 3
        System.out.println(i);
        n = array[++i];   //do ++i, i becomes 4. array[4] to n. i is 4
        System.out.println(i);

        System.out.println("i = " + i + " j = " + j + " m = " + m + " n = " + n);

        System.out.println();
        System.out.println();
        //Another simple sum
        int[] integerArray = new int[]{1,2,3,4,5,6};
        int a, b;
        System.out.println("integerArray[1] " + integerArray[1]);
        a = ++integerArray[1];   //This sets a = array[1] + 1 = 2 + 1. array[1] = 3
        b = integerArray[1]++;   //This sets b = array[1]. Then add array[1] + 1, array[1] is 4
        System.out.println("a = " + a + " b = " + b);

        System.out.println("Final output of array ...");
        for(int x : integerArray) {
            System.out.print(x + " ");
        }
        System.out.println();

        int c, d;
        c = integerArray[++i];
        d = integerArray[i++];
        System.out.println("c = " + c + " d = " + d);

        System.out.println("Final output of array ...");
        for(int x : integerArray) {
            System.out.print(x + " ");
        }
        System.out.println("Final i is " + i);


    }
}
