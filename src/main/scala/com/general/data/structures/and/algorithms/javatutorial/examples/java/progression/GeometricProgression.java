package com.general.data.structures.and.algorithms.javatutorial.examples.java.progression;


public class GeometricProgression extends Progression {

    protected long incrementer;

    GeometricProgression() {
        this.incrementer = 2;
        super.current = 1;
    }

    GeometricProgression(long incrementer1) {
        super(1);
        incrementer = incrementer1;
    }

    GeometricProgression(long start, long incrementer) {
        super(start);
        this.incrementer = incrementer;
    }

    protected void advance() {
        current = current * incrementer;
    }

}

class GeometricProgressionTest {
    public static void main(String[] args) {
        Progression g = new GeometricProgression();
        g.printProgression(10);

        Progression h = new GeometricProgression(3);
        h.printProgression(10);

        Progression i = new GeometricProgression(100, 3);
        i.printProgression(10);
    }
}