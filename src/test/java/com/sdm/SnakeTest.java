package com.sdm;

import com.sdm.model.Position;
import com.sdm.model.snake.Snake;
import com.sdm.model.snake.movement.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class SnakeTest {

    private final static Position STARTING_POSITION = new Position(10, 10);
    private final static int STARTING_LENGTH = 3;
    private Snake snake;
    @BeforeEach
    void setUp() {
        snake = new Snake(STARTING_POSITION, new MovementUpState(), STARTING_LENGTH);
    }

    static Stream<SnakeMovementState> directionProvider() {
        return Stream.of(new MovementUpState(), new MovementDownState(), new MovementLeftState(), new MovementRightState());
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

    @ParameterizedTest
    @MethodSource("directionProvider")
    void checkGrowthDirection(SnakeMovementState snakeMovementState) {
        //you can't change direction from UP to DOWN (the default direction is UP) so I change it to LEFT then DOWN
        if(snakeMovementState instanceof MovementDownState) {
            snake.changeSnakeMovementState(new MovementLeftState());
            snake.move();
        }
        snake.changeSnakeMovementState(snakeMovementState);
        snake.grow();
        switch (snakeMovementState) {
            case MovementUpState ignored ->Assertions.assertEquals(11,snake.getBodySegment(0).getY());
            case MovementDownState ignored ->Assertions.assertEquals(9,snake.getBodySegment(0).getY());
            case MovementLeftState ignored ->Assertions.assertEquals(9,snake.getBodySegment(0).getX());
            case MovementRightState ignored ->Assertions.assertEquals(11,snake.getBodySegment(0).getX());
            default -> throw new IllegalStateException("Unexpected value: " + snakeMovementState);
        }
    }

    @Test
    void getXHeadCoordinates() {
        Assertions.assertEquals(STARTING_POSITION.getX(),snake.getBodySegment(0).getX());
    }

    @Test
    void getYHeadCoordinates() {
        Assertions.assertEquals(STARTING_POSITION.getY(),snake.getBodySegment(0).getY());
    }

    @ParameterizedTest
    @MethodSource("directionProvider")
    void checkMoveDirection(SnakeMovementState snakeMovementState) {
        //you can't change direction from UP to DOWN (the default direction is UP) so I change it to LEFT then DOWN
        if(snakeMovementState instanceof MovementDownState) {
            snake.changeSnakeMovementState(new MovementLeftState());
            snake.move();
        }
        snake.changeSnakeMovementState(snakeMovementState);
        snake.move();
        switch (snakeMovementState) {
            case MovementUpState ignored ->Assertions.assertEquals(11,snake.getBodySegment(0).getY());
            case MovementDownState ignored ->Assertions.assertEquals(9,snake.getBodySegment(0).getY());
            case MovementLeftState ignored ->Assertions.assertEquals(9,snake.getBodySegment(0).getX());
            case MovementRightState ignored ->Assertions.assertEquals(11,snake.getBodySegment(0).getX());
            default -> throw new IllegalStateException("Unexpected value: " + snakeMovementState);
        }
    }

    @Test
    void checkYHeadMovement(){
        for (int i = 0; i < 10; i++) {
            snake.changeSnakeMovementState(new MovementUpState());
            snake.move();
        }
        Assertions.assertEquals(STARTING_POSITION.getY()+10,snake.getBodySegment(0).getY());
    }

    @Test
    void checkXHeadMovement(){
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

    @Test
    void checkCantRemoveHead() {
        snake = new Snake(STARTING_POSITION, new MovementUpState(), 1);
        Assertions.assertEquals(1, snake.getSize());
        snake.move();
        Assertions.assertEquals(1, snake.getSize());
    }

}