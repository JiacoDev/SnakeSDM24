package com.sdm.snake;

/**
 * The {@code SnakeDirection} class encapsulates the logic for managing the current direction of the snake.
 * It ensures that the snake cannot reverse its direction directly (e.g., from UP to DOWN).
 */
public class SnakeDirection {
    private Direction currentDirection;

    /**
     * Constructs a {@code SnakeDirection} with an initial direction.
     *
     * @param initialDirection the initial direction the snake is facing.
     */
    public SnakeDirection(Direction initialDirection) {
        this.currentDirection = initialDirection;
    }

    /**
     * Returns the current direction of the snake.
     *
     * @return the current {@code Direction} the snake is facing.
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    /**
     * Sets a new direction for the snake, ensuring it cannot reverse directly.
     * For example, if the snake is currently moving UP, it cannot be set to move DOWN.
     *
     * @param newDirection the new direction for the snake to move in.
     */
    public void setDirection(Direction newDirection) {
        if ((currentDirection == Direction.UP && newDirection != Direction.DOWN) ||
                (currentDirection == Direction.DOWN && newDirection != Direction.UP) ||
                (currentDirection == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (currentDirection == Direction.RIGHT && newDirection != Direction.LEFT)) {
            this.currentDirection = newDirection;
        }
    }
}

