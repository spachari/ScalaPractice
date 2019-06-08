package com.general.data.structures.and.algorithms.javatutorial.examples.java.progressionwithabstract;

public abstract class AbstractProgression {
    long current;

    AbstractProgression() {
        this(0L);
    }

    AbstractProgression(long current) {
        this.current = current;
    }

    protected abstract void advance();

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