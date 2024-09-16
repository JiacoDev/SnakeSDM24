/**
 * The {@code SnakeGameApplicationInitializer} class serves as the entry point for the Snake game application.
 * It initializes game components, sets up the game board, snake, fruit, user interface, and starts the game loop.
 * This class extends JavaFX's {@code Application} class to create a graphical window and manage user input.
 *
 * <p>This class defines the initial conditions for the snake's position, fruit location, and the game board size.
 * It handles the setup of game rendering and input control mechanisms for the player to interact with the snake.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Initializes the game board, snake, and fruit with default starting positions.</li>
 *   <li>Sets up the game window using JavaFX and adds event listeners for player input (keyboard controls).</li>
 *   <li>Starts the game loop, rendering, and the main menu.</li>
 * </ul>
 */
package com.sdm.main;

import com.sdm.logic.FruitSpawnHandler;
import com.sdm.logic.GameLoop;
import com.sdm.logic.SnakeDirectionInputHandler;
import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Position;
import com.sdm.model.snake.Snake;
import com.sdm.model.snake.movement.MovementUpState;
import com.sdm.view.Dimension;
import com.sdm.view.GameRenderer;
import com.sdm.view.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SnakeGameApplicationInitializer extends Application {

    private static final int BOARD_WIDTH = 32;
    private static final int BOARD_HEIGHT = 32;

    private static final int SNAKE_START_X = 5;
    private static final int SNAKE_START_Y = 5;
    private static final int SNAKE_START_LENGTH = 3;

    private static final int FRUIT_START_X = 1;
    private static final int FRUIT_START_Y = 1;

    /**
     * The {@code start} method is the entry point for the JavaFX application.
     * It sets up the initial game state and user interface, and begins the game loop.
     *
     * @param stage the primary window (stage) for the JavaFX application
     */
    @Override
    public void start(Stage stage) {
        // Initialize game components
        Snake snake = initializeSnake();
        Board board = initializeBoard();
        Fruit fruit = initializeFruit(snake, board);

        // Set up the game window
        Scene scene = initializeScene(board);
        stageInitialization(stage, scene, snake);

        // Start the game loop and rendering
        GameRenderer gameRenderer = new GameRenderer(scene);
        GameLoop gameLoop = new GameLoop(snake, board, fruit, gameRenderer);
        scene.setRoot(Menu.drawMenu(gameLoop));
    }

    /**
     * Initializes the snake with its starting position and length.
     *
     * @return a new {@code Snake} instance
     */
    private Snake initializeSnake() {
        return new Snake(new Position(SNAKE_START_X, SNAKE_START_Y), new MovementUpState(), SNAKE_START_LENGTH);
    }

    /**
     * Initializes the game board with predefined width and height.
     *
     * @return a new {@code Board} instance
     */
    private Board initializeBoard() {
        return new Board(BOARD_WIDTH, BOARD_HEIGHT);
    }

    /**
     * Initializes the fruit and moves it to a random position, avoiding collision with the snake.
     *
     * @param snake the {@code Snake} instance
     * @param board the {@code Board} instance
     * @return a new {@code Fruit} instance
     */
    private Fruit initializeFruit(Snake snake, Board board) {
        Fruit fruit = new Fruit(new Position(FRUIT_START_X, FRUIT_START_Y));
        FruitSpawnHandler.randomFruitMove(snake, fruit, board);
        return fruit;
    }

    /**
     * Sets up the game scene with the appropriate window dimensions.
     *
     * @param board the {@code Board} instance
     * @return a new {@code Scene} instance
     */
    private Scene initializeScene(Board board) {
        Dimension.setDimension(board.width(), board.height());
        return new Scene(new Pane(), Dimension.getWindow_X(), Dimension.getWindow_Y());
    }

    /**
     * Configures the stage (primary window) and event handlers.
     *
     * @param stage the primary stage
     * @param scene the game scene
     * @param snake the {@code Snake} instance to bind input controls
     */
    private void stageInitialization(Stage stage, Scene scene, Snake snake) {
        stage.setTitle("SNAKE!");
        stage.setScene(scene);
        stage.setResizable(false);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new SnakeDirectionInputHandler(snake));
        stage.show();
    }

    /**
     * The {@code main} method is the main entry point for the Java application.
     * It calls the {@code launch} method, which starts the JavaFX application.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        launch();
    }
}
