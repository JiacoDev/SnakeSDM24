package com.sdm.model.snake.movement;
import com.sdm.model.Position;

public interface SnakeMovementState {
    Position getNewMovePosition(Position currentPosition);
    boolean canChangeTo(SnakeMovementState newState);
}
