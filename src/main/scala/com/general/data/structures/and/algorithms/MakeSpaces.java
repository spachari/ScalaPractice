package com.general.data.structures.and.algorithms;

public class MakeSpaces {
    public static void main(String[] args) {
        System.out.println("    ");
        int i = 4;
        String space = " ";
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j <= 4; j ++) {
            sb.append(" ");
        }
        sb.toString();

        for (int k = 0; k <= 4; k++) {
            space = space + " ";
        }
        System.out.print("S");
        System.out.print(space);
        System.out.print("S");
    }
}
