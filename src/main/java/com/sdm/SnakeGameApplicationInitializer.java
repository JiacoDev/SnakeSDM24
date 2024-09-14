package com.sdm;

import com.sdm.snake.Snake;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class SnakeGameApplicationInitializer extends Application {

    private final int snakeStartingXCoordinate = 5;
    private final int snakeStartingYCoordinate = 5;
    private final int snakeStartingLength = 3;
    private final int fruitStartingXCoordinate = 1;
    private final int fruitStartingYCoordinate = 1;

    @Override
    public void start(Stage stage){

        Dimension dim = new Dimension();

        Snake startSnake = new Snake(snakeStartingXCoordinate, snakeStartingYCoordinate, snakeStartingLength);
        Board startBoard = new Board(dim.getBoardStartingWidth(), dim.getBoardStartingHeight());
        Fruit startFruit = new Fruit(fruitStartingXCoordinate,fruitStartingYCoordinate);

        Scene scene = new Scene(new Pane(), dim.getWindow_X(), dim.getWindow_Y());
        stage.setTitle("SNAKE!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        //scene.setFill(Color.PALEGREEN);
        scene.setFill(Color.OLIVE);

        scene.addEventHandler(KeyEvent.KEY_PRESSED,  new SnakeDirectionInputHandler(startSnake));

        GameLoop gameLoop = new GameLoop(startSnake, startBoard, startFruit, scene);
        scene.setRoot(Menu.drawMenu(gameLoop));
        //gameLoop.start();
    }

    public static void main(String[] args) {
        launch();
    }
}