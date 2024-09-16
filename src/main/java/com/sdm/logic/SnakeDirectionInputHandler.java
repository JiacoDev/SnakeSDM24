package com.sdm.logic;

import com.sdm.model.snake.Snake;
import com.sdm.model.snake.movement.MovementDownState;
import com.sdm.model.snake.movement.MovementLeftState;
import com.sdm.model.snake.movement.MovementRightState;
import com.sdm.model.snake.movement.MovementUpState;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * The {@code SnakeDirectionInputHandler} class is responsible for handling keyboard input to change the direction of the snake's movement.
 * This class implements {@code EventHandler<KeyEvent>} and listens for specific key presses (W, A, S, D) to modify the snake's movement state.
 *
 * <p>This class provides a way for players to control the snake's direction during gameplay by switching between different movement states,
 * which are represented by {@code MovementUpState}, {@code MovementDownState}, {@code MovementLeftState}, and {@code MovementRightState}.</p>
 *
 * Class Overview:
 * <ul>
 *   <li>Handles keyboard inputs for controlling the snake's direction.</li>
 *   <li>Uses the {@code Snake} object's movement state to change the snake's movement based on key events.</li>
 * </ul>
 */

public class SnakeDirectionInputHandler implements EventHandler<KeyEvent> {
    private final Snake snake;

    /**
     * Constructs a new {@code SnakeDirectionInputHandler} and associates it with a {@code Snake} object.
     *
     * @param snake the {@code Snake} object to be controlled by this input handler
     */
    public SnakeDirectionInputHandler(Snake snake) {
        this.snake = snake;
    }

    /**
     * Handles keyboard events to change the direction of the snake's movement. This method listens for key presses
     * (W, A, S, D) and updates the snake's movement state accordingly:
     * <ul>
     *   <li>W - Move the snake up.</li>
     *   <li>A - Move the snake left.</li>
     *   <li>S - Move the snake down.</li>
     *   <li>D - Move the snake right.</li>
     * </ul>
     *
     * @param keyEvent the {@code KeyEvent} that represents the key pressed by the player
     */
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
