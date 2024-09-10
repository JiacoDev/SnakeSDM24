package com.sdm;

import com.sdm.snake.Snake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FruitSpawnHandlerTest {

    private final static int STARTING_X = 20;
    private final static int STARTING_Y = 20;
    private final static int STARTING_LENGTH = 15;
    private final static int BOARD_WIDTH = 32;
    private final static int BOARD_HEIGHT = 32;

    //this test is temporary it needs to be updated
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15})
    void checkThatFruitDoesNotMoveOnSnake(int fruitStartingPosition) {
        Board board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        Snake snake = new Snake(STARTING_X, STARTING_Y, STARTING_LENGTH);
        Fruit fruit = new Fruit(fruitStartingPosition,fruitStartingPosition);
        for (int i = 0; i < 10000; i++) {
            FruitSpawnHandler.randomFruitMove(snake,fruit,board);
            for (int j = 0; j < STARTING_LENGTH; j++) {
                if(snake.getTailXCoordinate(j) == fruit.getPosX() && snake.getTailYCoordinate(j) == fruit.getPosY())
                    Assertions.fail("SnakeX: " + snake.getTailXCoordinate(j) + " SnakeY: " + snake.getTailYCoordinate(j) + "\nFruitX: " + fruit.getPosX() + " FruitY: " + fruit.getPosY());
            }
        }
    }
}