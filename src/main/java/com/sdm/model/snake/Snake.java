package com.sdm.model.snake;

import com.sdm.model.snake.body.SnakeBody;
import com.sdm.model.Position;
import com.sdm.model.snake.movement.SnakeMovementState;

/**
 * The {@code Snake} class represents the snake entity in the game, managing its movement,
 * and behavior. It handles the growth, movement state transitions, and positioning of the snake.
 * The Snake movement implementation follows the State design pattern.
 */
public class Snake {
    private final SnakeBody snakeBody;
    private SnakeMovementState currentMovementState;
    private SnakeMovementState nextMovementState;

    /**
     * Constructs a new {@code Snake} instance with an initial position, movement state, and length.
     *
     * @param initialPosition      The starting position of the snake's head.
     * @param initialMovementState The initial movement state of the snake (e.g., moving up, down).
     * @param initialLength        The initial length of the snake.
     */
    public Snake(Position initialPosition, SnakeMovementState initialMovementState, int initialLength) {
        this.snakeBody = new SnakeBody(initialPosition, initialLength);
        this.currentMovementState = initialMovementState;
        this.nextMovementState = initialMovementState;
    }

    /**
     * Moves the snake forward by adding a new head position and removing the last body segment.
     * The movement is based on the current movement state.
     */
    public void move() {
        Position newHead = getNextHeadPosition();
        snakeBody.addNewHead(newHead);
        snakeBody.removeLastBodySegment();
    }

    /**
     * Grows the snake by adding a new head position without removing the last body segment.
     * This is called when the snake consumes food.
     */
    public void grow() {
        Position newHead = getNextHeadPosition();
        snakeBody.addNewHead(newHead);
    }

    /**
     * Changes the snake's movement state to the specified new state if the transition is valid.
     * The movement state controls the direction in which the snake moves.
     *
     * @param newState The new movement state to be applied.
     */
    public void changeSnakeMovementState(SnakeMovementState newState) {
        if (currentMovementState.canChangeTo(newState)) {
            this.nextMovementState = newState;
        }
    }

    /**
     * Calculates and returns the next position of the snake's head based on the current
     * movement state. This method updates the current movement state to the next state.
     *
     * @return The next position of the snake's head.
     */
    private Position getNextHeadPosition() {
        currentMovementState = nextMovementState;
        return nextMovementState.getNewMovePosition(snakeBody.getHead());
    }

    /**
     * Retrieves the position of a specific segment of the snake's body.
     *
     * @param index The index of the body segment to retrieve.
     * @return The position of the body segment at the given index.
     */
    public Position getBodySegment(int index) {
        return snakeBody.getBodySegment(index);
    }

    /**
     * Returns the current size of the snake, i.e., the number of segments in its body.
     *
     * @return The size of the snake.
     */
    public int getSize() {
        return snakeBody.getSize();
    }

    /**
     * Retrieves the current movement state of the snake, which indicates its direction.
     *
     * @return The current {@code SnakeMovementState} of the snake.
     */
    public SnakeMovementState getMovementState() {
        return currentMovementState;
    }
}
