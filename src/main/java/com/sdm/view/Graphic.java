/**
 * The {@code Graphic} class provides methods to render the game elements on the screen using JavaFX.
 * It includes methods to draw the game board, snake, fruit, and score, as well as handle the layout of these elements.
 *
 * <p>This class is responsible for creating the visual representation of the game by drawing various components on
 * a {@code Pane} and setting their styles and positions. The rendered elements are then added to a {@code StackPane}
 * which can be displayed as part of the game scene.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Draws the game board, including its boundaries.</li>
 *   <li>Draws the snake, fruit, and current score.</li>
 *   <li>Handles positioning and styling of graphical elements.</li>
 * </ul>
 */
package com.sdm.view;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Graphic {
    final static double HORIZONTAL_GAP = 2;
    final static double VERTICAL_GAP = 1;
    final static Color COLOR = Color.BLACK;
    final static double OPACITY = 0.8;

    /**
     * Draws the current state of the game including the snake, fruit, board, and score.
     *
     * <p>This method creates a {@code Pane} and adds graphical elements to it, such as the game board boundaries,
     * the snake, fruit, and the score text. It then places this pane into a {@code StackPane} to be rendered on the screen.</p>
     *
     * @param snake the {@code Snake} object representing the current state of the snake
     * @param fruit the {@code Fruit} object representing the current position of the fruit
     * @param board the {@code Board} object representing the game board
     * @param score the {@code Score} object representing the current score
     * @return a {@code StackPane} containing the drawn game elements
     */
    public static Pane draw(Snake snake, Fruit fruit, Board board, Score score) {
        Pane pane = new Pane();

        pane.getChildren().add(drawVerticalLine(board, 0));
        pane.getChildren().add(drawVerticalLine(board, board.width()));
        pane.getChildren().add(drawHorizontalLine(board, 0));
        pane.getChildren().add(drawHorizontalLine(board, board.height()));

        pane.getChildren().add(drawFruit(fruit, board));

        drawSnake(snake, board, pane);

        pane.getChildren().add(drawText(score, board));

        StackPane stackPane = Nokia3310.drawNokia3310();
        stackPane.getChildren().add(pane);
        StackPane.setAlignment(pane, Pos.CENTER);
        StackPane.setMargin(pane, new Insets(Dimension.getWindow_height() / 9 + Dimension.scale(1.5), 0, 0, Dimension.getWindow_width() / 9 + Dimension.scale(1.5)));

        return stackPane;
    }

    /**
     * Sets the drawing style for a shape, including color and opacity.
     *
     * @param shape the {@code Shape} to style
     */
    private static void setDrawStyle(Shape shape) {
        shape.setFill(COLOR);
        shape.setOpacity(OPACITY);
    }

    /**
     * Sets the dimensions of a {@code Rectangle}.
     *
     * @param rectangle the {@code Rectangle} to resize
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    private static void setDimension(Rectangle rectangle, double width, double height) {
        rectangle.setWidth(Dimension.scale(width));
        rectangle.setHeight(Dimension.scale(height));
    }

    /**
     * Sets the position of a {@code Rectangle}.
     *
     * @param rectangle the {@code Rectangle} to position
     * @param x         the x-coordinate of the rectangle's position
     * @param y         the y-coordinate of the rectangle's position
     */
    private static void setPosition(Rectangle rectangle, double x, double y) {
        rectangle.setX(Dimension.scale(x));
        rectangle.setY(Dimension.scale(y));
    }

    /**
     * Sets the position of a {@code Circle}.
     *
     * @param circle the {@code Circle} to position
     * @param x      the x-coordinate of the circle's center
     * @param y      the y-coordinate of the circle's center
     */
    private static void setPosition(Circle circle, double x, double y) {
        circle.setCenterX(Dimension.scale(x));
        circle.setCenterY(Dimension.scale(y));
    }

    /**
     * Sets the position of a {@code Text}.
     *
     * @param text the {@code Text} to position
     * @param x    the x-coordinate of the text's position
     * @param y    the y-coordinate of the text's position
     */
    private static void setPosition(Text text, double x, double y) {
        text.setX(Dimension.scale(x));
        text.setY(Dimension.scale(y));
    }

    /**
     * Draws a horizontal line at the specified y-coordinate of the game board.
     *
     * <p>This method creates a {@code Rectangle} representing a horizontal line, sets its style and position, and returns it.</p>
     *
     * @param board     the {@code Board} object representing the game board
     * @param yPosition the y-coordinate for the horizontal line
     * @return a {@code Rectangle} representing the horizontal line
     */
    private static Rectangle drawHorizontalLine(Board board, double yPosition) {
        Rectangle rectangle = new Rectangle();
        setDrawStyle(rectangle);
        setDimension(rectangle, board.width() - 1, 1);
        setPosition(rectangle, HORIZONTAL_GAP, yPosition - 1 + VERTICAL_GAP);
        return rectangle;
    }

    /**
     * Draws a vertical line at the specified x-coordinate of the game board.
     *
     * <p>This method creates a {@code Rectangle} representing a vertical line, sets its style and position, and returns it.</p>
     *
     * @param board     the {@code Board} object representing the game board
     * @param xPosition the x-coordinate for the vertical line
     * @return a {@code Rectangle} representing the vertical line
     */
    private static Rectangle drawVerticalLine(Board board, double xPosition) {
        Rectangle rectangle = new Rectangle();
        setDrawStyle(rectangle);
        setDimension(rectangle, 1, board.height() + 1);
        setPosition(rectangle, xPosition - 1 + HORIZONTAL_GAP, VERTICAL_GAP - 1);
        return rectangle;
    }

    /**
     * Draws the fruit at its current position on the game board.
     *
     * <p>This method creates a {@code Circle} representing the fruit, sets its style and position, and returns it.</p>
     *
     * @param fruit the {@code Fruit} object representing the current position of the fruit
     * @param board the {@code Board} object representing the game board
     * @return a {@code Circle} representing the fruit
     */
    private static Circle drawFruit(Fruit fruit, Board board) {
        Circle circle = new Circle();
        setDrawStyle(circle);
        circle.setRadius(Dimension.scale((double) 1 / 3));
        setPosition(circle, fruit.getPosition().getX() + HORIZONTAL_GAP - (double) 1 / 2, board.height() - fruit.getPosition().getY() + VERTICAL_GAP - (double) 1 / 2);
        return circle;
    }

    /**
     * Draws the snake on the game board.
     *
     * <p>This method iterates through the snake's body segments, creating a {@code Rectangle} for each segment, and adds them to the given {@code Pane}.</p>
     *
     * @param snake the {@code Snake} object representing the current state of the snake
     * @param board the {@code Board} object representing the game board
     * @param pane  the {@code Pane} to which the snake segments will be added
     */
    private static void drawSnake(Snake snake, Board board, Pane pane) {
        Rectangle rectangle;
        for (int i = 0; i < snake.getSize(); i++) {
            rectangle = new Rectangle();
            setDrawStyle(rectangle);
            setDimension(rectangle, 1, 1);
            setPosition(rectangle, snake.getBodySegment(i).getX() + HORIZONTAL_GAP - 1, board.height() - snake.getBodySegment(i).getY() + VERTICAL_GAP - 1);
            rectangle.setArcWidth(10);
            rectangle.setArcHeight(10);
            pane.getChildren().add(rectangle);
        }
    }

    /**
     * Draws the current score on the game board.
     *
     * <p>This method creates a {@code Text} object to display the score, sets its style and position, and returns it.</p>
     *
     * @param score the {@code Score} object representing the current score
     * @param board the {@code Board} object representing the game board
     * @return a {@code Text} object representing the score
     */
    public static Text drawText(Score score, Board board) {
        Text text = new Text();
        setDrawStyle(text);
        text.setText("SCORE: " + score.getScore());
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, Dimension.scale(1)));
        setPosition(text, HORIZONTAL_GAP - 1, board.height() + VERTICAL_GAP + 1);
        return text;
    }
}
