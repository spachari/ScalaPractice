package com.general.data.structures.and.algorithms.javatutorial.enumeration;

public class Enumeration {
    public enum Day {Mon, Tue, Wed, Thurs, Fri, Sat, Sun}



    public static void main(String[] args) {
        Day today = Day.Mon;
        System.out.println(today);

        Day[] weekdays = Day.values();

        System.out.println(weekdays);

        for (int i = 0; i <= Day.values().length ; i ++) {
            System.out.println(Day.Fri);
        }

        for (Day  day : weekdays) {
            System.out.println(day);
        }



    }

}
