package com.sdm;

import com.sdm.snake.Snake;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class SnakeGameApplicationInitializer extends Application {

    private final int snakeStartingXCoordinate = 5;
    private final int snakeStartingYCoordinate = 5;
    private final int snakeStartingLength = 3;

    private final int boardStartingWidth = 32;
    private final int boardStartingHeight = 32;

    private final int fruitStartingXCoordinate = 1;
    private final int fruitStartingYCoordinate = 1;

    @Override
    public void start(Stage stage){

        Snake startSnake = new Snake(snakeStartingXCoordinate, snakeStartingYCoordinate, snakeStartingLength);
        Board startBoard = new Board(boardStartingWidth, boardStartingHeight);
        Fruit startFruit = new Fruit(fruitStartingXCoordinate,fruitStartingYCoordinate);

        Scene scene = new Scene(new Pane(),(boardStartingWidth - 1 + Graphic.SPACEx*2)*Graphic.DIM, (boardStartingHeight - 1 + Graphic.SPACEy*2)*Graphic.DIM);
        stage.setTitle("SNAKE!");
        stage.setScene(scene);
        stage.show();

        //scene.setFill(Color.PALEGREEN);
        scene.setFill(Color.OLIVE);

        scene.addEventHandler(KeyEvent.KEY_PRESSED,  new SnakeDirectionInputHandler(startSnake));

        GameLoop gameLoop = new GameLoop(startSnake, startBoard, startFruit, scene);
        gameLoop.start();
    }

    public static void main(String[] args) {
        launch();
    }
}