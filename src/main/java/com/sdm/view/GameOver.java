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

    public static Pane createGameOverScene(Score score) {

        StackPane stackPane = Nokia3310.drawNokia3310();
        stackPane.getChildren().add(gameOverAssemble(score));

        return stackPane;
    }

    private static Text getGameOverMessage() {
        Text gameOverMessage = new Text("GAME OVER");
        gameOverMessage.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        return gameOverMessage;
    }

    private static Text getScoreMessage(Score score) {
        // Riporta il punteggio finale
        Text scoreMessage = new Text("Score: " + score.getScore());
        scoreMessage.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        return scoreMessage;
    }

    private static String getButtonStyle() {
        return "-fx-font-size: 20px; -fx-background-color: #808000; -fx-text-fill: black; -fx-font-weight: bold;";
    }

    private static Button drawExitButton() {
        Button exitButton = new Button("Esci");
        exitButton.setStyle(getButtonStyle());
        exitButton.setOnAction(r -> handleExitButtonClick());
        return exitButton;
    }

    private static void handleExitButtonClick() {
        Platform.exit();
    }

    private static VBox gameOverAssemble(Score score) {
        VBox gameOverLayout = new VBox(20);
        gameOverLayout.setAlignment(Pos.CENTER);
        gameOverLayout.getChildren().addAll(getGameOverMessage(), getScoreMessage(score), drawExitButton());
        return gameOverLayout;
    }
}