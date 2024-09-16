package com.sdm;

import com.sdm.model.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreTest {

    @Test
    void checkAddOneToScore() {
        Score score = new Score();
        score.addToScore(1);
        Assertions.assertEquals(10, score.getScore());
    }

    @Test
    void checkAddFiveToScore() {
        Score score = new Score();
        score.addToScore(5);
        Assertions.assertEquals(50, score.getScore());
    }
}
