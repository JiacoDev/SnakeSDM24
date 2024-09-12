package com.sdm;

import com.sdm.snake.Snake;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Graphic {

    final static double DIM = 20;
    final static double SPACEx = 3;
    final static double SPACEy = 5;
    final static Color color = Color.BLACK;

    public static Pane draw(Snake snake, Fruit fruit, Board board) {
        Pane pane = new Pane();

        Rectangle rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth(DIM);
        rectangle.setHeight(board.getHeight()*DIM);
        rectangle.setX((-1 + SPACEx)*DIM);
        rectangle.setY(SPACEy*DIM);
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth(DIM);
        rectangle.setHeight(board.getHeight()*DIM);
        rectangle.setX((board.getWidth()-1 + SPACEx)*DIM);
        rectangle.setY((-1 + SPACEy)*DIM);
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth(board.getWidth()*DIM);
        rectangle.setHeight(DIM);
        rectangle.setX((-1 + SPACEx)*DIM);
        rectangle.setY((-1 + SPACEy)*DIM);
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setWidth((board.getWidth())*DIM);
        rectangle.setHeight(DIM);
        rectangle.setX((SPACEx)*DIM);
        rectangle.setY((board.getHeight() -1 + SPACEy)*DIM);
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);

        Circle circle = new Circle();
        circle.setRadius(DIM/3);
        circle.setFill(color);
        circle.setCenterX((fruit.getPosX() + SPACEx)*DIM - (DIM/2));
        circle.setCenterY((board.getHeight() - fruit.getPosY() + SPACEy)*DIM + (DIM/2) - DIM);
        circle.setOpacity(0.8);

        pane.getChildren().add(circle);

        rectangle = new Rectangle();

        rectangle.setFill(color);
        rectangle.setHeight(DIM);
        rectangle.setWidth(DIM);
        rectangle.setX((snake.getHeadXCoordinate() + SPACEx)*DIM - DIM);
        rectangle.setY((board.getHeight() - snake.getHeadYCoordinate() + SPACEy)*DIM - DIM);
        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);
        rectangle.setOpacity(0.8);

        pane.getChildren().add(rectangle);



        for(int i = 1; i < snake.getSize(); i++){
            rectangle = new Rectangle();
            rectangle.setFill(color);
            rectangle.setHeight(DIM);
            rectangle.setWidth(DIM);
            rectangle.setX((snake.getTailXCoordinate(i) + SPACEx)*DIM - DIM);
            rectangle.setY(((board.getHeight() - snake.getTailYCoordinate(i))+ SPACEy)*DIM - DIM);
            rectangle.setArcWidth(10);
            rectangle.setArcHeight(10);
            rectangle.setOpacity(0.8);

            pane.getChildren().add(rectangle);
        }

        return pane;
    }

}
