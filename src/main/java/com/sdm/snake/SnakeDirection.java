package com.sdm.snake;

public class SnakeDirection {
    private Direction currentDirection;

    public SnakeDirection(Direction initialDirection) {
        this.currentDirection = initialDirection;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setDirection(Direction newDirection) {
        if ((currentDirection == Direction.UP && newDirection != Direction.DOWN) ||
                (currentDirection == Direction.DOWN && newDirection != Direction.UP) ||
                (currentDirection == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (currentDirection == Direction.RIGHT && newDirection != Direction.LEFT)) {
            this.currentDirection = newDirection;
        }
    }
}
