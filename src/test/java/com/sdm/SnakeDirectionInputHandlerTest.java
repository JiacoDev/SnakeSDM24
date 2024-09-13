package com.sdm;

import com.sdm.snake.Direction;
import com.sdm.snake.Snake;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SnakeDirectionInputHandlerTest {

    private final static int STARTING_X = 10;
    private final static int STARTING_Y = 10;
    private final static int STARTING_LENGTH = 3;

    @Test
    void testSnakeWInput() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.W, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertEquals(Direction.UP, snake.getDirection());
    }

    @Test
    void testSnakeAInput() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.A, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertEquals(Direction.LEFT, snake.getDirection());
    }

    @Test
    void testSnakeDInput() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.D, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertEquals(Direction.RIGHT, snake.getDirection());
    }

    @Test
    void testSnakeSInput() {
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        SnakeDirectionInputHandler inputHandler = new SnakeDirectionInputHandler(snake);
        KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.S, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertNotEquals(Direction.DOWN, snake.getDirection());

        snake.setDirection(Direction.LEFT);
        snake.move();
        keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.S, false, false, false, false);
        inputHandler.handle(keyEvent);
        Assertions.assertNotEquals(Direction.UP, snake.getDirection());
    }
}