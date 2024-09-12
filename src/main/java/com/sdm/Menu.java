package com.sdm;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Menu {

    public static Pane drawMenu(){
        // Creazione del titolo
        Text title = new Text("Snake Game");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Bottone per avviare il gioco
        Button playButton = new Button("Gioca");
        playButton.setStyle("-fx-font-size: 20px;");

        // Bottone per uscire dall'applicazione
        Button exitButton = new Button("Esci");
        exitButton.setStyle("-fx-font-size: 20px;");

        // Layout per il menu
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(title, playButton, exitButton);

        // Creazione di un'immagine che funge da bordo
        ImageView borderImage = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokia 3310 border image.png")); // Percorso dell'immagine
        borderImage.setFitWidth(1000); // Larghezza dell'immagine
        borderImage.setFitHeight(1000); // Altezza dell'immagine
        borderImage.setPreserveRatio(true); // Mantiene le proporzioni

        // Layout con immagine di sfondo e menu in primo piano
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(borderImage, menuLayout); // L'immagine è sotto, il menu sopra
        StackPane.setAlignment(borderImage, Pos.CENTER); // Centrare l'immagine
        StackPane.setAlignment(menuLayout, Pos.CENTER); // Centrare il menu

        return stackPane;
    }
}
