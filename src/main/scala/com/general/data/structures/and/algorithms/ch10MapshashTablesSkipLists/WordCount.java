package com.general.data.structures.and.algorithms.ch10MapshashTablesSkipLists;

import com.general.data.structures.and.algorithms.ch9priorityqueues.Entry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Map<String, Integer> freq = new HashMap<>();

        Scanner doc = new Scanner(System.in).useDelimiter("[^a-zA-Z]+");
        while (doc.hasNext()) {
            Object counter = freq.get(doc.next());
            if (counter != null) {
                int counts = (Integer) counter;
                freq.put(doc.next(), counts);
            } else {
                freq.put(doc.next(), 1);
            }
        }

        String maxWord = "No word";
        int maxCount = 0;
        for (java.util.Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (maxCount >= entry.getValue()) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        System.out.println("Max word is " + maxWord);
        System.out.println("Max count is " + maxCount);
    }
}
