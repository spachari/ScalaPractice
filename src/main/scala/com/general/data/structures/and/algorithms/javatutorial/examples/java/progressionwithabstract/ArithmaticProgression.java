package com.general.data.structures.and.algorithms.javatutorial.examples.java.progressionwithabstract;


public class ArithmaticProgression extends AbstractProgression {

    long incrementer;

    ArithmaticProgression() {
        this(1, 0);
    }

    ArithmaticProgression(long incrementer) {
        //super();
        //this.incrementer = incrementer;
        //or
        this( incrementer, 0);
    }

    ArithmaticProgression( long incrementer, long current) {
        super(current);
        this.incrementer = incrementer;
    }

    protected void advance() {
        current = current + incrementer;
    }

}

class ArithmaticProgressionTest {
    public static void main(String[] args) {
        AbstractProgression a = new ArithmaticProgression(10, 1000);
        a.printProgression(10);

        AbstractProgression b = new ArithmaticProgression();
        b.printProgression(10);
    }
}
