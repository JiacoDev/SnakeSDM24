package com.sdm.model.snake.body;

import com.sdm.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SnakeBody} class manages the list of body elements that make up the snake.
 * It handles initialization of the snake's body, as well as updates to the head and tail
 * during movement and growth.
 */
public class SnakeBody {
    private final List<Position> bodySegments;

    public SnakeBody(Position initialPosition, int initialLength) {
        this.bodySegments = new ArrayList<>();
        for(int i = 0; i < initialLength; i++) {
            Position segment = new Position(initialPosition.getX(), initialPosition.getY() - i);
            this.bodySegments.add(segment);
        }
    }

    public void addNewHead(Position newHead) {
        bodySegments.addFirst(newHead);
    }

    public void removeLastBodySegment() {
        if (bodySegments.size() > 1) {
            bodySegments.removeLast();
        }
    }

    public Position getHead() {
        return bodySegments.getFirst();
    }

    public Position getBodySegment(int index) {
        return bodySegments.get(index);
    }

    public int getSize() {
        return bodySegments.size();
    }
}


