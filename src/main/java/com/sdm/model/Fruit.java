package com.sdm.model;

/**
 * The {@code Fruit} class represents a fruit object in the game. It has a position
 * on the game board where it is located. This class allows for the retrieval and
 * modification of the fruit's position.
 *
 * <p>The class provides methods to get and set the position of the fruit.</p>
 *
 * Class Overview:
 * <ul>
 *   <li>Stores the position of the fruit.</li>
 *   <li>Provides methods to get and set the fruit's position.</li>
 * </ul>
 */

public class Fruit {
    private Position position;

    /**
     * Constructs a new {@code Fruit} with the specified position.
     *
     * @param position the position of the fruit on the game board
     */
    public Fruit(Position position) {
        this.position = position;
    }

    /**
     * Returns the current position of the fruit.
     *
     * @return the position of the fruit
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the position of the fruit to the specified position.
     *
     * @param position the new position of the fruit
     */
    public void setPosition(Position position) {
        this.position = position;
    }
}
