package com.sdm;

import com.sdm.snake.Snake;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;

public class GameLoop extends AnimationTimer {

    private final int GAME_SPEED = 10;

    private Snake snake;
    private Board board;
    private Fruit fruit;
    private Scene scene;
    private Score score = new Score();
    private long lastUpdateTime = 0;
    private double totalGameTime = 0;

    public GameLoop(Snake initSnake, Board initBoard, Fruit initFruit, Scene initScene) {
        snake = initSnake;
        board = initBoard;
        fruit = initFruit;
        scene = initScene;
    }

    @Override
    public void handle(long now) {
        if (lastUpdateTime > 0) {
            double deltaTime = (now - lastUpdateTime) / 1_000_000_000.0;
            totalGameTime += deltaTime * GAME_SPEED;
            if (totalGameTime >= 1.0) {
                updateGame();
                //Draw func
                scene.setRoot(Graphic.draw(snake, fruit, board, score));
                totalGameTime -= 1;
            }
        }
        lastUpdateTime = now;
    }

    private void updateGame() {
        switch (CollisionHandler.checkCollision(snake, fruit, board)) {
            case NORMAL -> snake.move();
            case EAT -> {
                snake.grow();
                score.addToScore(1);
                FruitSpawnHandler.randomFruitMove(snake, fruit, board);

            }
            case SNAKE_COLLISION -> Platform.exit();
            case WALL_COLLISION -> Platform.exit();
        }
        //drawGameOnCLI();
    }

    //Funzione temporanea fino a quando non c'è l'interfaccia grafica
    public void drawGameOnCLI() {
    // Cornice superiore
        System.out.print("\n\n\n\n\n");
        System.out.println("  " + "-".repeat(board.width() + 2));  // Stampa la linea superiore con una cornice di larghezza maggiore

    for (int j = board.height() - 1; j > 0; j--) {
        System.out.print(" |");  // Aggiungi il bordo laterale sinistro
        for (int i = 1; i < board.width(); i++) {
            // Stampa la testa dello snake
            if (snake.getHeadXCoordinate() == i && snake.getHeadYCoordinate() == j) {
                System.out.print("X");
                continue;  // Evita di stampare altro per la cella della testa
            }

            // Stampa il corpo dello snake
            boolean isSnakeBody = false;
            for (int k = 1; k < snake.getSize(); k++) {
                int elementX = snake.getTailXCoordinate(k);
                int elementY = snake.getTailYCoordinate(k);
                if (elementX == i && elementY == j) {
                    System.out.print("O");
                    isSnakeBody = true;
                    break;
                }
            }
            if (isSnakeBody) continue;  // Evita di stampare altro per la cella del corpo

            // Stampa il frutto
            if (fruit.getPosX() == i && fruit.getPosY() == j) {
                System.out.print("*");
            }
            // Spazio vuoto
            else {
                System.out.print(".");
            }
        }
        System.out.println("|");  // Aggiungi il bordo laterale destro e vai a capo
    }

    // Cornice inferiore
    System.out.println("  " + "-".repeat(board.width() + 2));  // Stampa la linea inferiore
    }
}