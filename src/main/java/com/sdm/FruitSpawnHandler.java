package com.sdm;

import com.sdm.snake.Snake;

import java.util.Random;
import java.util.stream.IntStream;

public class FruitSpawnHandler {
    

    public static void randomFruitMove(Snake snake, Fruit fruit, Board board) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        do {
            fruit.setPosX(rand.nextInt(1,board.getWidth()));
            fruit.setPosY(rand.nextInt(1,board.getHeight()));
        } while ( IntStream.range(0, snake.getSize()).anyMatch(
                j -> snake.getTailXCoordinate(j) == fruit.getPosX() &&
                        snake.getTailYCoordinate(j) == fruit.getPosY()));
    }
}
