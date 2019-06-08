package com.general.data.structures.and.algorithms.ch5recursion.linear;

public class SummAnArray {
    int total;
    public int sum(int[] array, int incrementor) {
        if (incrementor == 0) {
            return total += array[incrementor];
        }
        else {
            total += array[incrementor];
            return sum(array, incrementor - 1);
        }
    }

    int n, totals;
    public int sumProper(int[] array, int arrayElement) {
        if (arrayElement == 0) {
           return 0;
        }
        else {
            return sumProper(array, arrayElement - 1) + array[arrayElement - 1];
        }
    }


    public void printArray(int[] array, int counter) {
        if (counter == 0) {
            System.out.println(array[counter]);
        } else {
            System.out.println(array[counter]);
            printArray(array, counter - 1);
        }
    }


    int j, totalSum;
    public int printArrayWhileLoop(int[] array) {
        j = array.length - 1;
        while (j >= 0) {
            totalSum = totalSum + array[j];
            j--;
        }
        return totalSum;
    }
}

class SummAnArrayTest {
    public static void main(String[] args) {
        SummAnArray s = new SummAnArray();
        int[] array = new int[]{1,2,3,4,5};
        System.out.println(s.sum(array, array.length - 1));
        System.out.println(s.sumProper(array, array.length));

        //s.printArray(array, array.length - 1);
        //System.out.println(s.printArrayWhileLoop(array));
    }
}