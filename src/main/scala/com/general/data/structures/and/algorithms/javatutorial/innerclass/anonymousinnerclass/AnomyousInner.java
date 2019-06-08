package com.general.data.structures.and.algorithms.javatutorial.innerclass.anonymousinnerclass;

abstract class AnomyousInner {
    public abstract void mymethod();
}


class OuterClass {
    public static void main(String[] args) {
        AnomyousInner n = new AnomyousInner() {
            @Override
            public void mymethod() {
                System.out.println("Anomyous class in java ... ");
            }
        };

        n.mymethod();
    }
}