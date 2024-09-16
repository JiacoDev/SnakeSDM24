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

        // Scrive Game Over
        Text title = new Text("GAME OVER");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Riporta il punteggio finale
        Text scoreText = new Text("Score: " + score.getScore());
        scoreText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button returnButton = new Button("Exit");
        returnButton.setStyle(getButtonStyle());
        returnButton.setOnAction(_ -> Platform.exit());

        // Layout per il menu
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(title, scoreText, returnButton);

        StackPane stackPane = Nokia3310.drawNokia3310();
        stackPane.getChildren().add(menuLayout);

        return stackPane;
    }

    private static String getButtonStyle() {
        return "-fx-font-size: 20px; -fx-background-color: #808000; -fx-text-fill: black; -fx-font-weight: bold;";
    }
}