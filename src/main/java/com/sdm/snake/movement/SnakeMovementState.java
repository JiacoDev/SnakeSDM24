package com.sdm.snake.movement;
import com.sdm.Position;

public interface SnakeMovementState {
    Position move(Position currentPosition);
    boolean canChangeTo(SnakeMovementState newState);
}
