package com.sdm;

import com.sdm.snake.Snake;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Snake startSnake = new Snake(1,1,1);
        Board startBoard = new Board(64,64);
        Fruit startFruit = new Fruit(0,0);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED,  new KeyboardPressHandler(startSnake));

        GameLoop gameLoop = new GameLoop(startSnake, startBoard, startFruit);
        gameLoop.start();
    }

    public static void main(String[] args) {
        launch();
    }
}