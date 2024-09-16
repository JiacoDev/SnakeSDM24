package com.sdm.model.snake.body;

import com.sdm.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code SnakeBody} class represents the body of the snake in the game. It manages the
 * segments that make up the snake's body, including adding new segments and removing the tail.
 */
public class SnakeBody {
    private final List<Position> bodySegments;

    /**
     * Constructs a new {@code SnakeBody} with an initial position and length.
     * The snake body is initialized with the head at the given position, and the rest of the
     * segments extend downward.
     *
     * @param initialPosition The position of the snake's head.
     * @param initialLength   The initial number of segments in the snake's body.
     */
    public SnakeBody(Position initialPosition, int initialLength) {
        this.bodySegments = new ArrayList<>();
        for (int i = 0; i < initialLength; i++) {
            Position segment = new Position(initialPosition.getX(), initialPosition.getY() - i);
            this.bodySegments.add(segment);
        }
    }

    /**
     * Adds a new head to the snake body at the specified position. This effectively extends
     * the snake in the direction of movement by one segment.
     *
     * @param newHead The position of the new head segment.
     */
    public void addNewHead(Position newHead) {
        bodySegments.addFirst(newHead);
    }

    /**
     * Removes the last segment of the snake body, typically called after the snake moves
     * forward to keep the length constant.
     */
    public void removeLastBodySegment() {
        bodySegments.removeLast();
    }

    /**
     * Returns the current position of the snake's head.
     *
     * @return The {@code Position} of the head segment.
     */
    public Position getHead() {
        return bodySegments.getFirst();
    }

    /**
     * Returns the position of the body segment at the specified index.
     *
     * @param index The index of the body segment to retrieve.
     * @return The {@code Position} of the body segment at the given index.
     */
    public Position getBodySegment(int index) {
        return bodySegments.get(index);
    }

    /**
     * Returns the total number of segments in the snake body.
     *
     * @return The size of the snake body, i.e., the number of segments.
     */
    public int getSize() {
        return bodySegments.size();
    }
}
