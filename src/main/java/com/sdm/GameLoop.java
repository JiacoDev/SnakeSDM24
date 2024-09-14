package com.sdm;

import com.sdm.snake.Snake;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;

public class GameLoop extends AnimationTimer {

    private final int GAME_SPEED = 10;

    private Snake snake;
    private Board board;
    private Fruit fruit;
    private Scene scene;
    private Score score = new Score();
    private long lastUpdateTime = 0;
    private double totalGameTime = 0;

    public GameLoop(Snake initSnake, Board initBoard, Fruit initFruit, Scene initScene) {
        snake = initSnake;
        board = initBoard;
        fruit = initFruit;
        scene = initScene;
    }

    @Override
    public void handle(long now) {
        if (lastUpdateTime > 0) {
            double deltaTime = (now - lastUpdateTime) / 1_000_000_000.0;
            totalGameTime += deltaTime * GAME_SPEED;
            if (totalGameTime >= 1.0) {
                updateGame();
                //Draw func
                scene.setRoot(Graphic.draw(snake, fruit, board, score));
                totalGameTime -= 1;
            }
        }
        lastUpdateTime = now;
    }

    private void updateGame() {
        switch (CollisionHandler.checkCollision(snake, fruit, board)) {
            case NORMAL -> snake.move();
            case EAT -> {
                snake.grow();
                score.addToScore(1);
                FruitSpawnHandler.randomFruitMove(snake, fruit, board);

            }
            case SNAKE_COLLISION -> Platform.exit();
            case WALL_COLLISION -> Platform.exit();
        }

    }

}