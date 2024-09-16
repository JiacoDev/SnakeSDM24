package com.sdm.logic;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Position;
import com.sdm.model.snake.Snake;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * The {@code FruitSpawnHandler} class handles the logic for spawning and moving a fruit randomly on a game board,
 * ensuring it does not overlap with the snake's body. It utilizes a random number generator for determining the
 * fruit's new position.
 *
 * <p>This class provides a method to move the fruit to a random position and a method to set a custom random generator,
 * which can be useful for testing or seeding specific randomness.</p>
 *
 * Class Overview:
 * <ul>
 *   <li>Handles fruit positioning on the game board.</li>
 *   <li>Ensures the fruit doesn't overlap with the snake's current position.</li>
 *   <li>Allows setting a custom random generator, primarily for testing purposes.</li>
 * </ul>
 */

public class FruitSpawnHandler {
    private static Random rand = new Random(System.currentTimeMillis());

    /**
     * Sets a custom {@code Random} object to generate random positions. This method can be useful for
     * testing where a deterministic sequence of random numbers is needed.
     *
     * @param random the custom {@code Random} object to use for random number generation
     */
    public static void setRandom(Random random) {
        rand = random;
    }

    /**
     * Moves the fruit to a new random position on the board. The new position is randomly chosen
     * within the board's dimensions, and it ensures the fruit does not overlap with any segment
     * of the snake's body.
     *
     * <p>The method repeatedly generates random positions until one is found that does not intersect
     * with the snake's body.</p>
     *
     * @param snake the {@code Snake} object representing the current state of the snake
     * @param fruit the {@code Fruit} object that is to be moved to a new random position
     * @param board the {@code Board} object representing the game board with width and height constraints
     */
    public static void randomFruitMove(Snake snake, Fruit fruit, Board board) {
        do {
            fruit.setPosition(new Position(
                    rand.nextInt(1, board.width()),
                    rand.nextInt(1, board.height())
            ));
        } while (IntStream.range(0, snake.getSize())
                .anyMatch(j -> snake.getBodySegment(j).equals(fruit.getPosition())));
    }
}
