package com.general.data.structures.and.algorithms.ch5recursion;

public class BinarySearchImproved {

    int[] intArray;
    int itemTOSearch;

    public BinarySearchImproved(int[] intArray, int itemTOSearch) {
        this.intArray = intArray;
        this.itemTOSearch = itemTOSearch;
    }

    public int binarySearch() {
        int lengthOfIntArray = intArray.length;
        int output = binarySearch(0, lengthOfIntArray);
        System.out.println("Final output is " + output);
        return output;
    }

    public void printArrayPos(int startPos, int endPos) {
        for (int i = startPos; i < endPos; i ++) {
            System.out.print(intArray[i]);
        }
        System.out.println();
    }

    private int binarySearch(int startPos, int endPos) {
        System.out.println("startPos " + startPos + " endPos " + endPos + " middlePoint "
                + intArray[endPos / 2] + " itemTOSearch " + itemTOSearch);
        if (endPos == 1) {
            if (intArray[endPos] == itemTOSearch)
                return itemTOSearch;
            else
            {
                itemTOSearch = -1;
            }
        }
        else {
            int newEndPos = 0;
            if (itemTOSearch < intArray[endPos / 2] ) {
                System.out.println(startPos + " " + endPos / 2);
                binarySearch(startPos, endPos / 2);
            }else if (itemTOSearch > intArray[endPos / 2] ) { //1 to 10, 6
                System.out.println(endPos / 2 + " " + endPos);
                binarySearch(endPos / 2, endPos); //search from mid to end of position in array
            } else {
                return itemTOSearch;
            }
        }
        return itemTOSearch;
    }
}

class BinarySearchImprovedTest {
    public static void main(String[] args) {
        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        BinarySearchImproved b = new BinarySearchImproved(intArray, 4);
        System.out.println(b.binarySearch());
    }
}