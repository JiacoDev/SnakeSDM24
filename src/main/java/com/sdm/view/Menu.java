package com.sdm.view;

import com.sdm.logic.GameLoop;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * The {@code Menu} class provides methods to create and manage the main menu of the game.
 * It includes options to start the game and exit the application.
 *
 * <p>This class sets up a user interface menu displayed on the screen, allowing the player to either start the game or exit the application.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Creates and returns the main menu pane.</li>
 *   <li>Includes buttons for starting the game and exiting the application.</li>
 *   <li>Handles button actions to start the game loop or exit the application.</li>
 * </ul>
 */

public class Menu {

    /**
     * Creates and returns the main menu pane for the game.
     *
     * <p>This method creates a {@code StackPane} containing the menu layout, which includes buttons for starting the game and exiting the application.</p>
     *
     * @param gameLoop the {@code GameLoop} object used to start the game
     * @return a {@code StackPane} containing the menu layout
     */
    public static Pane drawMenu(GameLoop gameLoop) {
        StackPane stackPane = Nokia3310.drawNokia3310();
        stackPane.getChildren().add(menuAssemble(gameLoop));
        return stackPane;
    }

    /**
     * Creates a button to start the game.
     *
     * <p>This method creates a {@code Button} labeled "Gioca" (Play), sets its style, and assigns an action to start the game loop when clicked.</p>
     *
     * @param gameLoop the {@code AnimationTimer} to start the game loop
     * @return a {@code Button} for starting the game
     */
    private static Button drawPlayButton(AnimationTimer gameLoop) {
        Button playButton = new Button("Play");
        playButton.setStyle(getButtonStyle());
        playButton.setOnAction(r -> handlePlayButtonClick(gameLoop));
        return playButton;
    }

    /**
     * Creates a button to exit the application.
     *
     * <p>This method creates a {@code Button} labeled "Esci" (Exit), sets its style, and assigns an action to exit the application when clicked.</p>
     *
     * @return a {@code Button} for exiting the application
     */
    private static Button drawExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.setStyle(getButtonStyle());
        exitButton.setOnAction(r -> handleExitButtonClick());
        return exitButton;
    }

    /**
     * Handles the action when the play button is clicked.
     *
     * <p>This method starts the game loop when the play button is clicked.</p>
     *
     * @param gameLoop the {@code AnimationTimer} to start the game loop
     */
    private static void handlePlayButtonClick(AnimationTimer gameLoop) {
        gameLoop.start();
    }

    /**
     * Returns the style for the buttons used in the menu.
     *
     * <p>This method provides a string representing the CSS style for the buttons, including font size, background color, text color, and font weight.</p>
     *
     * @return a {@code String} representing the button style
     */
    private static String getButtonStyle() {
        return "-fx-font-size: 20px; -fx-background-color: #808000; -fx-text-fill: black; -fx-font-weight: bold;";
    }

    /**
     * Handles the action when the exit button is clicked.
     *
     * <p>This method exits the application when the exit button is clicked.</p>
     */
    private static void handleExitButtonClick() {
        Platform.exit();
    }

    /**
     * Creates and returns the title text for the menu.
     *
     * <p>This method creates a {@code Text} object labeled "Snake Game", sets its font size and weight, and returns it.</p>
     *
     * @return a {@code Text} object representing the title
     */
    private static Text drawTitle() {
        Text title = new Text("Snake Game");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        return title;
    }

    /**
     * Assembles and returns the menu layout.
     *
     * <p>This method creates a {@code VBox} layout containing the title text, the play button, and the exit button. It sets the alignment and spacing for the layout.</p>
     *
     * @param gameLoop the {@code GameLoop} object used to start the game
     * @return a {@code VBox} containing the menu elements
     */
    private static VBox menuAssemble(GameLoop gameLoop) {
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().add(drawTitle());
        menuLayout.getChildren().add(drawPlayButton(gameLoop));
        menuLayout.getChildren().add(drawExitButton());
        return menuLayout;
    }
}
