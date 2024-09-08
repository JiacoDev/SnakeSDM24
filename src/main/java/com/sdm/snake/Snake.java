package com.sdm.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    final private List<BodyElement> snakeBody = new ArrayList<>();
    private Direction currentDirection;

    /**
     * Constructs a {@code Snake} with the default starting position.
     * The snake's head is placed at coordinates (0, 0), and the snake starts aligned north, moving upwards.
     * The snake's initial length is 1.
     */
    public Snake() {
        snakeBody.add(new BodyElement(0, 0, BodyType.HEAD));
        currentDirection = Direction.UP;
    }

    /**
     * Constructs a {@code Snake} with the head at the specified x and y coordinates and the provided length.
     * The snake starts aligned north and moves upwards.
     *
     * @param startingX the starting X coordinate of the snake's head.
     * @param startingY the starting Y coordinate of the snake's head.
     * @param length    the initial length of the snake; must be greater than 0.
     * @throws IllegalArgumentException if the length is less than or equal to 0.
     */
    public Snake(int startingX, int startingY, int length) {
        if (length > 0) {
            snakeBody.add(new BodyElement(startingX, startingY, BodyType.HEAD));
            for (int i = 1; i < length; i++) {
                snakeBody.add(new BodyElement(startingX, startingY - i, BodyType.TAIL));
            }
            currentDirection = Direction.UP;
        } else {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    /**
     * Returns the current length of the snake, which corresponds to the number of {@link BodyElement}
     * instances making up its body.
     *
     * @return the length of the snake.
     */
    public int getSize(){
        return this.snakeBody.size();
    }

    /**
     * Returns the X coordinate of the snake's head, which is the first element in the {@code snakeBody}.
     *
     * @return the X coordinate of the snake's head.
     */
    public int getHeadXCoordinate() {
        return snakeBody.getFirst().posX();
    }

    /**
     * Returns the Y coordinate of the snake's head, which is the first element in the {@code snakeBody}.
     *
     * @return the Y coordinate of the snake's head.
     */
    public int getHeadYCoordinate(){
        return snakeBody.getFirst().posY();
    }

    /**
     * Updates the current direction of the snake.
     * The snake cannot reverse direction (e.g., from UP to DOWN or LEFT to RIGHT).
     *
     * @param newDirection the new direction for the snake.
     */
    public void setDirection(Direction newDirection) {
        // Prevent reverse direction
        if ((currentDirection == Direction.UP && newDirection != Direction.DOWN) ||
                (currentDirection == Direction.DOWN && newDirection != Direction.UP) ||
                (currentDirection == Direction.LEFT && newDirection != Direction.RIGHT) ||
                (currentDirection == Direction.RIGHT && newDirection != Direction.LEFT)) {
            currentDirection = newDirection;
        }
    }

    /**
     * Returns the current direction of the snake.
     *
     * @return the current direction of the snake
     */
    public Direction getDirection() {
        return currentDirection;
    }

    /**
     * Moves the snake in the current direction by shifting the head to a new position
     * and updating the body. The current head becomes part of the body, a new head
     * is added in the direction of movement, and the last element of the tail is removed.
     * <p>
     * This method only updates the snake's position and does not handle collisions.
     */
    public void move() {
        int oldX = getHeadXCoordinate();
        int oldY = getHeadYCoordinate();
        int newX = oldX;
        int newY = oldY;

        switch (currentDirection) {
            case UP -> newY++;
            case DOWN -> newY--;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }
        //we remove the last element of the list, and we add a head as the first element
        snakeBody.set(0, new BodyElement(oldX, oldY, BodyType.TAIL));
        snakeBody.addFirst(new BodyElement(newX, newY, BodyType.HEAD));
        snakeBody.removeLast();
    }

    /**
     * Adds a new {@link BodyElement} to the snake's body in the current direction.
     * The snake grows by adding a new head while keeping the rest of its body intact.
     */
    public void grow() {
        int oldX = getHeadXCoordinate();
        int oldY = getHeadYCoordinate();
        int newX = oldX;
        int newY = oldY;

        switch (currentDirection) {
            case UP -> newY++;
            case DOWN -> newY--;
            case LEFT -> newX--;
            case RIGHT -> newX++;
        }

        // Add the new head and update the old head to a tail part
        snakeBody.set(0, new BodyElement(oldX, oldY, BodyType.TAIL));
        snakeBody.addFirst(new BodyElement(newX, newY, BodyType.HEAD));
    }

}

