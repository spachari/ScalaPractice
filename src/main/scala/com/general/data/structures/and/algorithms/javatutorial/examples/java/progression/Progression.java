package com.general.data.structures.and.algorithms.javatutorial.examples.java.progression;

public class Progression {
    long current;

    Progression() {
        this(0L);
    }

    Progression(long current) {
        this.current = current;
    }

    protected void advance() {
        current++;
    }

    public long nextValue() {
        long answer = current;
        this.advance();
        return answer;
    }

    public void printProgression(int val) {
        System.out.print(nextValue()); //Current value

        for (int i = 0; i <= val; i ++) {
            //advance();
            System.out.print(" " + nextValue());
        }
        System.out.println("");
    }
}

class ProgressionTet {
    public static void main(String[] args) {
        Progression p = new Progression(10);
        p.printProgression(10);
    }
}
