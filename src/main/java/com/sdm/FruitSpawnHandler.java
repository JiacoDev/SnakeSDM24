package com.sdm;

import com.sdm.snake.Snake;

import java.util.Random;
import java.util.stream.IntStream;

public class FruitSpawnHandler {
    

    public static void randomFruitMove(Snake snake, Fruit fruit, Board board) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        do {
            fruit.setPosX(rand.nextInt(0,board.getWidth()+1));
            fruit.setPosY(rand.nextInt(0,board.getHeight()+1));
        } while ( IntStream.range(0, snake.getSize()).anyMatch(
                j -> snake.getTailXCoordinate(j) == fruit.getPosX() &&
                        snake.getTailYCoordinate(j) == fruit.getPosY()));
    }
}
