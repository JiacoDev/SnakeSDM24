package com.sdm.logic;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;
import com.sdm.view.Renderer;
import javafx.animation.AnimationTimer;

/**
 * The {@code GameLoop} class extends {@code AnimationTimer} and handles the core game loop logic for a Snake game.
 * This class controls the game updates, rendering, and interactions between the snake, fruit, and game board.
 *
 * <p>It includes methods to update the game state, render the game objects, and manage the game speed.
 * The game loop will continue running until the game ends, such as when the snake collides with itself or the walls.</p>
 *
 * Class Overview:
 * <ul>
 *   <li>Manages the game's core loop using JavaFX's {@code AnimationTimer}.</li>
 *   <li>Updates the game state on each frame, including the snake's movement and fruit interactions.</li>
 *   <li>Renders the game visuals using the {@code Renderer} class.</li>
 *   <li>Handles game-over logic when a collision is detected.</li>
 * </ul>
 */

public class GameLoop extends AnimationTimer {
    private static final int GAME_SPEED = 10;

    // Game entities and components
    private final Snake snake;
    private final Board board;
    private final Fruit fruit;
    private final Score score = new Score();
    private long lastUpdateTime = 0;
    private double totalGameTime = 0;
    private final Renderer gameRenderer;
    boolean gameOver = false;

    /**
     * Constructor to initialize the {@code GameLoop} with the main game components.
     *
     * @param initSnake        the {@code Snake} object representing the player's snake
     * @param initBoard        the {@code Board} object representing the game board
     * @param initFruit        the {@code Fruit} object representing the fruit in the game
     * @param initGameRenderer the {@code Renderer} object responsible for rendering the game
     */
    public GameLoop(Snake initSnake, Board initBoard, Fruit initFruit, Renderer initGameRenderer) {
        snake = initSnake;
        board = initBoard;
        fruit = initFruit;
        gameRenderer = initGameRenderer;
    }

    /**
     * This method is called every frame by the {@code AnimationTimer}. It manages the timing of game updates and
     * rendering by calculating the time difference between frames. The game updates only if enough time has passed.
     *
     * @param now the current timestamp in nanoseconds provided by the {@code AnimationTimer}
     */
    @Override
    public void handle(long now) {
        if (lastUpdateTime > 0) {
            double deltaTime = (now - lastUpdateTime) / 1_000_000_000.0;
            totalGameTime += deltaTime * GAME_SPEED;
            if (totalGameTime >= 1.0) {
                updateGame();
                drawGame();
                totalGameTime -= 1;
            }
        }
        lastUpdateTime = now;
    }

    /**
     * Renders the game by drawing the snake, fruit, board, and score. If the game is over, it will stop the game loop
     * and render a game-over screen.
     */
    private void drawGame() {
        gameRenderer.draw(snake, fruit, board, score);
        if (gameOver) {
            stop();
            gameRenderer.drawGameOver(score);
        }
    }

    /**
     * Updates the game state based on the current state of the snake, fruit, and board. The game state includes:
     * <ul>
     *   <li>Moving the snake.</li>
     *   <li>Growing the snake and spawning a new fruit if the snake eats the fruit.</li>
     *   <li>Handling collisions, which can result in a game-over scenario.</li>
     * </ul>
     */
    private void updateGame() {
        switch (CollisionHandler.checkCollision(snake, fruit, board)) {
            case GameState.NORMAL -> snake.move();
            case GameState.EAT -> {
                snake.grow();
                score.addToScore(1);
                FruitSpawnHandler.randomFruitMove(snake, fruit, board);
            }
            case GameState.SNAKE_COLLISION, GameState.WALL_COLLISION -> gameOver = true;
        }
    }
}
