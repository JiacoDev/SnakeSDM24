package com.sdm;

import com.sdm.logic.CollisionHandler;
import com.sdm.logic.GameState;
import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Position;
import com.sdm.model.snake.Snake;
import com.sdm.model.snake.movement.MovementDownState;
import com.sdm.model.snake.movement.MovementLeftState;
import com.sdm.model.snake.movement.MovementRightState;
import com.sdm.model.snake.movement.MovementUpState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CollisionHandlerTest {

    private final static int STARTING_X = 20;
    private final static int STARTING_Y = 20;
    private final static int STARTING_LENGTH = 10;
    private final static int BOARD_WIDTH = 64;
    private final static int BOARD_HEIGHT = 64;
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
    void checkCollisionWithSnake() {
        snake.changeSnakeMovementState(new MovementRightState());
        snake.move();
        snake.changeSnakeMovementState(new MovementDownState());
        snake.move();
        snake.changeSnakeMovementState(new MovementLeftState());
        snake.move();

        Assertions.assertEquals(GameState.SNAKE_COLLISION, CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithFruit() {
        fruit.setPosX(20);
        fruit.setPosY(21);
        snake.move();

        Assertions.assertEquals(GameState.EAT,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithCeiling() {
        while (snake.getBodySegment(0).getY() < BOARD_HEIGHT) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithFloor() {
        snake.changeSnakeMovementState(new MovementRightState());
        snake.move();
        snake.changeSnakeMovementState(new MovementDownState());

        while (snake.getBodySegment(0).getY() > 0) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithLeftWall() {
        snake.changeSnakeMovementState(new MovementLeftState());

        while (snake.getBodySegment(0).getX() > 0) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void checkCollisionWithRightWall() {
        snake.changeSnakeMovementState(new MovementRightState());

        while (snake.getBodySegment(0).getX() < BOARD_WIDTH) snake.move();

        Assertions.assertEquals(GameState.WALL_COLLISION,CollisionHandler.checkCollision(snake,fruit,board));
    }

    @Test
    void  checkNoCollision(){
        Assertions.assertEquals(GameState.NORMAL,CollisionHandler.checkCollision(snake,fruit,board));
    }



}