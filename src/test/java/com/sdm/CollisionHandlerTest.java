package com.sdm;

import com.sdm.snake.Direction;
import com.sdm.snake.Snake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CollisionHandlerTest {

    private final static int STARTING_X = 20;
    private final static int STARTING_Y = 20;
    private final static int STARTING_LENGTH = 10;
    private final static int BOARD_WIDTH = 64;
    private final static int BOARD_HEIGHT = 64;

    @Test
    void checkCollisionWithSnake() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Board board = new Board(BOARD_WIDTH,BOARD_HEIGHT);
        Fruit fruit = new Fruit(0,0);

        snake.setDirection(Direction.RIGHT);
        snake.move();
        snake.setDirection(Direction.DOWN);
        snake.move();
        snake.setDirection(Direction.LEFT);
        snake.move();

        Assertions.assertEquals(GameState.SNAKE_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithFruit() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(STARTING_X,STARTING_Y+1);
        Board board = new Board(BOARD_WIDTH,BOARD_HEIGHT);

        snake.move();

        Assertions.assertEquals(GameState.EAT,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithCeiling() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(STARTING_X,STARTING_Y+1);
        Board board = new Board(BOARD_WIDTH,BOARD_HEIGHT);
        while (snake.getHeadYCoordinate() < BOARD_HEIGHT) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithFloor() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(STARTING_X,STARTING_Y+1);
        Board board = new Board(BOARD_WIDTH,BOARD_HEIGHT);

        snake.setDirection(Direction.RIGHT);
        snake.move();
        snake.setDirection(Direction.DOWN);

        while (snake.getHeadYCoordinate() > 0) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithLeftWall() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(STARTING_X,STARTING_Y+1);
        Board board = new Board(BOARD_WIDTH,BOARD_HEIGHT);

        snake.setDirection(Direction.LEFT);

        while (snake.getHeadXCoordinate() > 0) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithRightWall() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(STARTING_X,STARTING_Y+1);
        Board board = new Board(BOARD_WIDTH,BOARD_HEIGHT);

        snake.setDirection(Direction.RIGHT);

        while (snake.getHeadXCoordinate() < BOARD_WIDTH) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }





}