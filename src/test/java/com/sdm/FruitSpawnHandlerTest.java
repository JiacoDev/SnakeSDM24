package com.sdm;

import com.sdm.snake.Snake;
import com.sdm.snake.movement.MovementUpState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

class FruitSpawnHandlerTest {

    private final static int STARTING_X = 5;
    private final static int STARTING_Y = 5;
    private final static int STARTING_LENGTH = 3;
    private final static int BOARD_WIDTH = 10;
    private final static int BOARD_HEIGHT = 10;
    private final static int FRUIT_STARTING_X = 0;
    private final static int FRUIT_STARTING_Y = 0;
    private Snake snake;
    private Board board;
    private Fruit fruit;
    @BeforeEach
    void setUp() {
        snake = new Snake(new Position(STARTING_X, STARTING_Y), new MovementUpState(),STARTING_LENGTH);
        board = new Board(BOARD_WIDTH,BOARD_HEIGHT);
        fruit = new Fruit(0,0);
    }

    @Test
    void checkThatFruitDoesNotMoveOnSnake() {
        //Creo un mock di Random
        Random randomMock = Mockito.spy(new Random(System.currentTimeMillis()));
        Mockito.doReturn(STARTING_X).doReturn(STARTING_Y).doReturn(8).doReturn(8).when(randomMock).nextInt(1, board.width());  // 11 perché è `board.getWidth() + 1` e `board.getHeight() + 1`
        FruitSpawnHandler.setRandom(randomMock);

        FruitSpawnHandler.randomFruitMove(snake, fruit, board);

        // Verifico che il frutto non sia nella coda del serpente
        for (int j = 0; j < snake.getSize(); j++) {
            Assertions.assertNotEquals(snake.getBodySegment(j), fruit.getPosX());
            Assertions.assertNotEquals(snake.getBodySegment(j), fruit.getPosY());
        }

        // Verifico che il frutto sia nella nuova posizione (8,8)
        Assertions.assertEquals(8, fruit.getPosX());
        Assertions.assertEquals(8, fruit.getPosY());
    }

}