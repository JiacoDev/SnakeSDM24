package com.sdm;

import com.sdm.snake.Snake;

import java.util.Random;
import java.util.stream.IntStream;

public class FruitSpawnHandler {
    private static Random rand = new Random(System.currentTimeMillis());

    public static void setRandom(Random random) {
        rand = random;
    }

    public static void randomFruitMove(Snake snake, Fruit fruit, Board board) {
        do {
            fruit.setPosX(rand.nextInt(1,board.width()));
            fruit.setPosY(rand.nextInt(1,board.height()));
        } while ( IntStream.range(0, snake.getSize()).anyMatch(
                j -> snake.getTailXCoordinate(j) == fruit.getPosX() &&
                        snake.getTailYCoordinate(j) == fruit.getPosY()));
    }
}
