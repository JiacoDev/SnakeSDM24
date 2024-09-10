package com.sdm.snake;

import com.sdm.snake.body.SnakeBody;

/**
 * The {@code Snake} class represents a snake in the game, composed of a body, a direction,
 * and a movement manager. This class handles the high-level actions of the snake,
 * delegating the specific tasks of managing the body, movement, and direction to separate components.
 */
public class Snake {
    private final SnakeBody body;
    private final SnakeDirection direction;
    private final SnakeMover mover;

    /**
     * Constructs a {@code Snake} object with the specified starting coordinates and length.
     * The snake starts facing upwards by default.
     *
     * @param startingX the starting X coordinate of the snake's head.
     * @param startingY the starting Y coordinate of the snake's head.
     * @param length    the initial length of the snake; must be greater than 0.
     * @throws IllegalArgumentException if the length is less than or equal to 0.
     */
    public Snake(double startingX, double startingY, int length) {
        this.body = new SnakeBody(startingX, startingY, length);
        this.direction = new SnakeDirection(Direction.UP);
        this.mover = new SnakeMover(this);
    }

    /**
     * Returns the current size of the snake, which corresponds to the number of body elements.
     *
     * @return the size of the snake.
     */
    public int getSize() {
        return body.getSize();
    }

    /**
     * Returns the X coordinate of the snake's head.
     *
     * @return the X coordinate of the head.
     */
    public double getHeadXCoordinate() {
        return body.getHeadXCoordinate();
    }

    /**
     * Returns the Y coordinate of the snake's head.
     *
     * @return the Y coordinate of the head.
     */
    public double getHeadYCoordinate() {
        return body.getHeadYCoordinate();
    }

    /**
     * Returns the X coordinate of a specific body segment, referred to as the tail, at the given position.
     *
     * @param position the position of the body segment to retrieve.
     * @return the X coordinate of the specified body segment.
     */
    public double getTailXCoordinate(int position) {
        return body.getTailXCoordinate(position);
    }

    /**
     * Returns the Y coordinate of a specific body segment, referred to as the tail, at the given position.
     *
     * @param position the position of the body segment to retrieve.
     * @return the Y coordinate of the specified body segment.
     */
    public double getTailYCoordinate(int position) {
        return body.getTailYCoordinate(position);
    }

    /**
     * Returns the current direction of the snake's movement.
     *
     * @return the current direction of the snake.
     */
    public Direction getDirection() {
        return direction.getCurrentDirection();
    }

    /**
     * Sets a new direction for the snake. The snake cannot reverse its direction.
     *
     * @param newDirection the new direction to set for the snake.
     */
    public void setDirection(Direction newDirection) {
        direction.setDirection(newDirection);
    }

    /**
     * Moves the snake in its current direction, updating the body accordingly.
     * The last body segment is removed and a new head is added in the new direction.
     */
    public void move(double deltaTime) {
        mover.move(direction.getCurrentDirection(), deltaTime);
    }

    /**
     * Causes the snake to grow by adding a new head in its current direction,
     * without removing the last body segment.
     */
    public void grow() {
        mover.grow(direction.getCurrentDirection());
    }

    /**
     * Returns the {@code SnakeBody} object, which contains the list of body elements of the snake.
     *
     * @return the snake's body.
     */
    protected SnakeBody getBody() {
        return body;
    }
}
