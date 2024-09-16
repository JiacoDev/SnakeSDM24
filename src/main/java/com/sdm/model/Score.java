package com.sdm.model;

/**
 * The {@code Score} class represents the player's score in the game.
 * It provides methods to modify and retrieve the score.
 *
 * <p>The score starts at 0 and is increased by a specified amount, which is multiplied by 10,
 * whenever the player earns points.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Initializes the score to 0.</li>
 *   <li>Provides methods to add points to the score and retrieve the current score.</li>
 * </ul>
 */

public class Score {

    private int score;

    /**
     * Constructs a new {@code Score} object with an initial score of 0.
     */
    public Score() {
        score = 0;
    }

    /**
     * Adds a specified amount to the current score.
     * The amount is multiplied by 10 before being added to the score.
     *
     * <p>For example, if the amount is 3, the score is increased by 30.</p>
     *
     * @param amount the amount of points to add to the score
     */
    public void addToScore(int amount) {
        score += amount * 10;
    }

    /**
     * Retrieves the current score.
     *
     * @return the current score
     */
    public int getScore() {
        return score;
    }
}
