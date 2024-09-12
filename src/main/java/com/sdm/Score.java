package com.sdm;

public class Score {

    private int score;

    public Score() {
       score = 0;
    }

    public void addToScore(int amount) {
        score += amount;
    }

    public int getScore() {
        return score;
    }
}
