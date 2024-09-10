package com.sdm.snake.body;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SnakeBody} class manages the list of body elements that make up the snake.
 * It handles initialization of the snake's body, as well as updates to the head and tail
 * during movement and growth.
 */
public class SnakeBody {
    private final List<BodyElement> bodyElements = new ArrayList<>();

    /**
     * Constructs a {@code SnakeBody} with the specified starting position and length.
     * The head of the snake is placed at the starting coordinates, with the tail extending
     * in a vertical direction.
     *
     * @param startingX the X coordinate of the snake's head.
     * @param startingY the Y coordinate of the snake's head.
     * @param length    the initial length of the snake's body.
     * @throws IllegalArgumentException if the length is less than or equal to 0.
     */
    public SnakeBody(int startingX, int startingY, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        bodyElements.add(new BodyElement(startingX, startingY, BodyType.HEAD));
        for (int i = 1; i < length; i++) {
            bodyElements.add(new BodyElement(startingX, startingY - i, BodyType.TAIL));
        }
    }

    /**
     * Returns the X coordinate of the snake's head.
     *
     * @return the X coordinate of the head of the snake.
     */
    public int getHeadXCoordinate() {
        return bodyElements.getFirst().posX();
    }

    /**
     * Returns the Y coordinate of the snake's head.
     *
     * @return the Y coordinate of the head of the snake.
     */
    public int getHeadYCoordinate() {
        return bodyElements.getFirst().posY();
    }

    /**
     * Returns the X coordinate of the snake's tail element at the specified position.
     *
     * @param position the index of the body element.
     * @return the X coordinate of the tail element at the given position.
     */
    public int getTailXCoordinate(int position) {
        return bodyElements.get(position).posX();
    }

    /**
     * Returns the Y coordinate of the snake's tail element at the specified position.
     *
     * @param position the index of the body element.
     * @return the Y coordinate of the tail element at the given position.
     */
    public int getTailYCoordinate(int position) {
        return bodyElements.get(position).posY();
    }

    /**
     * Sets a new head for the snake by adding a {@link BodyElement} at the specified coordinates.
     * The previous head is updated to a tail part.
     *
     * @param newX the X coordinate for the new head.
     * @param newY the Y coordinate for the new head.
     */
    public void setNewHead(int newX, int newY) {
        bodyElements.addFirst(new BodyElement(newX, newY, BodyType.HEAD));
        bodyElements.set(1, new BodyElement(bodyElements.get(1).posX(), bodyElements.get(1).posY(), BodyType.TAIL));
    }

    /**
     * Removes the last element of the snake's body, typically used during movement.
     */
    public void removeLastElement() {
        bodyElements.removeLast();
    }

    /**
     * Returns the current size of the snake's body, which is the number of {@link BodyElement}s.
     *
     * @return the size of the snake.
     */
    public int getSize() {
        return bodyElements.size();
    }
}


