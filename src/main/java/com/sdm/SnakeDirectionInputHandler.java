package com.sdm;

import com.sdm.snake.movement.MovementDownState;
import com.sdm.snake.movement.MovementLeftState;
import com.sdm.snake.movement.MovementRightState;
import com.sdm.snake.movement.MovementUpState;
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
            case W -> snake.changeSnakeMovementState(new MovementUpState());
            case S -> snake.changeSnakeMovementState(new MovementDownState());
            case A -> snake.changeSnakeMovementState(new MovementLeftState());
            case D -> snake.changeSnakeMovementState(new MovementRightState());
        }
    }
}