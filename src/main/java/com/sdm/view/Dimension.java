/**
 * The {@code Dimension} class is responsible for managing the dimensions of the game board and scaling those dimensions
 * to determine the size of the game window. This class also defines the size of each square unit used for rendering
 * the snake and other game elements.
 *
 * <p>The class provides methods to calculate the width and height of the game window based on the size of the game board
 * and applies a scaling factor to ensure the game is displayed properly on the screen. It also allows setting the initial
 * dimensions of the game board.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Defines the dimensions for the game board and window.</li>
 *   <li>Applies scaling to calculate window dimensions based on the size of the board.</li>
 *   <li>Provides a method to set the board's initial dimensions.</li>
 * </ul>
 */
package com.sdm.view;

public class Dimension {
    private static int boardStartingWidth;
    private static int boardStartingHeight;
    private static final int squareDimension = 15;

    /**
     * Returns the width of the game window in pixels, scaled based on the width of the board and additional padding.
     *
     * <p>The window width is calculated by adding extra space for the padding around the board and then applying
     * a scaling factor to ensure the window size fits the board and other game elements properly.</p>
     *
     * @return the width of the game window in pixels
     */
    public static double getWindow_width() {
        return scale(((boardStartingWidth + 2 + Graphic.HORIZONTAL_GAP * 2) / 7) * 9);
    }

    /**
     * Returns the height of the game window in pixels, scaled based on the height of the board and additional padding.
     *
     * <p>The window height is calculated similarly to the width, considering the padding and applying the scaling factor
     * to match the game's visual requirements.</p>
     *
     * @return the height of the game window in pixels
     */
    public static double getWindow_height() {
        return scale(((boardStartingHeight + 2 + Graphic.VERTICAL_GAP * 2) / 5) * 9);
    }

    /**
     * Sets the initial dimensions (width and height) of the game board.
     *
     * @param width  the width of the game board
     * @param height the height of the game board
     */
    public static void setDimension(int width, int height) {
        boardStartingWidth = width;
        boardStartingHeight = height;
    }

    /**
     * Scales a given value based on the size of each square tile in the game.
     *
     * <p>This method multiplies the provided value by {@code squareDimension}, which represents the size of each tile
     * in the game. It is used to ensure the game's graphical elements are properly sized relative to the board's size.</p>
     *
     * @param val the value to be scaled
     * @return the scaled value
     */
    public static double scale(double val) {
        return val * squareDimension;
    }
}
