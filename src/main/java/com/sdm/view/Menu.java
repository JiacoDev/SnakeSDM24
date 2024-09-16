package com.sdm.view;

import com.sdm.logic.GameLoop;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Menu {

    public static Pane drawMenu(GameLoop gameLoop) {

        // Creazione del titolo
        Text title = new Text("Snake Game");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Bottone per avviare il gioco
        Button playButton = createPlayButton(gameLoop);

        // Bottone per uscire dall'applicazione
        Button exitButton = new Button("Esci");
        exitButton.setStyle(getButtonStyle());
        exitButton.setOnAction(r -> handleExitButtonClick());


        // Layout per il menu
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(title, playButton, exitButton);

        // Creazione di un'immagine che funge da bordo
        ImageView borderImage = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokiaBorderV2.png")); // Percorso dell'immagine
        borderImage.setFitWidth(Dimension.getWindow_X()); // Larghezza dell'immagine
        borderImage.setFitHeight(Dimension.getWindow_Y()); // Altezza dell'immagine

        Rectangle background = new Rectangle(Dimension.getWindow_X(), Dimension.getWindow_Y(), Color.OLIVE);

        // Layout con immagine di sfondo e menu in primo piano
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background,borderImage, menuLayout); // L'immagine Ã¨ sotto, il menu sopra

        return stackPane;
    }

    private static Button createPlayButton(AnimationTimer gameLoop) {
        Button playButton = new Button("Gioca");
        playButton.setStyle(getButtonStyle());

        // Assegnazione dell'azione al click del pulsante
        playButton.setOnAction(r -> handlePlayButtonClick(gameLoop));
        return playButton;
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
}
