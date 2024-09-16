package com.sdm;

import com.sdm.snake.Direction;
import com.sdm.snake.Snake;
import com.sdm.snake.movement.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;



public class SnakeTest {

    private final static Position STARTING_POSITION = new Position(10, 10);
    private final static int STARTING_LENGTH = 3;
    private Snake snake;
    @BeforeEach
    void setUp() {
        snake = new Snake(STARTING_POSITION, new MovementUpState(), STARTING_LENGTH);
    }

    @Test
    void checkSnakeSize() {
        Assertions.assertEquals(STARTING_LENGTH,snake.getSize());
    }

    @Test
    void checkGrowthOfTheSnake() {
        snake.grow();
        Assertions.assertEquals(STARTING_LENGTH+1,snake.getSize());
    }

//    @Test
//    void checkGrowthDirection(SnakeMovementState snakeMovementState) {
//        //you can't change direction from UP to DOWN (the default direction is UP) so I change it to LEFT then DOWN
//        if(snakeMovementState instanceof MovementLeftState) {
//            snake.changeSnakeMovementState(new MovementLeftState());
//            snake.move();
//        }
//        snake.changeSnakeMovementState(snakeMovementState);
//        snake.grow();
//        switch (snakeMovementState) {
//            case MovementUpState ignored ->Assertions.assertEquals(11,snake.getBodySegment(0).getY());
//            case MovementDownState ignored ->Assertions.assertEquals(9,snake.getBodySegment(0).getY());
//            case MovementLeftState ignored ->Assertions.assertEquals(9,snake.getBodySegment(0).getX());
//            case MovementRightState ignored ->Assertions.assertEquals(11,snake.getBodySegment(0).getX());
//            default -> throw new IllegalStateException("Unexpected value: " + snakeMovementState);
//        }
//    }

    @Test
    void getXHeadCoordinates() {
        Assertions.assertEquals(STARTING_POSITION.getX(),snake.getBodySegment(0).getX());
    }

    @Test
    void getYHeadCoordinates() {
        Assertions.assertEquals(STARTING_POSITION.getY(),snake.getBodySegment(0).getY());
    }

//    @ParameterizedTest
//    @EnumSource(value = Direction.class) //passing all 4 directions
//    void checkMoveDirection(Direction direction) {
//        //you can't change direction from UP to DOWN (the default direction is UP) so I change it to LEFT then DOWN
//        if(direction == Direction.DOWN) {
//            snake.changeSnakeMovementState(new MovementLeftState());
//            snake.move();
//        }
//        snake.changeSnakeMovementState(direction);
//        snake.move();
//        switch (direction) {
//            case UP ->Assertions.assertEquals(11,snake.getHeadYCoordinate());
//            case DOWN ->Assertions.assertEquals(9,snake.getHeadYCoordinate());
//            case LEFT ->Assertions.assertEquals(9,snake.getHeadXCoordinate());
//            case RIGHT ->Assertions.assertEquals(11,snake.getHeadXCoordinate());
//        }
//    }

    @Test
    void checkReverseMoveDirection() {
        snake.changeSnakeMovementState(new MovementDownState());
        Assertions.assertInstanceOf(MovementUpState.class,snake.getMovementState());
    }

    @Test
    void checkYHeadMovement(){
        for (int i = 0; i < 10; i++) {
            snake.move();
        }
        for (int i = 0; i < 10; i++) {
            snake.changeSnakeMovementState(new MovementRightState());
            snake.move();
        }
        Assertions.assertEquals(STARTING_POSITION.getY()+10,snake.getBodySegment(0).getY());
    }

    @Test
    void checkXHeadMovement(){
        for (int i = 0; i < 10; i++) {
            snake.move();
        }
        for (int i = 0; i < 10; i++) {
            snake.changeSnakeMovementState(new MovementRightState());
            snake.move();
        }
        Assertions.assertEquals(STARTING_POSITION.getX()+10,snake.getBodySegment(0).getX());
    }

    @Test
    void checkXTailMovement(){
        for (int i = 0; i < 10; i++) {
            snake.changeSnakeMovementState(new MovementRightState());
            snake.move();
        }
        Assertions.assertEquals(STARTING_POSITION.getX()+10-(STARTING_LENGTH-1),snake.getBodySegment(STARTING_LENGTH-1).getX());
    }

    @Test
    void checkYTailMovement(){
        for (int i = 0; i < 10; i++) {
            snake.move();
        }
        Assertions.assertEquals(STARTING_POSITION.getY()+10-(STARTING_LENGTH-1),snake.getBodySegment(STARTING_LENGTH-1).getY());
    }

    @Test
    void getTailXCoordinate() {
        Assertions.assertEquals(STARTING_POSITION.getX(),snake.getBodySegment(STARTING_LENGTH-1).getX());
    }

    @Test
    void getTailYCoordinate() {
        Assertions.assertEquals(STARTING_POSITION.getY()-(STARTING_LENGTH-1),snake.getBodySegment(STARTING_LENGTH-1).getY());
    }
}