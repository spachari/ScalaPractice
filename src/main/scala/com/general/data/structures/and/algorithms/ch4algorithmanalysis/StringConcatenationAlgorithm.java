package com.general.data.structures.and.algorithms.ch4algorithmanalysis;

public class StringConcatenationAlgorithm {
    public static void main(String[] args) {

        String answer = "";
        for (int i = 0; i <= 40 ; i++) {
            answer = answer + "*";
        }

        System.out.println(answer);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 40; i ++) {
            sb.append("*");
        }

        System.out.println(sb.toString());
    }
}
