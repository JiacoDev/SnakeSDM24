package com.sdm;

public class Board {
    final private int width;
    final private int height;

    Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
