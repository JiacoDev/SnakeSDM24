package com.sdm.logic;

import com.sdm.view.GameRenderer;
import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;

import com.sdm.view.Renderer;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    private static final int GAME_SPEED = 10;
    private final Snake snake;
    private final Board board;
    private final Fruit fruit;
    private final Score score = new Score();
    private long lastUpdateTime = 0;
    private double totalGameTime = 0;
    private final Renderer gameRenderer;
    boolean gameOver = false;

    public GameLoop(Snake initSnake, Board initBoard, Fruit initFruit, Renderer initGameRenderer) {
        snake = initSnake;
        board = initBoard;
        fruit = initFruit;
        gameRenderer = initGameRenderer;

    }

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

    private void drawGame() {
        gameRenderer.draw(snake, fruit, board, score);
        if(gameOver) {
            stop();
            gameRenderer.drawGameOver(score);
        }
    }

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