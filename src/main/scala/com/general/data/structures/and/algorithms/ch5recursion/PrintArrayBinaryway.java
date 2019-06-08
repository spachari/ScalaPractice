package com.general.data.structures.and.algorithms.ch5recursion;

public class PrintArrayBinaryway {

    int[] intArray;
    public PrintArrayBinaryway (int[] intialArray) {
        this.intArray = intialArray;
    }

    private void printBetweenPositions(int startPos, int endPos) {
        for (int i = startPos; i < endPos; i ++) {
            System.out.print(intArray[i]);
        }
        System.out.println();
    }

    public void printBinaryArray(int startPos, int endPos) {
        if (endPos == 1) {
            System.out.println(intArray[0]);
        }
        else {
            printBetweenPositions(startPos, endPos);
            int newEndPos = endPos / 2;
            printBinaryArray(startPos, newEndPos);
        }
    }


}

class PrintArrayBinarywayTest {
    public static void main(String[] args) {

        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10,11};
        PrintArrayBinaryway b = new PrintArrayBinaryway(intArray);
        b.printBinaryArray(0,intArray.length - 1);


    }
}