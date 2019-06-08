package com.general.data.structures.and.algorithms.ch5recursion;

/*
----  //drawLine(majorLength, 0);
-
--
-
---
-
--
-
---- 1 //drawLine(majorLength, j);
-
--
-
---
-
--
-
---- 2 //drawLine(majorLength, j);
 */

public class EnglishRuler {

    public void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);  // majorLength 10

        for (int j = 1; j <= nInches; j++) {
            //System.out.println("Drawing interval for " + nInches);
            drawInterval(majorLength - 1);
            drawLine(majorLength,j);
        }
    }

    private String makeString(int numOfSpaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numOfSpaces; i ++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            //System.out.println(makeString(centralLength) + " Before draw line " + centralLength);
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            //System.out.println(makeString(centralLength) + " After draw line " + centralLength);
            drawInterval(centralLength - 1);
            //System.out.println(makeString(centralLength) + " End of draw line " + centralLength);
        }
    }


    public void drawLine(int tickLength, int tickLabel) {
        //System.out.println("tickLength " + tickLength);
        for (int j = 0; j < tickLength; j ++) {
            System.out.print("-");
        }
        if (tickLabel > 0) {
            System.out.print(" " + tickLabel);
        }
        System.out.println();
    }

    public void drawLine(int tickLength) {
        drawLine(tickLength, -1);
    }
}

class EnglishRulerTest {
    public static void main(String[] args) {
        EnglishRuler e = new EnglishRuler();
        e.drawRuler(2,4);
    }
}

