package com.sdm.main;

import com.sdm.logic.FruitSpawnHandler;
import com.sdm.logic.GameLoop;
import com.sdm.logic.SnakeDirectionInputHandler;
import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Position;
import com.sdm.model.snake.Snake;
import com.sdm.model.snake.movement.MovementUpState;
import com.sdm.view.Dimension;
import com.sdm.view.GameRenderer;
import com.sdm.view.Menu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class SnakeGameApplicationInitializer extends Application {
    @Override
    public void start(Stage stage){

        final int snakeStartingXCoordinate = 5;
        final int snakeStartingYCoordinate = 5;
        final int snakeStartingLength = 3;
        final int fruitStartingXCoordinate = 1;
        final int fruitStartingYCoordinate = 1;

        Snake startSnake = new Snake(new Position(snakeStartingXCoordinate,snakeStartingYCoordinate), new MovementUpState(), snakeStartingLength);
        Board startBoard = new Board(32, 32);
        Fruit startFruit = new Fruit(new Position(fruitStartingXCoordinate,fruitStartingYCoordinate));
        FruitSpawnHandler.randomFruitMove(startSnake, startFruit, startBoard);

        Dimension.setDimension(startBoard.width(), startBoard.height());

        Scene scene = new Scene(new Pane(), Dimension.getWindow_X(), Dimension.getWindow_Y());
        stage.setTitle("SNAKE!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED,  new SnakeDirectionInputHandler(startSnake));
        GameRenderer gameRenderer = new GameRenderer(scene);
        GameLoop gameLoop = new GameLoop(startSnake, startBoard, startFruit, gameRenderer);
        scene.setRoot(Menu.drawMenu(gameLoop));
    }

    public static void main(String[] args) {
        launch();
    }
}