package com.sdm;

import com.sdm.snake.Snake;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Graphic {


    final static double SPACEx = 2;
    final static double SPACEy = 1.5;
    final static Color color = Color.BLACK;

    public static Pane draw(Snake snake, Fruit fruit, Board board, Score score) {
        Pane pane = new Pane();
        Dimension dimension = new Dimension();

        Rectangle rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth(dimension.getDim());
        rectangle.setHeight(board.getHeight()*dimension.getDim());
        rectangle.setX((-1 + SPACEx)*dimension.getDim());
        rectangle.setY(SPACEy*dimension.getDim());
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth(dimension.getDim());
        rectangle.setHeight(board.getHeight()*dimension.getDim());
        rectangle.setX((board.getWidth()-1 + SPACEx)*dimension.getDim());
        rectangle.setY((-1 + SPACEy)*dimension.getDim());
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth(board.getWidth()*dimension.getDim());
        rectangle.setHeight(dimension.getDim());
        rectangle.setX((-1 + SPACEx)*dimension.getDim());
        rectangle.setY((-1 + SPACEy)*dimension.getDim());
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth((board.getWidth())*dimension.getDim());
        rectangle.setHeight(dimension.getDim());
        rectangle.setX((SPACEx)*dimension.getDim());
        rectangle.setY((board.getHeight() -1 + SPACEy)*dimension.getDim());
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        Circle circle = new Circle();
        circle.setRadius((double) dimension.getDim() /3);
        circle.setFill(color);
        circle.setCenterX((fruit.getPosX() + SPACEx)*dimension.getDim() - ((double) dimension.getDim() /2));
        circle.setCenterY((board.getHeight() - fruit.getPosY() + SPACEy)*dimension.getDim() + ((double) dimension.getDim() /2) - dimension.getDim());
        circle.setOpacity(0.8);

        pane.getChildren().add(circle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setHeight(dimension.getDim());
        rectangle.setWidth(dimension.getDim());
        rectangle.setX((snake.getHeadXCoordinate() + SPACEx)*dimension.getDim() - dimension.getDim());
        rectangle.setY((board.getHeight() - snake.getHeadYCoordinate() + SPACEy)*dimension.getDim() - dimension.getDim());
        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);



        for(int i = 1; i < snake.getSize(); i++){
            rectangle = new Rectangle();
            rectangle.setFill(color);
            rectangle.setHeight(dimension.getDim());
            rectangle.setWidth(dimension.getDim());
            rectangle.setX((snake.getTailXCoordinate(i) + SPACEx)*dimension.getDim() - dimension.getDim());
            rectangle.setY(((board.getHeight() - snake.getTailYCoordinate(i))+ SPACEy)*dimension.getDim() - dimension.getDim());
            rectangle.setArcWidth(10);
            rectangle.setArcHeight(10);
            rectangle.setOpacity(0.8);

            pane.getChildren().add(rectangle);
        }

        Text text = new Text();
        text.setText("SCORE: " + score.getScore());
        text.setFill(color);
        text.setOpacity(0.8);
        text.setY((board.getHeight() + SPACEy + 2)*dimension.getDim() - dimension.getDim());
        text.setX((SPACEx)*dimension.getDim() - dimension.getDim());
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, dimension.getDim()));
        pane.getChildren().add(text);


        // Creazione di un'immagine che funge da bordo
        ImageView borderImage = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokiaBorderV2.png")); // Percorso dell'immagine
        borderImage.setFitWidth(dimension.getWindow_X()); // Larghezza dell'immagine
        borderImage.setFitHeight(dimension.getWindow_Y()); // Altezza dell'immagine
        //borderImage.setPreserveRatio(true); // Mantiene le proporzioni

        Rectangle background = new Rectangle(dimension.getWindow_X(), dimension.getWindow_Y(), Color.OLIVE);

        // Layout con immagine di sfondo e menu in primo piano
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background,borderImage, pane); // L'immagine Ã¨ sotto, il menu sopra
        StackPane.setAlignment(borderImage, Pos.CENTER); // Centrare l'immagine
        StackPane.setAlignment(pane, Pos.CENTER); // Centrare il pane
        StackPane.setMargin(pane, new Insets(dimension.getWindow_Y()/9 + 1.5 * dimension.getDim(), 0, 0, dimension.getWindow_X()/9 + 1.5 * dimension.getDim()));


        return stackPane;
    }

}
