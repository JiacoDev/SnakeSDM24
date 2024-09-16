package com.sdm.view;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;
import javafx.scene.Scene;

/**
 * The {@code GameRenderer} class is responsible for rendering the game elements and displaying the game over screen.
 * It implements the {@code Renderer} interface and provides methods to update the visual representation of the game.
 *
 * <p>This class interacts with the JavaFX {@code Scene} to draw the game state, including the snake, fruit, board, and score.
 * It also provides functionality to switch to a game over screen when the game ends.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Renders the game elements on the screen.</li>
 *   <li>Displays the game over screen when the game ends.</li>
 * </ul>
 */

public class GameRenderer implements Renderer {

    // The JavaFX scene where game elements are drawn
    private final Scene scene;

    /**
     * Constructs a {@code GameRenderer} with the given {@code Scene}.
     *
     * <p>This constructor initializes the renderer with a {@code Scene} where the game elements will be displayed.</p>
     *
     * @param scene the {@code Scene} to be used for rendering the game
     */
    public GameRenderer(Scene scene) {
        this.scene = scene;
    }

    /**
     * Draws the current state of the game, including the snake, fruit, board, and score.
     *
     * <p>This method updates the {@code Scene} root with the current game state, rendering the snake, fruit, board, and score
     * using the {@code Graphic.draw} method.</p>
     *
     * @param snake the {@code Snake} object representing the current state of the snake
     * @param fruit the {@code Fruit} object representing the current position of the fruit
     * @param board the {@code Board} object representing the game board
     * @param score the {@code Score} object representing the current score
     */
    public void draw(Snake snake, Fruit fruit, Board board, Score score) {
        scene.setRoot(Graphic.draw(snake, fruit, board, score));
    }

    /**
     * Draws the game over screen with the final score.
     *
     * <p>This method updates the {@code Scene} root to display the game over screen, which includes the final score and an option
     * to exit the game. The screen is created using the {@code GameOver.createGameOverScene} method.</p>
     *
     * @param score the {@code Score} object representing the final score to be displayed
     */
    public void drawGameOver(Score score) {
        scene.setRoot(GameOver.createGameOverScene(score));
    }
}
