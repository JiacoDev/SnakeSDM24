package com.sdm;

import com.sdm.snake.Snake;
import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    private Snake snake;
    private Board board;
    private Fruit fruit;
    private long lastUpdateTime = 0;
    private double totalGameTime = 0;

    public GameLoop(Snake initSnake, Board initBoard, Fruit initFruit) {
        snake = initSnake;
        board = initBoard;
        fruit = initFruit;
    }

    @Override
    public void handle(long now) {
        if (lastUpdateTime > 0) {
            double deltaTime = (now - lastUpdateTime) / 1_000_000_000.0;
            totalGameTime += deltaTime;
            if(totalGameTime >= 1.0) {
                updateGame();
                totalGameTime -= 1;
            }
        }
        lastUpdateTime = now;
    }

    private void updateGame() {
        System.out.println("Snake position: " + snake.getHeadXCoordinate() + " " + snake.getHeadYCoordinate() + " Direction: " + snake.getDirection());
        snake.move();
    }
}
