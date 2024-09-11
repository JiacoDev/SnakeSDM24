package com.sdm;

import com.sdm.snake.Direction;
import com.sdm.snake.Snake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;



public class SnakeTest {

    private final static int STARTING_X = 10;
    private final static int STARTING_Y = 10;
    private final static int STARTING_LENGTH = 3;

    @Test
    void checkSnakeSize() {
    Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        Assertions.assertEquals(STARTING_LENGTH,snake.getSize());
    }

    @Test
    void checkGrowthOfTheSnake() {
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        snake.grow();
        Assertions.assertEquals(STARTING_LENGTH+1,snake.getSize());
    }

    @ParameterizedTest
    @EnumSource(value = Direction.class) //passing all 4 directions
    void checkGrowthDirection(Direction direction) {
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        //you can't change direction from UP to DOWN (the default direction is UP) so I change it to LEFT then DOWN
        if(direction == Direction.DOWN) {
            snake.setDirection(Direction.LEFT);
            snake.move();
        }
        snake.setDirection(direction);
        snake.grow();
        switch (direction) {
            case UP ->Assertions.assertEquals(11,snake.getHeadYCoordinate());
            case DOWN ->Assertions.assertEquals(9,snake.getHeadYCoordinate());
            case LEFT ->Assertions.assertEquals(9,snake.getHeadXCoordinate());
            case RIGHT ->Assertions.assertEquals(11,snake.getHeadXCoordinate());
        }

    }

    @Test
    void getXHeadCoordinates() {
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        Assertions.assertEquals(STARTING_X,snake.getHeadXCoordinate());
    }

    @Test
    void getYHeadCoordinates() {
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        Assertions.assertEquals(STARTING_Y,snake.getHeadYCoordinate());
    }

    @ParameterizedTest
    @EnumSource(value = Direction.class) //passing all 4 directions
    void checkMoveDirection(Direction direction) {
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        //you can't change direction from UP to DOWN (the default direction is UP) so I change it to LEFT then DOWN
        if(direction == Direction.DOWN) {
            snake.setDirection(Direction.LEFT);
            snake.move();
        }
        snake.setDirection(direction);
        snake.move();
        switch (direction) {
            case UP ->Assertions.assertEquals(11,snake.getHeadYCoordinate());
            case DOWN ->Assertions.assertEquals(9,snake.getHeadYCoordinate());
            case LEFT ->Assertions.assertEquals(9,snake.getHeadXCoordinate());
            case RIGHT ->Assertions.assertEquals(11,snake.getHeadXCoordinate());
        }
    }

    @Test
    void checkReverseMoveDirection() {
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        snake.setDirection(Direction.DOWN);
        Assertions.assertEquals(Direction.UP,snake.getDirection());
    }

    @Test
    void checkYHeadMovement(){
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        for (int i = 0; i < 10; i++) {
            snake.move();
        }
        for (int i = 0; i < 10; i++) {
            snake.setDirection(Direction.RIGHT);
            snake.move();
        }
        Assertions.assertEquals(STARTING_Y+10,snake.getHeadYCoordinate());
    }

    @Test
    void checkXHeadMovement(){
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        for (int i = 0; i < 10; i++) {
            snake.move();
        }
        for (int i = 0; i < 10; i++) {
            snake.setDirection(Direction.RIGHT);
            snake.move();
        }
        Assertions.assertEquals(STARTING_X+10,snake.getHeadXCoordinate());
    }

    @Test
    void checkXTailMovement(){
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        for (int i = 0; i < 10; i++) {
            snake.setDirection(Direction.RIGHT);
            snake.move();
        }
        Assertions.assertEquals(STARTING_X+10-(STARTING_LENGTH-1),snake.getTailXCoordinate(STARTING_LENGTH-1));
    }

    @Test
    void checkYTailMovement(){
        Snake snake = new Snake(STARTING_X, STARTING_Y,STARTING_LENGTH);
        for (int i = 0; i < 10; i++) {
            snake.move();
        }
        Assertions.assertEquals(STARTING_Y+10-(STARTING_LENGTH-1),snake.getTailYCoordinate(STARTING_LENGTH-1));
    }

    @Test
    void getTailXCoordinate() {
        Snake snake = new Snake(STARTING_X,STARTING_Y,STARTING_LENGTH);
        Assertions.assertEquals(STARTING_X,snake.getTailXCoordinate(STARTING_LENGTH-1));
    }

    @Test
    void getTailYCoordinate() {
        Snake snake = new Snake(STARTING_X,STARTING_Y,STARTING_LENGTH);
        Assertions.assertEquals(STARTING_Y-(STARTING_LENGTH-1),snake.getTailYCoordinate(STARTING_LENGTH-1));
    }
}