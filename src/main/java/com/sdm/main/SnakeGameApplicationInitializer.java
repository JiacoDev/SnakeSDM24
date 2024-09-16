/**
 * The {@code SnakeGameApplicationInitializer} class serves as the entry point for the Snake game application.
 * It initializes the game components, sets up the game board, snake, fruit, and the user interface, and starts
 * the game loop. This class extends JavaFX's {@code Application} class to create a graphical window and manage
 * user input.
 *
 * <p>The class defines the initial conditions for the snake's position, fruit location, and the game board's size.
 * It also handles the setup of the game rendering and input control mechanisms for the player to interact with the snake.</p>
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

    /**
     * The {@code start} method is the entry point for the JavaFX application.
     * It sets up the initial game state and the user interface, and begins the game loop.
     *
     * <p>This method initializes the snake, board, and fruit, setting their default starting positions.
     * It also creates the game window and binds the player's input (keyboard controls) to snake movement.</p>
     *
     * @param stage the primary window (stage) for the JavaFX application
     */
    @Override
    public void start(Stage stage){


        final int snakeStartingXCoordinate = 5;
        final int snakeStartingYCoordinate = 5;
        final int snakeStartingLength = 3;
        final int fruitStartingXCoordinate = 1;
        final int fruitStartingYCoordinate = 1;


        Snake startSnake = new Snake(new Position(snakeStartingXCoordinate, snakeStartingYCoordinate), new MovementUpState(), snakeStartingLength);
        Board startBoard = new Board(32, 32);
        Fruit startFruit = new Fruit(new Position(fruitStartingXCoordinate, fruitStartingYCoordinate));
        FruitSpawnHandler.randomFruitMove(startSnake, startFruit, startBoard);
        Dimension.setDimension(startBoard.width(), startBoard.height());
        Scene scene = new Scene(new Pane(), Dimension.getWindow_X(), Dimension.getWindow_Y());
        stage.setTitle("SNAKE!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, new SnakeDirectionInputHandler(startSnake));
        GameRenderer gameRenderer = new GameRenderer(scene);
        GameLoop gameLoop = new GameLoop(startSnake, startBoard, startFruit, gameRenderer);
        scene.setRoot(Menu.drawMenu(gameLoop));
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
