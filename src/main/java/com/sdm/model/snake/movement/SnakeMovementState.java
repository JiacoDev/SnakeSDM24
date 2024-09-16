package com.sdm.model.snake.movement;

import com.sdm.model.Position;

/**
 * The {@code SnakeMovementState} interface defines the movement behavior for the snake.
 * It provides methods to calculate the next position based on the current movement state,
 * and to determine if a transition to a new movement state is allowed.
 */
public interface SnakeMovementState {

    /**
     * Calculates the new head position of the snake based on the current position
     * and the movement direction.
     *
     * @param currentPosition The current position of the snake's head.
     * @return The new {@code Position} of the snake's head after the move.
     */
    Position getNewMovePosition(Position currentPosition);

    /**
     * Determines if the snake can change from the current movement state to the given new state.
     * This method is typically used to prevent invalid movement changes (e.g., turning directly
     * backward).
     *
     * @param newState The new movement state to transition to.
     * @return {@code true} if the transition is allowed, {@code false} otherwise.
     */
    boolean canChangeTo(SnakeMovementState newState);
}
