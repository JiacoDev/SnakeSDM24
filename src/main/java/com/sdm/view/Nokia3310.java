package com.sdm.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Nokia3310 {
    public static StackPane drawNokia3310() {
        return nokia3310Assemble();
    }

    private static ImageView drawPhone(){
        ImageView phone = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokiaBorderV2.png")); // Percorso dell'immagine
        phone.setFitWidth(Dimension.getWindow_X()); // Larghezza dell'immagine
        phone.setFitHeight(Dimension.getWindow_Y()); // Altezza dell'immagine
        return phone;
    }

    private static Rectangle drawScreen(){
        return new Rectangle(Dimension.getWindow_X(), Dimension.getWindow_Y(), Color.OLIVE);
    }

    private static StackPane nokia3310Assemble(){
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(drawScreen(),drawPhone()); // L'immagine sotto, il menu sopra
        return stackPane;
    }
}
