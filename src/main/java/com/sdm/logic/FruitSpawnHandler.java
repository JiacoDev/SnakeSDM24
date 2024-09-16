package com.sdm.logic;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Position;
import com.sdm.model.snake.Snake;

import java.util.Random;
import java.util.stream.IntStream;

public class FruitSpawnHandler {
    private static Random rand = new Random(System.currentTimeMillis());

    public static void setRandom(Random random) {
        rand = random;
    }

    public static void randomFruitMove(Snake snake, Fruit fruit, Board board) {
        do {
            fruit.setPosition(new Position(rand.nextInt(1, board.width()),rand.nextInt(1, board.height())));
        } while (IntStream.range(0, snake.getSize()).anyMatch(
                j -> snake.getBody().getBodySegment(j).getX() == fruit.getPosition().getX() &&
                        snake.getBody().getBodySegment(j).getY() == fruit.getPosition().getY()));
    }
}
