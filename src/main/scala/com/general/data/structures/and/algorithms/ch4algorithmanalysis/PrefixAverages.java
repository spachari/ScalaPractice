package com.general.data.structures.and.algorithms.ch4algorithmanalysis;

public class PrefixAverages {
    public double[] prefixAverages1(double[] data) {
        double[] temp = new double[data.length];
        for (int i = 0; i < data.length; i ++) {
            double total = 0;
            double numberOfItems = 0;
            for (int j = 0; j <= i; j ++) {
                numberOfItems++;
                total += data[j];
            }
            //System.out.println(total + " " +  numberOfItems);
            double average = total / numberOfItems;
            temp[i] = average;
        }
        return temp;
    }

    public double[] prefixAverages2(double[] array) {
        double[] temp = new double[array.length];
        double total = 0;
        int counter = 1;
        for (int i = 0; i < array.length; i ++) {
            total = total + array[i];
            temp[i] = total / counter;
            counter ++;
        }
        return temp;
    }

}

class PrefixAveragesTest {
    public static void main(String[] args) {
        double[] doubleArray = new double[] {1,2,3,4};
        PrefixAverages p = new PrefixAverages();
        double[] avg = p.prefixAverages1(doubleArray);

        System.out.println("Output .... ");
        for (double d : avg) {
            System.out.print(" " + d);
        }
        System.out.println(" ");

        double[] avg1 = p.prefixAverages2(doubleArray);
        for (double d : avg1) {
            System.out.print(" " + d);
        }
        System.out.println(" ");

    }
}