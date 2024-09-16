/**
 * The {@code GameOver} class provides functionality to create and display a game over scene.
 * This scene includes a message indicating the game has ended, the final score, and an exit button.
 *
 * <p>The class uses a Nokia 3310 frame as the background for the game over screen, giving the interface
 * a retro appearance. The game over scene is created with a message, score display, and an option to exit the game.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Creates and returns a {@code StackPane} with the game over scene.</li>
 *   <li>Includes a message, final score display, and an exit button.</li>
 * </ul>
 */
package com.sdm.view;

import com.sdm.model.Score;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GameOver {

    /**
     * Creates and returns a {@code StackPane} that displays the game over scene.
     *
     * <p>The game over scene includes a message indicating the game has ended, the final score,
     * and an exit button. The scene is displayed within a Nokia 3310 frame.</p>
     *
     * @param score the final score of the game to be displayed
     * @return a {@code StackPane} containing the game over scene
     */
    public static Pane createGameOverScene(Score score) {
        StackPane stackPane = Nokia3310.drawNokia3310();
        stackPane.getChildren().add(gameOverAssemble(score));
        return stackPane;
    }

    /**
     * Creates a {@code Text} object displaying the "GAME OVER" message.
     *
     * @return a {@code Text} object with the game over message styled appropriately
     */
    private static Text getGameOverMessage() {
        Text gameOverMessage = new Text("GAME OVER");
        gameOverMessage.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        return gameOverMessage;
    }

    /**
     * Creates a {@code Text} object displaying the final score.
     *
     * @param score the final score of the game to be displayed
     * @return a {@code Text} object with the final score styled appropriately
     */
    private static Text getScoreMessage(Score score) {
        Text scoreMessage = new Text("Score: " + score.getScore());
        scoreMessage.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        return scoreMessage;
    }

    /**
     * Retrieves the style string for buttons in the game over scene.
     *
     * @return a {@code String} representing the button style
     */
    private static String getButtonStyle() {
        return "-fx-font-size: 20px; -fx-background-color: #808000; -fx-text-fill: black; -fx-font-weight: bold;";
    }

    /**
     * Creates a {@code Button} object for exiting the game.
     *
     * @return a {@code Button} labeled "Esci" with the exit button style
     */
    private static Button drawExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.setStyle(getButtonStyle());
        exitButton.setOnAction(r -> handleExitButtonClick());
        return exitButton;
    }

    /**
     * Handles the action of clicking the exit button by terminating the application.
     */
    private static void handleExitButtonClick() {
        Platform.exit();
    }

    /**
     * Assembles the game over scene layout with the game over message, score display, and exit button.
     *
     * @param score the final score of the game to be displayed
     * @return a {@code VBox} layout containing the game over scene components
     */
    private static VBox gameOverAssemble(Score score) {
        VBox gameOverLayout = new VBox(20);
        gameOverLayout.setAlignment(Pos.CENTER);
        gameOverLayout.getChildren().addAll(getGameOverMessage(), getScoreMessage(score), drawExitButton());
        return gameOverLayout;
    }
}
