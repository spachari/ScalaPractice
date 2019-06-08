package com.general.data.structures.and.algorithms.ch5recursion;

public class CheckUnique {
    public boolean isUnique(int[] array) {
        boolean isArrayUnique = false;
        for (int counter = 0; counter < array.length; counter ++ ) {
            for (int j = 0; j < array.length; j ++){
                if (array[counter] == array[j] && counter != j) {
                    isArrayUnique = true;
                }
            }
        }
        return isArrayUnique;
    }

    public boolean isUniqueRegression(int[] array, int low, int high) {
        boolean isUnique = false;
        if (high < low) {
            return false;
        } else {
            System.out.println(low + " " + high);
            if (array[low] == array[high])
            {
                isUnique = true;
                return isUnique;
            }
            return isUniqueRegression(array, low + 1, high);
        }
    }

    public boolean isUnique3(int[] array, int low, int high) {
        if (low >= high) return false;
        else if (!isUnique3(array, low, high -1)) return false;
        else if (!isUnique3(array, low+ 1, high)) return false;
        else return (array[low] != array[high]);
    }

}


class CheckUniqueTest {
    public static void main(String[] args) {
        CheckUnique c = new CheckUnique();
        int[] myArray = new int[]{1,2,3,4,5,6};
        System.out.println(c.isUnique(myArray));

        System.out.println(c.isUniqueRegression(myArray, 0, myArray.length - 1));

        System.out.println(c.isUnique3(myArray, 0, myArray.length - 1));
    }
}