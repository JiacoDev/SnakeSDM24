package com.sdm.model.snake;

import com.sdm.model.snake.body.SnakeBody;
import com.sdm.model.Position;
import com.sdm.model.snake.movement.SnakeMovementState;

/**
 * The {@code Snake} class represents a snake in the game, composed of a body, a direction,
 * and a movement manager. This class handles the high-level actions of the snake,
 * delegating the specific tasks of managing the body, movement, and direction to separate components.
 */
public class Snake {
    private final SnakeBody snakeBody;
    private SnakeMovementState currentMovementState;
    private SnakeMovementState nextMovementState;

    public Snake(Position initialPosition, SnakeMovementState initialMovementState, int initialLength) {
        this.snakeBody = new SnakeBody(initialPosition, initialLength);
        this.currentMovementState = initialMovementState;
        this.nextMovementState = initialMovementState;
    }

    public void move() {
        Position newHead = getNextHeadPosition();
        snakeBody.addNewHead(newHead);
        snakeBody.removeLastBodySegment();
    }

    public void grow() {
        Position newHead = getNextHeadPosition();
        snakeBody.addNewHead(newHead);
    }

    public void changeSnakeMovementState(SnakeMovementState newState) {
        if (currentMovementState.canChangeTo(newState)) {
            this.nextMovementState = newState;
        }
    }

    private Position getNextHeadPosition() {
        currentMovementState = nextMovementState;
        return nextMovementState.getNewMovePosition(snakeBody.getHead());
    }

    public Position getBodySegment(int index) {
        return snakeBody.getBodySegment(index);
    }

    public int getSize() {
        return snakeBody.getSize();
    }

    public SnakeMovementState getMovementState() {
        return currentMovementState;
    }
}
