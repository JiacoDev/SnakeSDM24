/**
 * The {@code Nokia3310} class provides a utility for creating a visual representation
 * of a Nokia 3310 phone frame with a game screen. This class assembles and returns
 * a {@link StackPane} that contains an image of the Nokia 3310 phone border and
 * a background screen color.
 *
 * <p>This class is used to create a styled game window that resembles the Nokia 3310 phone,
 * providing a visually distinct border and background for the game.</p>
 *
 * <h3>Class Overview:</h3>
 * <ul>
 *   <li>Creates an image view for the phone border.</li>
 *   <li>Creates a background screen rectangle with a specified color.</li>
 *   <li>Assembles these elements into a {@link StackPane}.</li>
 * </ul>
 */
package com.sdm.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Nokia3310 {

    /**
     * Assembles and returns a {@link StackPane} representing the Nokia 3310 frame
     * with a background screen.
     *
     * @return a {@link StackPane} containing the phone border image and background screen
     */
    public static StackPane drawNokia3310() {
        return nokia3310Assemble();
    }

    private static ImageView drawPhone() {
        ImageView phone = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokiaBorderV2.png"));
        phone.setFitWidth(Dimension.getWindow_X()); // Set width of the image
        phone.setFitHeight(Dimension.getWindow_Y()); // Set height of the image
        return phone;
    }

    private static Rectangle drawScreen() {
        return new Rectangle(Dimension.getWindow_X(), Dimension.getWindow_Y(), Color.OLIVE);
    }

    private static StackPane nokia3310Assemble() {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(drawScreen(), drawPhone());
        return stackPane;
    }
}
