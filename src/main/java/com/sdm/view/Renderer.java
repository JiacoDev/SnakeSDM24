package com.sdm.view;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;

public interface Renderer {
    public void draw(Snake snake, Fruit fruit, Board board, Score score);
    public void drawGameOver(Score score);
}