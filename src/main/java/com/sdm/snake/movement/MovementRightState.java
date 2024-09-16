package com.sdm.snake.movement;
import com.sdm.Position;

public class MovementRightState implements SnakeMovementState{

    @Override
    public Position move(Position currentPosition) {
        return new Position(currentPosition.getX() + 1, currentPosition.getY());
    }

    @Override
    public boolean canChangeTo(SnakeMovementState newState) {
        return !(newState instanceof MovementLeftState);
    }
}
