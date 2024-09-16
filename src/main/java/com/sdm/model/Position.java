package com.sdm.model;

/**
 * The {@code Position} class represents a 2D position in a coordinate system.
 * This class is used to define locations on a board, such as the position of
 * the snake and the fruit in the game.
 *
 * <p>The class provides methods to access the x and y coordinates of the position,
 * and to check if two positions are equal.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Stores x and y coordinates.</li>
 *   <li>Provides methods to get the x and y coordinates.</li>
 *   <li>Provides a method to check if two positions are equal.</li>
 * </ul>
 */

public class Position {
    private final int x;
    private final int y;

    /**
     * Constructs a new {@code Position} with the specified x and y coordinates.
     *
     * @param x the x-coordinate of the position
     * @param y the y-coordinate of the position
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this position.
     *
     * @return the x-coordinate of this position
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of this position.
     *
     * @return the y-coordinate of this position
     */
    public int getY() {
        return y;
    }

    /**
     * Checks if this position is equal to another position.
     *
     * <p>Two positions are considered equal if they have the same x and y coordinates.</p>
     *
     * @param pos the position to be compared with this position
     * @return {@code true} if this position is equal to the specified position, otherwise {@code false}
     */
    public boolean equals(Position pos) {
        return x == pos.getX() && y == pos.getY();
    }
}
