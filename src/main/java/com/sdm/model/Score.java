package com.sdm.model;

public class Score {

    private int score;

    public Score() {
       score = 0;
    }

    public void addToScore(int amount) {
        score += amount*10;
    }

    public int getScore() {
        return score;
    }
}
