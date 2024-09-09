package com.sdm.snake;

import com.sdm.snake.body.SnakeBody;

public class SnakeMover {
    private final Snake snake;

    public SnakeMover(Snake snake) {
        this.snake = snake;
    }

    public void move(Direction direction) {
        SnakeBody body = snake.getBody();
        int oldX = body.getHeadXCoordinate();
        int oldY = body.getHeadYCoordinate();
        int newX = oldX;
        int newY = oldY;

        switch (direction) {
            case UP -> newY++;
            case DOWN -> newY--;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        body.setNewHead(newX, newY);
        body.removeLastElement();
    }

    public void grow(Direction direction) {
        SnakeBody body = snake.getBody();
        int oldX = body.getHeadXCoordinate();
        int oldY = body.getHeadYCoordinate();
        int newX = oldX;
        int newY = oldY;

        switch (direction) {
            case UP -> newY++;
            case DOWN -> newY--;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        body.setNewHead(newX, newY);
    }
}

