package com.general.data.structures.and.algorithms.ch3fundamentaldatastructures;

public class GameEntry {
    String name;
    int score;

    GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
