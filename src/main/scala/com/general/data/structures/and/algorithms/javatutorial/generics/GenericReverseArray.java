package com.general.data.structures.and.algorithms.javatutorial.generics;

public class GenericReverseArray<T> {

    public <T> T[] reverse(T[] inputArray) {
        int low = 0; int high = inputArray.length - 1;

        System.out.println("low is " + low + " high is " +  high);
        System.out.println();

        while(low < high) {
            System.out.println();
            T temp = inputArray[low];
            System.out.println("low is " + low + " high is " +  high);
            inputArray[low++] = inputArray[high]; //low is incremented here
            System.out.println("low is " + low + " high is " +  high);
            inputArray[high--] = temp;            //high is decremented here
            System.out.println("low is " + low + " high is " +  high);
            for (T i : inputArray) {
                System.out.print( " " + i);
            }
        }

        return inputArray;
    }
}



class GenericReverseArrayTest {
    public static void main(String[] args) {

        Integer[] input = new Integer[]{1,2,3,4,5,6,7,8};

        GenericReverseArray<Integer> g = new  GenericReverseArray<Integer>();
        Integer[] output = g.reverse(input);


    }
}

