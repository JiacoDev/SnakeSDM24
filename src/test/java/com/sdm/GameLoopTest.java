package com.sdm;

import com.sdm.snake.Direction;
import com.sdm.snake.Snake;
import javafx.scene.Scene;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class GameLoopTest {

    private final static int STARTING_X = 5;
    private final static int STARTING_Y = 5;
    private final static int STARTING_LENGTH = 3;
    private final static int BOARD_WIDTH = 10;
    private final static int BOARD_HEIGHT = 10;
    private final static int FRUIT_STARTING_X = 0;
    private final static int FRUIT_STARTING_Y = 0;

    @Test
    void testGameLoop() {
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(FRUIT_STARTING_X, FRUIT_STARTING_Y);

        Scene mockScene = Mockito.mock(Scene.class);

        GameLoop gameLoop = new GameLoop(snake,board,fruit,mockScene);
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertNotEquals(STARTING_Y+1,snake.getHeadYCoordinate());
        gameLoop.handle(1000000000);
        Assertions.assertEquals(STARTING_Y+1,snake.getHeadYCoordinate());
    }

    @Test
    void testGameLoopEat() {
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(STARTING_X, STARTING_Y);

        Scene mockScene = Mockito.mock(Scene.class);

        GameLoop gameLoop = new GameLoop(snake,board,fruit,mockScene);
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertNotEquals(STARTING_LENGTH+1,snake.getSize());
        gameLoop.handle(1000000000);
        Assertions.assertEquals(STARTING_LENGTH+1,snake.getSize());
    }

    @Test
    void testGameLoopWallCollision() {
        Board board = new Board(BOARD_WIDTH, STARTING_Y);
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(FRUIT_STARTING_X, FRUIT_STARTING_Y);

        Scene mockScene = Mockito.mock(Scene.class);

        GameLoop gameLoop = new GameLoop(snake,board,fruit,mockScene);
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertNotEquals(STARTING_Y+1,snake.getHeadYCoordinate());
        gameLoop.handle(1000000000);
        Assertions.assertNotEquals(STARTING_Y+1,snake.getHeadYCoordinate());
    }

    @Test
    void testGameLoopSnakeCollision() {
        Board board = new Board(BOARD_WIDTH, STARTING_Y);
        Snake snake = new Snake(STARTING_X, STARTING_Y, 5);
        Fruit fruit = new Fruit(FRUIT_STARTING_X, FRUIT_STARTING_Y);

        Scene mockScene = Mockito.mock(Scene.class);

        snake.setDirection(Direction.RIGHT);
        snake.move();
        snake.setDirection(Direction.DOWN);
        snake.move();
        snake.setDirection(Direction.LEFT);
        snake.move();

        GameLoop gameLoop = new GameLoop(snake,board,fruit,mockScene);
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertNotEquals(STARTING_X-1,snake.getHeadXCoordinate());
        gameLoop.handle(1000000000);
        Assertions.assertNotEquals(STARTING_X-1,snake.getHeadXCoordinate());
    }
}