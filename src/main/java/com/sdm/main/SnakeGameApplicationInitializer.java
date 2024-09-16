package com.sdm.main;

import com.sdm.logic.GameLoop;
import com.sdm.logic.SnakeDirectionInputHandler;
import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Position;
import com.sdm.model.snake.Snake;
import com.sdm.model.snake.movement.MovementUpState;
import com.sdm.view.Dimension;
import com.sdm.view.DrawHandler;
import com.sdm.view.Menu;
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

        Snake startSnake = new Snake(new Position(snakeStartingXCoordinate,snakeStartingYCoordinate), new MovementUpState(), snakeStartingLength);
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
        DrawHandler drawHandler = new DrawHandler(stage, scene);
        GameLoop gameLoop = new GameLoop(startSnake, startBoard, startFruit, drawHandler);
        scene.setRoot(Menu.drawMenu(gameLoop));
        //gameLoop.start();
    }

    public static void main(String[] args) {
        launch();
    }
}