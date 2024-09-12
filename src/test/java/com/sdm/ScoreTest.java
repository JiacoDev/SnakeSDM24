package com.sdm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreTest {

    @Test
    void checkAddOneToScore() {
        Score score = new Score();
        score.addToScore(1);
        Assertions.assertEquals(1, score.getScore());
    }

    @Test
    void checkAddFiveToScore() {
        Score score = new Score();
        score.addToScore(5);
        Assertions.assertEquals(5, score.getScore());
    }
}
