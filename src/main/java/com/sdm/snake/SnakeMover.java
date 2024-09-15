package com.sdm.snake;

/**
 * The {@code SnakeMover} class handles the movement and growth logic of the snake.
 * It is responsible for updating the snake's body based on the current direction
 * and ensuring the snake's movement or growth happens correctly.
 */
public class SnakeMover {
    private final Snake snake;

    /**
     * Constructs a {@code SnakeMover} object, which manages the movement of the given snake.
     *
     * @param snake the snake whose movement is being managed.
     */
    public SnakeMover(Snake snake) {
        this.snake = snake;
    }

    /**
     * Moves the snake in the specified direction. This involves moving the snake's head
     * to a new position based on the direction and removing the last element of its body.
     */
    public void move() {
        int newX = snake.getHeadXCoordinate();
        int newY = snake.getHeadYCoordinate();

        switch (snake.getDirection()) {
            case UP -> newY++;
            case DOWN -> newY--;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        snake.getBody().setNewHead(newX,newY);
        snake.getBody().removeLastElement();
        snake.getSnakeDirection().setLastDirectionBeforeMove(snake.getDirection());
    }

    /**
     * Grows the snake in the specified direction. This involves adding a new head
     * to the snake's body without removing the last element, allowing the snake to grow.
     */
    public void grow() {
        int newX = snake.getHeadXCoordinate();
        int newY = snake.getHeadYCoordinate();

        switch (snake.getDirection()) {
            case UP -> newY++;
            case DOWN -> newY--;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        snake.getBody().setNewHead(newX, newY);
        snake.getSnakeDirection().setLastDirectionBeforeMove(snake.getDirection());
    }
}