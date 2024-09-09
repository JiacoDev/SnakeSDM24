package com.sdm.snake;

import com.sdm.snake.body.SnakeBody;

public class Snake {
    private final SnakeBody body;
    private final SnakeDirection direction;
    private final SnakeMover mover;

    public Snake(int startingX, int startingY, int length) {
        this.body = new SnakeBody(startingX, startingY, length);
        this.direction = new SnakeDirection(Direction.UP);
        this.mover = new SnakeMover(this);
    }

    public int getSize() {
        return body.getSize();
    }

    public int getHeadXCoordinate() {
        return body.getHeadXCoordinate();
    }

    public int getHeadYCoordinate() {
        return body.getHeadYCoordinate();
    }

    public int getTailXCoordinate(int position) {
        return body.getTailXCoordinate(position);
    }

    public int getTailYCoordinate(int position) {
        return body.getTailYCoordinate(position);
    }

    public Direction getDirection() {
        return direction.getCurrentDirection();
    }

    public void setDirection(Direction newDirection) {
        direction.setDirection(newDirection);
    }

    public void move() {
        mover.move(direction.getCurrentDirection());
    }

    public void grow() {
        mover.grow(direction.getCurrentDirection());
    }

    protected SnakeBody getBody() {
        return body;
    }
}


