package com.sdm.view;

import com.sdm.model.Board;
import com.sdm.model.Fruit;
import com.sdm.model.Score;
import com.sdm.model.snake.Snake;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


    final static double SPACEx = 2;
    final static double SPACEy = 1;
    final static Color color = Color.BLACK;
    final static double opacity = 0.8;

    public static Pane draw(Snake snake, Fruit fruit, Board board, Score score) {
        Pane pane = new Pane();


        Rectangle rectangle = new Rectangle();

        //board limits

        pane.getChildren().add(drawVerticalLine(rectangle, board, 0));

        pane.getChildren().add(drawVerticalLine(rectangle, board, board.width()));

        pane.getChildren().add(drawHorizontalLine(rectangle, board, 0));

        pane.getChildren().add(drawHorizontalLine(rectangle, board, board.height()));

        //--Fruit

        Circle circle = new Circle();

        setDrawStyle(circle);
        circle.setRadius((double) Dimension.getSquareDimension() /3);
        circle.setCenterX((fruit.getPosition().getX() + SPACEx)*Dimension.getSquareDimension() - ((double) Dimension.getSquareDimension() /2));
        circle.setCenterY((board.height() - fruit.getPosition().getY() + SPACEy)*Dimension.getSquareDimension() + ((double) Dimension.getSquareDimension() /2) - Dimension.getSquareDimension());


        pane.getChildren().add(circle);

        //---Snake

        for(int i = 0; i < snake.getBody().getSize(); i++){
            rectangle = new Rectangle();

            setDrawStyle(rectangle);

            rectangle.setHeight(Dimension.getSquareDimension());
            rectangle.setWidth(Dimension.getSquareDimension());
            rectangle.setX((snake.getBody().getBodySegment(i).getX() + SPACEx)*Dimension.getSquareDimension() - Dimension.getSquareDimension());
            rectangle.setY(((board.height() - snake.getBody().getBodySegment(i).getY())+ SPACEy)*Dimension.getSquareDimension() - Dimension.getSquareDimension());
            rectangle.setArcWidth(10);
            rectangle.setArcHeight(10);

            pane.getChildren().add(rectangle);
        }

        Text text = new Text();
        setDrawStyle(text);
        text.setText("SCORE: " + score.getScore());
        text.setY((board.height() + SPACEy + 2)*Dimension.getSquareDimension() - Dimension.getSquareDimension());
        text.setX((SPACEx)*Dimension.getSquareDimension() - Dimension.getSquareDimension());
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, Dimension.getSquareDimension()));
        pane.getChildren().add(text);


        // Creazione di un'immagine che funge da bordo
        ImageView borderImage = new ImageView(new Image("file:src/main/resources/com/sdm/images/nokiaBorderV2.png")); // Percorso dell'immagine
        borderImage.setFitWidth(Dimension.getWindow_X()); // Larghezza dell'immagine
        borderImage.setFitHeight(Dimension.getWindow_Y()); // Altezza dell'immagine
        //borderImage.setPreserveRatio(true); // Mantiene le proporzioni

        Rectangle background = new Rectangle(Dimension.getWindow_X(), Dimension.getWindow_Y(), Color.OLIVE);

        // Layout con immagine di sfondo e menu in primo piano
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background,borderImage, pane); // L'immagine Ã¨ sotto, il menu sopra
        StackPane.setAlignment(borderImage, Pos.CENTER); // Centrare l'immagine
        StackPane.setAlignment(pane, Pos.CENTER); // Centrare il pane
        StackPane.setMargin(pane, new Insets(Dimension.getWindow_Y()/9 + 1.5 * Dimension.getSquareDimension(), 0, 0, Dimension.getWindow_X()/9 + 1.5 * Dimension.getSquareDimension()));


        return stackPane;
    }

    private static void setDrawStyle (Shape shape){
        shape.setFill(color);
        shape.setOpacity(opacity);
    }

    private static Rectangle drawHorizontalLine(Rectangle rectangle, Board board, double yPosition){

        rectangle = new Rectangle();
        setDrawStyle(rectangle);

        rectangle.setWidth((board.width()-1)*Dimension.getSquareDimension());
        rectangle.setHeight(Dimension.getSquareDimension());
        rectangle.setX((SPACEx)*Dimension.getSquareDimension());
        rectangle.setY((yPosition - 1 + SPACEy)*Dimension.getSquareDimension());

        return rectangle;
    }
    private static Rectangle drawVerticalLine(Rectangle rectangle, Board board, double xPosition){

        rectangle = new Rectangle();
        setDrawStyle(rectangle);

        rectangle.setWidth(Dimension.getSquareDimension());
        rectangle.setHeight((board.height() + 1)*Dimension.getSquareDimension());
        rectangle.setX((xPosition - 1 + SPACEx)*Dimension.getSquareDimension());
        rectangle.setY((SPACEy - 1)*Dimension.getSquareDimension());
        
        return rectangle;
    }

}
