package com.general.data.structures.and.algorithms.ch5recursion.linear;

public class ReverseAnArray {

    public int[] reverse(int[] array, int counter, int incrementer, int[] reverseArray) {
        if (counter == 0) {
            return reverseArray;
        } else
        {
            reverseArray[counter - 1] = array[incrementer];
            incrementer ++;
            System.out.println(counter + " counter " + " incrementer " + incrementer);
            return reverse(array, counter - 1,incrementer, reverseArray);
        }
    }

    public int[] reverseProper(int[] array, int high, int low) {
        if (high > low) {
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            System.out.println("high " + high + " low " + low);
            reverseProper(array, high - 1, low + 1);
        }
        return array;
    }

    public int[] reverseWhileLoop(int[] array, int high, int low) {
        while (high > low) {
            System.out.println(high + " " + low);
            int temp = array[low];
            array[high] = temp;
            array[low] = array[high];
            high--;
            low++;
        }
        return array;
    }
}

class ReverserrayTest {
    public static void main(String[] args) {
        ReverseAnArray rev = new ReverseAnArray();
        int[] intArray = new int[]{1,2,3,4,5};
        int[] reverseArray = new int[intArray.length];
        rev.reverse(intArray,intArray.length, 0, reverseArray);

        for (int r : reverseArray) {
            System.out.println(r);
        }

        System.out.println();
        System.out.println();
        int[] output = rev.reverseProper(intArray, intArray.length -1, 0);
        for (int r : output) {
            System.out.println(r);
        }

        System.out.println();

        int[] output1 = rev.reverseWhileLoop(intArray, intArray.length - 1, 0);
        for (int i : output1) {
            System.out.println(i);
        }
        System.out.println();
    }
}