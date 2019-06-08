package com.general.data.structures.and.algorithms.ch13TextProcessing;

import com.general.data.structures.and.algorithms.ch3fundamentaldatastructures.Utilities;

public class BruteForceStringSearch {
    public int search(char[] totalString, char[] stringToSearch) {

        for (int i = 0; i < totalString.length; i ++) {
            int totalStringCounter = i;
            int searchStringCounter = 0;
            char[] tempArray = new char[stringToSearch.length];
            int tempArrayCounter = 0;
            while(totalStringCounter < totalString.length && searchStringCounter < stringToSearch.length) {
                //System.out.print(totalString[totalStringCounter]);
                tempArray[tempArrayCounter++] = totalString[totalStringCounter++];
                searchStringCounter++;
            }
            //System.out.println();
            //Utilities.printCharArray(tempArray);
            //Utilities.printCharArray(stringToSearch);
            if (isSame(tempArray, stringToSearch)) {
                return i;
            }

        }
        return -1;
    }

    public boolean isSame (char[] array1, char[] array2) {
        boolean isSame = true;
        if (array1.length != array2.length) {
            return false;
        } else {
            int counter = array1.length - 1;
            while(counter >= 0) {
                //System.out.println("Comparing " + array1[counter] + " " + array2[counter]);
                if (array1[counter] == array2[counter]) {
                    isSame = true;
                } else {
                    return false;
                }
                counter--;
            }
        }
        return isSame;
    }

    public int searchv1(char[] totalArray, char[] arrayToSearch) {
        int m = totalArray.length;
        int n = arrayToSearch.length;

        for (int i = 0 ; i < m - n; i ++) {
            int j = 0;                      //This is the draw back, j is pushed back to the next element in case of a mismatch
            System.out.println("Checking for " + totalArray[i]);
            while(j < m && totalArray[i + j] == arrayToSearch[j]) { //from i if the first character matches,
                                                                             //then keep checking till the last of the pattern
                System.out.println(totalArray[i + j] + " " +  arrayToSearch[j]);
                j++;
                if (j == n) {                                       //if j reaches n(number of pattern length), then perfect match
                    return i;
                }

            }
        }
        return -1;
    }


    public int searchv2(char[] text, char[] pattern) {
        int m = text.length;
        int n = pattern.length;
        for (int i = 0; i < m; i ++) {
            int k = 0;
            while(k < m && text[i + k] == pattern[k]) {
                System.out.println(text[i + k] + " " + pattern[k]);
                k++;
                if (k == n) { //if this successful match has gone till n, then it is a success
                    return i;
                }
            }
        }
        return -1;
    }
}


class BruteForceStringSearchTest {
    public static void main(String[] args) {
        BruteForceStringSearch b = new BruteForceStringSearch();
        String totalString = "Srinivas Pachari Surendranath Srinivas";
        String stringToSearch = "Sri";
        String stringToSearch1 = "Pach";
        String stringToSearch2 = "Siva";
        b.search(totalString.toCharArray(), stringToSearch.toCharArray());

        char[] int1 = new char[]{'1','2','3','5'};
        char[] int2 = new char[]{'0','2','3','5'};

       System.out.println(b.isSame(int1, int2));
       System.out.println(b.search(totalString.toCharArray(), stringToSearch.toCharArray()));
       System.out.println(b.search(totalString.toCharArray(), stringToSearch1.toCharArray()));
       System.out.println(b.search(totalString.toCharArray(), stringToSearch2.toCharArray()));

        String totalString1 = "Pac Srinivas Pachari Surendranath Srinivas";
        String stringToSearch10 = "Sri";
        String stringToSearch11 = "Pach";
        String stringToSearch21 = "Siva";
        String stringToSearch22 = "vas";

        //System.out.println(b.searchv1(totalString1.toCharArray(), stringToSearch10.toCharArray()));
        System.out.println(b.searchv2(totalString1.toCharArray(), stringToSearch11.toCharArray()));
        System.out.println(b.searchv2(totalString1.toCharArray(), stringToSearch21.toCharArray()));
        System.out.println(b.searchv2(totalString1.toCharArray(), stringToSearch22.toCharArray()));

    }
}