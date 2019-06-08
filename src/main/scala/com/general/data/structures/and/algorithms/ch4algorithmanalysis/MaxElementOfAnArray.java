package com.general.data.structures.and.algorithms.ch4algorithmanalysis;

class TestArrays {
    public double maximum(double[] array) {
        double maximum_value = 0;
        for (int d = 0; d < array.length; d ++) {
            if (maximum_value <= array[d]) {
                maximum_value = array[d];
            }
        }
        return maximum_value;
    }

    public boolean disjoint(int[] array1, int[] array2, int[] array3) {
        boolean isDisjoint = true;
        for (int i : array1) {
            for (int j : array2) {
                for (int k : array3) {
                    if (i == j && j == k && i == k) {
                        isDisjoint = false;
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
        return isDisjoint;
    }

    public boolean disjoint2(int[] array1, int[] array2, int[] array3) {
        boolean isDisJoint = true;
        for (int i : array1) {
            for (int j : array2) {
                if (i == j) {
                    for (int k : array3) {
                        if (i == k) {
                            isDisJoint = false;
                            System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
        }
        return isDisJoint;
    }
}

public class MaxElementOfAnArray {
    public static void main(String[] args) {
        double[] doubleArray = new double[10];
        doubleArray = new double[] { 6.11, 1.0, 2.0, 3.7, 4.9, 5.10};

        TestArrays t = new TestArrays();

        System.out.println(doubleArray[0]);
        System.out.println(t.maximum(doubleArray));

        int[] array1 = new int[] {1,2,3,4,5,11};
        int[] array2 = new int[] {1,6,7,8,9,10};
        int[] array3 = new int[] {11,12,13,14,15};

        System.out.println("disjoint " + t.disjoint(array1, array2, array3));
        System.out.println("disjoint2 " + t.disjoint2(array1, array2, array3));


    }
}
