package com.sdm;

import com.sdm.snake.Direction;
import com.sdm.snake.Snake;
import com.sdm.snake.movement.MovementDownState;
import com.sdm.snake.movement.MovementLeftState;
import com.sdm.snake.movement.MovementRightState;
import com.sdm.snake.movement.MovementUpState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


class GameLoopTest {

    private final static int STARTING_X = 5;
    private final static int STARTING_Y = 5;
    private final static int STARTING_LENGTH = 5;
    private final static int BOARD_WIDTH = 10;
    private final static int BOARD_HEIGHT = 10;
    private final static int FRUIT_STARTING_X = 0;
    private final static int FRUIT_STARTING_Y = 0;

    Board board;
    Snake snake;
    Fruit fruit;
    Score score;
    GameLoop gameLoop;

    @Mock
    DrawHandler drawHandlerMock;

    @BeforeEach
    void setUp() {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        snake = new Snake(new Position(STARTING_X, STARTING_Y), new MovementUpState(), STARTING_LENGTH);
        fruit = new Fruit(FRUIT_STARTING_X, FRUIT_STARTING_Y);
        score = new Score();

        drawHandlerMock = Mockito.mock(DrawHandler.class);

        gameLoop = new GameLoop(snake, board, fruit, drawHandlerMock);

        Mockito.doNothing().when(drawHandlerMock).draw(snake, fruit, board, score);
        Mockito.doNothing().when(drawHandlerMock).drawGameOver(score, gameLoop);

    }

    @Test
    void testGameLoop() {
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertNotEquals(STARTING_Y + 1, snake.getBodySegment(0).getY());
        gameLoop.handle(1000000000);
        Assertions.assertEquals(STARTING_Y + 1, snake.getBodySegment(0).getY());
    }

    @Test
    void testGameLoopEat() {
        fruit.setPosX(STARTING_X);
        fruit.setPosY(STARTING_Y);
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertNotEquals(STARTING_LENGTH + 1, snake.getSize());
        gameLoop.handle(1000000000);
        Assertions.assertEquals(STARTING_LENGTH + 1, snake.getSize());
    }

    @Test
    void testGameLoopWallCollision() {
        while (snake.getBodySegment(0).getY() < BOARD_HEIGHT) snake.move();
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertEquals(BOARD_HEIGHT, snake.getBodySegment(0).getY());
        gameLoop.handle(1000000000);
        Assertions.assertNotEquals(BOARD_HEIGHT + 1, snake.getBodySegment(0).getY());
    }

    @Test
    void testGameLoopSnakeCollision() {
        snake.changeSnakeMovementState(new MovementRightState());
        snake.move();
        snake.changeSnakeMovementState(new MovementDownState());
        snake.move();
        snake.changeSnakeMovementState(new MovementLeftState());
        snake.move();

        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertNotEquals(STARTING_X - 1, snake.getBodySegment(0).getX());
        gameLoop.handle(1000000000);
        Assertions.assertNotEquals(STARTING_X - 1, snake.getBodySegment(0).getX());
    }
}