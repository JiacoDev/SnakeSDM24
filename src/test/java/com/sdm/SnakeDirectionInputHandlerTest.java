package com.sdm;

import com.sdm.snake.Direction;
import com.sdm.snake.Snake;
import com.sdm.snake.movement.MovementDownState;
import com.sdm.snake.movement.MovementLeftState;
import com.sdm.snake.movement.MovementRightState;
import com.sdm.snake.movement.MovementUpState;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnakeDirectionInputHandlerTest {

    private final static Position STARTING_POSITION = new Position(10, 10);
    private final static int STARTING_LENGTH = 3;
    private Snake snake;
    @BeforeEach
    void setUp() {
        snake = new Snake(STARTING_POSITION, new MovementUpState(), STARTING_LENGTH);
    }

    @Test
    void testSnakeWInput() {
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.W, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertInstanceOf(MovementUpState.class, snake.getMovementState());
    }

    @Test
    void testSnakeAInput() {
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.A, false, false, false, false);
        inputHandler.handle(keyEvent);
        snake.move();
        Assertions.assertInstanceOf(MovementLeftState.class, snake.getMovementState());
    }

    @Test
    void testSnakeDInput() {
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.D, false, false, false, false);
        inputHandler.handle(keyEvent);
        snake.move();
        Assertions.assertInstanceOf(MovementRightState.class, snake.getMovementState());
    }

    @Test
    void testSnakeSInput() {
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.S, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertNotEquals(new MovementDownState(), snake.getMovementState());

        snake.changeSnakeMovementState(new MovementLeftState());
        snake.move();
        keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.S, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertNotEquals(new MovementUpState(), snake.getMovementState());
    }
}