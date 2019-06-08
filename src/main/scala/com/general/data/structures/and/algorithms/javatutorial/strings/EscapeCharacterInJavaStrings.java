package com.general.data.structures.and.algorithms.javatutorial.strings;

public class EscapeCharacterInJavaStrings {
    public static void main(String[] args) {
        String s = "My name is \n Srinivas";
        String s1 = "My name is \b\b\b Srinivas";
        String s2 = "My name is \f Srinivas";
        String s3 = "My name is \'Srinivas\'";
        String s4 = "My name is \"Srinivas\"";
        String s5 = "My name is \t Srinivas";

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}
