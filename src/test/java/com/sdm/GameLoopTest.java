package com.sdm;

import com.sdm.logic.GameLoop;
import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Position;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;
import com.sdm.model.snake.movement.MovementDownState;
import com.sdm.model.snake.movement.MovementLeftState;
import com.sdm.model.snake.movement.MovementRightState;
import com.sdm.model.snake.movement.MovementUpState;
import com.sdm.view.Renderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
    RendererSpy rendererSpy;

    @BeforeEach
    void setUp() {
        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        snake = new Snake(new Position(STARTING_X, STARTING_Y), new MovementUpState(), STARTING_LENGTH);
        fruit = new Fruit(new Position(FRUIT_STARTING_X, FRUIT_STARTING_Y));
        score = new Score();

        //rendererMock = Mockito.mock(GameRenderer.class);
        rendererSpy = new RendererSpy();

        gameLoop = new GameLoop(snake, board, fruit, rendererSpy);

        //Mockito.doNothing().when(rendererMock).draw(snake, fruit, board, score);
        //Mockito.doNothing().when(rendererMock).drawGameOver(score);

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
        fruit.setPosition(new Position(STARTING_X,STARTING_Y));
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

    @Test
    void testGameLoopDraw() {
        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertFalse(rendererSpy.didDraw);
        gameLoop.handle(1000000000);
        Assertions.assertTrue(rendererSpy.didDraw);
    }

    @Test
    void testGameLoopGameOver() {
        snake.changeSnakeMovementState(new MovementRightState());
        snake.move();
        snake.changeSnakeMovementState(new MovementDownState());
        snake.move();
        snake.changeSnakeMovementState(new MovementLeftState());
        snake.move();

        gameLoop.handle(1L);
        gameLoop.handle(10);
        Assertions.assertFalse(rendererSpy.didGameOver);
        gameLoop.handle(1000000000);
        Assertions.assertTrue(rendererSpy.didGameOver);
    }


    private static class RendererSpy implements Renderer {

        private boolean didDraw = false;
        private boolean didGameOver = false;

        @Override
        public void draw(Snake snake, Fruit fruit, Board board, Score score) {
            didDraw = true;
        }

        @Override
        public void drawGameOver(Score score) {
            didGameOver = true;
        }
    }
}

