package com.general.data.structures.and.algorithms.ch12SortingAndSearching.mergesort;

import java.util.Comparator;

public class MergeSort1 {
    public static <K> void merge(K[] in, K[] out, Comparator<K> comp, int start, int inc) { //start = 1, inc = 4
        int end1 = Math.min(start + inc, in.length); //boundary for run 1 .                 //5
        int end2 = Math.min(start + 2 * inc, in.length); //boundary for run 2               //9

        int x = start;
        int y = start + inc;
        int z = start;

        while(x < end1 && y < end2) { // will run till (1 < 5 && 4 < 9)
            if (comp.compare(in[x], in[y]) < 0) {
                out[z++] = in[x++];
            } else {
                out[z++] = in[y++];
            }

            if (x < end1) System.arraycopy(in, x, out, z, end1 - x);  //copy the rest of run 1
            else if (y < end2) System.arraycopy(in, y, out, z, end2 - y); //copy the rest of run 2
        }
    }

    public static <K> void mergeSortBottomUp(K[] orig, Comparator<K> comp) {
        int n = orig.length;

        K[] src = orig;
        K[] dest = (K[]) new Object[n];
        K[] temp;

        for (int i = 1; i < n; i *= 2) {  //This loop will increment by i = 1, j = 4
                                          //i = 2, j = 8
                                          //i = 4, j = 16
            for (int j = 0; j < n; j += 2 * i) {
                merge(src, dest, comp, j, i);
            }
            temp = src; src = dest; dest = temp;
        }
        if (orig != src) {
            System.arraycopy(src, 0, orig, 0, n);
        }
    }
}
