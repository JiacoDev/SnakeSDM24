package com.sdm.view;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;

/**
 * The {@code Renderer} the interface is responsible for rendering the game elements and displaying the game over screen.
 */

public interface Renderer {
    /**
     * Draws the current state of the game, including the snake, fruit, board, and score.
     */
    void draw(Snake snake, Fruit fruit, Board board, Score score);
    /**
     * Draws the game over screen with the final score.
     */
    void drawGameOver(Score score);
}