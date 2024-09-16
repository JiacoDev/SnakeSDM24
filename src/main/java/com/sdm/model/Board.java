package com.sdm.model;

/**
 * Represents a rectangular grid with specified width and height.
 * <p>
 * This class is immutable, which means that once an instance is created,
 * the width and height cannot be modified.
 * </p>
 * <p>
 * Getter methods provide access to the width and height of the grid.
 * </p>
 *
 * @param width  The width of the grid.
 * @param height The height of the grid.
 */
public record Board(int width, int height) {

    /**
     * Constructs a new {@code Board} instance with the specified width and height.
     *
     * @param width  The width of the grid.
     * @param height The height of the grid.
     */
    public Board {
    }

    /**
     * Returns the height of the grid.
     *
     * @return The height of the grid.
     */
    @Override
    public int height() {
        return height;
    }

    /**
     * Returns the width of the grid.
     *
     * @return The width of the grid.
     */
    @Override
    public int width() {
        return width;
    }
}
