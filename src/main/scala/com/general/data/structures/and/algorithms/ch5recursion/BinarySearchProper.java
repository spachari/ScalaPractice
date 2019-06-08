package com.general.data.structures.and.algorithms.ch5recursion;

public class BinarySearchProper {
    public boolean binarySearch(int [] array, int target, int low, int high) {
        System.out.println("low " + low + " high " + high);
        if (low > high) {
            return false;
        }
        else {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return true;
            }
            else if (array[mid] > target) {
                System.out.println(array[mid] + " lower than " + target);
                return binarySearch(array, target, low, mid - 1);
            }
            else {
                System.out.println(array[mid] + " greater than " + target);
                return binarySearch(array, target, mid + 1, high);
            }
        }
    }
}

class BinarySearchProperTest {
    public static void main(String[] args) {
        BinarySearchProper p = new BinarySearchProper();
        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(p.binarySearch(intArray, 8, 0, intArray.length));

    }
}

