package com.sdm.model.snake.movement;

import com.sdm.model.Position;

public class MovementUpState implements SnakeMovementState{
    @Override
    public Position getNewMovePosition(Position currentPosition) {
        return new Position(currentPosition.getX(), currentPosition.getY() + 1);
    }

    @Override
    public boolean canChangeTo(SnakeMovementState newState) {
        return !(newState instanceof MovementDownState);
    }
}
