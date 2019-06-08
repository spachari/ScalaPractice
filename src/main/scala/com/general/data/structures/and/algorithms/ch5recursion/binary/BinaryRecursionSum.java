package com.general.data.structures.and.algorithms.ch5recursion.binary;

public class BinaryRecursionSum {
    public int sum(int[] array) {
        return 1;
    }

    public void printArray(int[] array) {
        int j = array.length - 1;
        while(j >= 0) {
            System.out.println(array[j]);
            j--;
        }
    }

    //The advantage of this technique is we can have access to both sodes of the array
    public void printHalfArray(int[] array) {
        int high = array.length - 1;
        int low = 0;
        System.out.println("First half of array ...");
        while(low < high) {
            System.out.println(array[low]);
            low++;
            high--;
        }

        System.out.println("Second half of array ...");
        int low1 = 0;
        int high1 = array.length - 1;
        while(low1 < high1) {
            System.out.println(array[high1]);
            low1++;
            high1--;
        }
    }

}

class SumBinaryRecursion {
    int[] array;
    int high;
    int low = 0;
    public SumBinaryRecursion(int[] a) {
        array = a;
        high = a.length;
    }

    int n = 0;
    public int sum(int[] array, int incrementor) {
        if (incrementor == 0) {
            return 0;
        }
        else {
            return sum(array, incrementor - 1) + array[incrementor - 1];
        }
    }

    int total = 0;
    public int sum1(int[] array, int low, int high) {
        if (high < low) {
            return 0;
        } else if (high == low) {
            return array[low];
        } else
        {
            int mid = (high + low) / 2;
            System.out.println(" high " +  high + " low " +  low + " mid " + mid);
            return sum1(array, low, mid) + sum1(array, mid + 1, high);
        }
    }
}

class BinaryRecursionSumTest {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        BinaryRecursionSum b = new BinaryRecursionSum();
        b.printArray(array);
        System.out.println();
        System.out.println();
        b.printHalfArray(array);
        System.out.println("------------------------------");
        SumBinaryRecursion s = new SumBinaryRecursion(array);
        System.out.println(s.sum1(array,  0, array.length - 1));

    }
}
