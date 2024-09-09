package com.sdm.snake;

//Da decidere se fare refactoring in State altering Design pattern
//Ulteriori refacoring necessari

/**
 * Class responsible for handling collisions in the Snake game.
 */
public class CollisionHandler {

    /**
     * Checks the type of collision between the snake and various game elements.
     *
     * @param snake the snake in the game
     * @param fruit the fruit the snake can eat
     * @param board the game board
     * @return a game state representing the type of collision detected:
     *         - GameState.EAT if the snake has eaten a fruit
     *         - GameState.SNAKE_COLLISION if the snake collided with itself
     *         - GameState.WALL_COLLISION if the snake hit a wall
     *         - GameState.NORMAL if no collision was detected
     */
    public static GameState checkCollision(Snake snake, Fruit fruit, Board board) {
        if (checkCollisionWithFruit(snake, fruit)) return GameState.EAT;
        if (checkCollisionWithSnake(snake)) return GameState.SNAKE_COLLISION;
        if (checkCollisionWithWall(snake, board)) return GameState.WALL_COLLISION;
        return GameState.NORMAL;
    }

    /**
     * Checks if the snake has collided with itself (self-collision).
     *
     * @param snake the snake in the game
     * @return true if the snake has collided with its own body, false otherwise
     */
    private static boolean checkCollisionWithSnake(Snake snake) {
        int headXCoordinate = snake.getHeadXCoordinate();
        int headYCoordinate = snake.getHeadYCoordinate();
        for (int i = 1; i < snake.getSize(); i++) {
            if ((headXCoordinate == snake.getTailXCoordinate(i)) &&
                    (headYCoordinate == snake.getTailYCoordinate(i))) return true;
        }
        return false;
    }

    /**
     * Checks if the snake has collided with a fruit.
     *
     * @param snake the snake in the game
     * @param fruit the fruit to check for collision
     * @return true if the snake has collided with the fruit, false otherwise
     */
    private static boolean checkCollisionWithFruit(Snake snake, Fruit fruit) {
        return snake.getHeadXCoordinate() == fruit.getPosX() &&
                snake.getHeadYCoordinate() == fruit.getPosY();
    }

    /**
     * Checks if the snake has collided with a wall.
     *
     * @param snake the snake in the game
     * @param board the game board
     * @return true if the snake has collided with a wall, false otherwise
     */
    private static boolean checkCollisionWithWall(Snake snake, Board board) {
        return snake.getHeadXCoordinate() == board.getWidth() ||
                snake.getHeadXCoordinate() == 0 ||
                snake.getHeadYCoordinate() == board.getHeight() ||
                snake.getHeadYCoordinate() == 0;
    }
}


