package com.sdm.view;

import com.sdm.model.Score;
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

        // Creazione di un'immagine che funge da bordo
        ImageView borderImage = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokiaBorderV2.png")); // Percorso dell'immagine
        borderImage.setFitWidth(Dimension.getWindow_X()); // Larghezza dell'immagine
        borderImage.setFitHeight(Dimension.getWindow_Y()); // Altezza dell'immagine

        Rectangle background = new Rectangle(Dimension.getWindow_X(), Dimension.getWindow_Y(), Color.OLIVE);

        // Layout con immagine di sfondo e menu in primo piano
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background,borderImage, menuLayout);

        return stackPane;
    }

    private static String getButtonStyle() {
        return "-fx-font-size: 20px; -fx-background-color: #808000; -fx-text-fill: black; -fx-font-weight: bold;";
    }
}