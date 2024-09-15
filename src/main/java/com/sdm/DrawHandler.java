package com.sdm;

import com.sdm.snake.Snake;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawHandler {

    private final Scene scene;
    private final Stage stage;

    public DrawHandler(Stage stage, Scene scene) {
        this.scene = scene;
        this.stage = stage;
    }

    public void draw(Snake snake, Fruit fruit, Board board, Score score) {
        scene.setRoot(Graphic.draw(snake, fruit, board, score));
    }

    public void drawGameOver(Score score, GameLoop gameLoop) {// Stop the game loop
        GameOver gameOver = new GameOver(score.getScore());
        Platform.runLater(() -> stage.setScene(gameOver.createGameOverScene(stage, gameLoop)));
    }
}
