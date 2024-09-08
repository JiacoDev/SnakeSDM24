package com.sdm.snake;

public record BodyElement(int posX, int posY, BodyType type) {
    public BodyElement(int posX, int posY, BodyType type) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }
}
