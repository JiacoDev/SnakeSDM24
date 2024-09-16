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

public class Menu {

    public static Pane drawMenu(GameLoop gameLoop) {

        StackPane stackPane = Nokia3310.drawNokia3310();

        stackPane.getChildren().add(menuAssemble(gameLoop)); // L'immagine Ã¨ sotto, il menu sopra

        return stackPane;
    }

    private static Button drawPlayButton(AnimationTimer gameLoop) {
        Button playButton = new Button("Gioca");
        playButton.setStyle(getButtonStyle());

        // Assegnazione dell'azione al click del pulsante
        playButton.setOnAction(r -> handlePlayButtonClick(gameLoop));
        return playButton;
    }
    private static Button drawExitButton() {
        Button exitButton = new Button("Esci");
        exitButton.setStyle(getButtonStyle());
        exitButton.setOnAction(r -> handleExitButtonClick());
        return exitButton;
    }

    // Metodo per gestire l'azione del pulsante
    private static void handlePlayButtonClick(AnimationTimer gameLoop) {
        gameLoop.start();
    }

    // Metodo per restituire lo stile del pulsante
    private static String getButtonStyle() {
        return "-fx-font-size: 20px; -fx-background-color: #808000; -fx-text-fill: black; -fx-font-weight: bold;";
    }
    private static void handleExitButtonClick() {
        Platform.exit();
    }
    private static Text drawTitle(){
        Text title = new Text("Snake Game");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");
        return title;
    }
    private static VBox menuAssemble(GameLoop gameLoop){
        // Layout per il menu
        VBox menuLayout = new VBox(20);

        menuLayout.setAlignment(Pos.CENTER);

        menuLayout.getChildren().add(drawTitle());
        menuLayout.getChildren().add(drawPlayButton(gameLoop));
        menuLayout.getChildren().add(drawExitButton());

        return menuLayout;
    }
}
