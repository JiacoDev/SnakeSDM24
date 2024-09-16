package com.sdm.snake.movement;

import com.sdm.Position;

public class MovementDownState implements SnakeMovementState {
    @Override
    public Position move(Position currentPosition) {
        return new Position(currentPosition.getX(), currentPosition.getY() - 1);
    }

    @Override
    public boolean canChangeTo(SnakeMovementState newState) {
        return !(newState instanceof MovementUpState);
    }
}
