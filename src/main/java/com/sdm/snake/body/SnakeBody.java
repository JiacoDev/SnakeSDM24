package com.sdm.snake.body;

import java.util.ArrayList;
import java.util.List;

public class SnakeBody {
    private final List<BodyElement> bodyElements = new ArrayList<>();

    public SnakeBody(int startingX, int startingY, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        bodyElements.add(new BodyElement(startingX, startingY, BodyType.HEAD));
        for (int i = 1; i < length; i++) {
            bodyElements.add(new BodyElement(startingX, startingY - i, BodyType.TAIL));
        }
    }

    public int getHeadXCoordinate() {
        return bodyElements.getFirst().posX();
    }

    public int getHeadYCoordinate() {
        return bodyElements.getFirst().posY();
    }

    public int getTailXCoordinate(int position) {
        return bodyElements.get(position).posX();
    }

    public int getTailYCoordinate(int position) {
        return bodyElements.get(position).posY();
    }

    public void setNewHead(int newX, int newY) {
        bodyElements.addFirst(new BodyElement(newX, newY, BodyType.HEAD));
        bodyElements.set(1, new BodyElement(bodyElements.get(1).posX(), bodyElements.get(1).posY(), BodyType.TAIL));
    }

    public void removeLastElement() {
        bodyElements.removeLast();
    }

    public int getSize() {
        return bodyElements.size();
    }
}

