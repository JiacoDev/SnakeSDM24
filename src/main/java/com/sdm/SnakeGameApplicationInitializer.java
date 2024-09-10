package com.sdm;

import com.sdm.snake.Snake;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class SnakeGameApplicationInitializer extends Application {

    private final int snakeStartingXCoordinate = 5;
    private final int snakeStartingYCoordinate = 5;
    private final int snakeStartingLength = 3;

    private final int boardStartingWidth = 10;
    private final int boardStartingHeight = 10;

    private final int fruitStartingXCoordinate = 1;
    private final int fruitStartingYCoordinate = 1;

    @Override
    public void start(Stage stage) throws IOException {

        Snake startSnake = new Snake(snakeStartingXCoordinate, snakeStartingYCoordinate, snakeStartingLength);
        Board startBoard = new Board(boardStartingWidth, boardStartingHeight);
        Fruit startFruit = new Fruit(fruitStartingXCoordinate,fruitStartingYCoordinate);

        FXMLLoader fxmlLoader = new FXMLLoader(SnakeGameApplicationInitializer.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED,  new SnakeDirectionInputHandler(startSnake));

        GameLoop gameLoop = new GameLoop(startSnake, startBoard, startFruit);
        gameLoop.start();
    }

    public static void main(String[] args) {
        launch();
    }
}