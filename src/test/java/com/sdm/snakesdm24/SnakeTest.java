package com.sdm.snakesdm24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;



public class SnakeTest {

    private final int StartingX = 10;
    private final int StartingY = 10;

    @Test
    void checkSnakeSize() {
        Snake snake = new Snake(StartingX,StartingY,10);
        Assertions.assertEquals(10,snake.getSize());
    }

    @Test
    void checkGrowthOfTheSnake() {
        Snake snake = new Snake();
        snake.grow(Direction.UP);
        Assertions.assertEquals(2,snake.getSize());
    }

    @ParameterizedTest
    @EnumSource(value=Direction.class) //passing all 4 directions
    void checkGrowthDirection(Direction direction) {
        Snake snake = new Snake();
        snake.grow(direction);
        switch (direction) {
            case UP ->Assertions.assertEquals(1,snake.getHeadYCoordinate());
            case DOWN ->Assertions.assertEquals(-1,snake.getHeadYCoordinate());
            case LEFT ->Assertions.assertEquals(-1,snake.getHeadXCoordinate());
            case RIGHT ->Assertions.assertEquals(1,snake.getHeadXCoordinate());
        }

    }

    @Test
    void getXHeadCoordinates() {
        Snake snake = new Snake();
        Assertions.assertEquals(0,snake.getHeadXCoordinate());
    }

    @Test
    void getYHeadCoordinates() {
        Snake snake = new Snake();
        Assertions.assertEquals(0,snake.getHeadYCoordinate());
    }


}