package com.sdm;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import com.sdm.snake.*;

public class SnakeDirectionInputHandler implements EventHandler<KeyEvent> {
    private final Snake snake;

    public SnakeDirectionInputHandler(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W -> snake.setDirection(Direction.UP);
            case S -> snake.setDirection(Direction.DOWN);
            case A -> snake.setDirection(Direction.LEFT);
            case D -> snake.setDirection(Direction.RIGHT);
        }
    }
}