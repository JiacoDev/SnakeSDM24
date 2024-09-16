package com.sdm.view;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;
import javafx.scene.Scene;

public class GameRenderer implements Renderer {

    private final Scene scene;

    public GameRenderer(Scene scene) {
        this.scene = scene;
    }

    public void draw(Snake snake, Fruit fruit, Board board, Score score) {
        scene.setRoot(Graphic.draw(snake, fruit, board, score));
    }

    public void drawGameOver(Score score) {
        scene.setRoot(GameOver.createGameOverScene(score));
    }
}