package com.sdm.snakesdm24;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<BodyElement> snakeBody = new ArrayList<>();

    /**
     * Constructs a {@code Snake} with the default starting position.
     * The snake's head is placed at coordinates (0, 0) and the snake starts aligned north, moving upwards.
     */
    public Snake() {
        snakeBody.add(new BodyElement(0, 0, BodyType.HEAD));
    }

    /**
     * Constructs a {@code Snake} with the head at the specified x and y coordinates and the provided length.
     * The snake starts aligned north and moves upwards.
     *
     * @param startingX the starting X coordinate of the snake's head
     * @param startingY the starting Y coordinate of the snake's head
     * @param length    the starting length of the snake; must be greater than 0
     * @throws IllegalArgumentException if the length is less than or equal to 0
     */
    public Snake(int startingX, int startingY, int length) {
        if (length > 0) {
            snakeBody.add(new BodyElement(startingX, startingY, BodyType.HEAD));
            for (int i = 1; i < length; i++) {
                snakeBody.add(new BodyElement(startingX, startingY - i, BodyType.TAIL));
            }
        } else {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
    }

    /**
     * Returns the length of the snake
     *
     * @return The length of the snake.
     */
    public int getSize(){
        return this.snakeBody.size();
    }

    /**
     * Returns the X coordinate of the head of the snake.
     *
     * @return the X coordinate of the head of the snake
     */
    public int getHeadXCoordinate() {
        return snakeBody.get(0).posX();
    }

    /**
     * Returns the Y coordinate of the head of the snake.
     *
     * @return the Y coordinate of the head of the snake
     */
    public int getHeadYCoordinate(){
        return snakeBody.get(0).posY();
    }

    /**
     * Adds an element to the body of the snake.
     */
    public void grow(Direction direction) {
        int oldX = getHeadXCoordinate();
        int oldY= getHeadYCoordinate();
        int newX = oldX;
        int newY = oldY;
        switch (direction) {
            case UP -> newY++;
            case DOWN -> newY--;
            case LEFT -> newX--;
            case RIGHT -> newX++;
            default -> throw new IllegalArgumentException("Direction must be UP, DOWN, LEFT, or RIGHT");
        }
        snakeBody.set(0, new BodyElement(oldX, oldY, BodyType.TAIL));

        snakeBody.add(0, new BodyElement(newX, newY, BodyType.HEAD));
    }

}
