package com.sdm;

import com.sdm.snake.Snake;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    private Snake snake;
    private Board board;
    private Fruit fruit;
    private long lastUpdateTime = 0;

    public GameLoop(Snake initSnake, Board initBoard, Fruit initFruit) {
        snake = initSnake;
        board = initBoard;
        fruit = initFruit;
    }

    @Override
    public void handle(long now) {
        if (lastUpdateTime > 0) {
            double deltaTime = (now - lastUpdateTime) / 1_000_000_000.0;
            updateGame(deltaTime);
        }
        lastUpdateTime = now;
    }

    private void updateGame(double deltaTime) {
        System.out.println("Snake position: " + (int)snake.getHeadXCoordinate() + " " + (int)snake.getHeadYCoordinate() + " Direction: " + snake.getDirection());
        snake.move(deltaTime);
    }
}
