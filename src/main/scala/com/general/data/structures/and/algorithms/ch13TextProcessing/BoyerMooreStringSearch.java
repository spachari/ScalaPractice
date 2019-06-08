package com.general.data.structures.and.algorithms.ch13TextProcessing;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreStringSearch {

    private void printMap(Map<Character, Integer> last) {
        for (Character c : last.keySet()) {
            System.out.println(c + " " + last.get(c));
        }
    }
    public int findBoyerMoore(char[] text , char[] pattern) {
        int n = text.length;
        int m = pattern.length;

        if(m == 0) return 0;
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < n; i ++)
            last.put(text[i], -1);
        for (int k = 0; k < m; k ++)
            last.put(pattern[k], k);

        printMap(last);

        int i = m - 1;
        int k = m - 1;
        while(i < n) {
            if (text[i] == pattern[k]) {
                if (k==0) return i;
                i--;
                k--;
            } else {
                i += m - Math.min(k, 1 + last.get(text[i]));
                k = m - 1;
            }
        }
        return -1;
    }
}

class BoyerMooreStringSearchTest {
    public static void main(String[] args) {
        BoyerMooreStringSearch s = new BoyerMooreStringSearch();
        String totalString = "Srinivas Pachari Surendranath Srinivas";
        String stringToSearch = "Sri";
        String stringToSearch1 = "Pach";
        String stringToSearch2 = "Siva";
        //System.out.println(s.findBoyerMoore(totalString.toCharArray(), stringToSearch.toCharArray()));
        System.out.println(s.findBoyerMoore(totalString.toCharArray(), stringToSearch1.toCharArray()));
    }
}