package com.sdm;

/**
 * Represents a rectangular grid with specified width and height.
 * <p>
 * This class is immutable, which means that once an instance is created,
 * the width and height cannot be modified.
 * </p>
 * <p>
 * Getter methods provide access to the width and height of the grid.
 * </p>
 */
public class Board {

    /**
     * The width of the grid.
     */
    private final int width;

    /**
     * The height of the grid.
     */
    private final int height;

    /**
     * Constructs a new {@code Board} instance with the specified width and height.
     *
     * @param width The width of the grid.
     * @param height The height of the grid.
     */
    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the height of the grid.
     *
     * @return The height of the grid.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the width of the grid.
     *
     * @return The width of the grid.
     */
    public int getWidth() {
        return width;
    }
}
