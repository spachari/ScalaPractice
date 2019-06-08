package com.general.data.structures.and.algorithms.javatutorial.scannerexample;

import java.util.Scanner;

public class SimpleScanner {
    public static void main(String[] args) {
        Scanner inputAge = new Scanner(System.in);
        System.out.println("Please enter the age of the ");
        double age = inputAge.nextDouble();
        System.out.println(age);

        Scanner inputHeartRate = new Scanner(System.in);
        System.out.println("Please enter the heart rate of the person ");
        double heartRate = inputHeartRate.nextDouble();
        System.out.println(heartRate);

        double fbRate = (heartRate - age) * 65;
        System.out.println("Your fat burning rate is " + fbRate);

        System.out.println("Enter a sentence");
        Scanner inputSentence = new Scanner(System.in);
        while (inputSentence.hasNext()) {
            System.out.println(inputSentence.next());
        }
    }
}
