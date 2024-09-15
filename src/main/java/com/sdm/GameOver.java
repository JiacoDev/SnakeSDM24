package com.sdm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOver {

    private final int finalScore;

    public GameOver(int score) {
        this.finalScore = score;
    }

    public Scene createGameOverScene(Stage stage, GameLoop gameLoop) {

        Dimension dimension = new Dimension();

        // Scrive Game Over
        Text title = new Text("GAME OVER");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold;");

        // Riporta il punteggio finale
        Text scoreText = new Text("Score: " + finalScore);
        scoreText.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button returnButton = new Button("Return to Menu");
        returnButton.setStyle(getButtonStyle());
        returnButton.setOnAction(e -> stage.setScene(new Scene(Menu.drawMenu(gameLoop))));

        // Layout per il menu
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.getChildren().addAll(title, scoreText, returnButton);

        // Creazione di un'immagine che funge da bordo
        ImageView borderImage = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokiaBorderV2.png")); // Percorso dell'immagine
        borderImage.setFitWidth(dimension.getWindow_X()); // Larghezza dell'immagine
        borderImage.setFitHeight(dimension.getWindow_Y()); // Altezza dell'immagine

        Rectangle background = new Rectangle(dimension.getWindow_X(), dimension.getWindow_Y(), Color.OLIVE);

        // Layout con immagine di sfondo e menu in primo piano
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background,borderImage, menuLayout); // L'immagine Ã¨ sotto, il menu sopra



        return new Scene(stackPane, dimension.getWindow_X(), dimension.getWindow_Y());
    }

    private static String getButtonStyle() {
        return "-fx-font-size: 20px; -fx-background-color: #808000; -fx-text-fill: black; -fx-font-weight: bold;";
    }
}