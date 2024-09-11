package com.sdm;

import com.sdm.snake.Snake;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Graphic {

    final static double DIM = 20;

    public static Pane draw(Snake snake, Fruit fruit, Board board) {
        Pane pane = new Pane();

        Rectangle rectangle = new Rectangle();

        rectangle.setFill(Color.BLACK);
        rectangle.setHeight(DIM);
        rectangle.setWidth(DIM);
        rectangle.setX(snake.getHeadXCoordinate()*DIM - DIM);
        rectangle.setY((board.getHeight() - snake.getHeadYCoordinate())*DIM - DIM);

        pane.getChildren().add(rectangle);

        for(int i = 1; i < snake.getSize(); i++){
            rectangle = new Rectangle();
            rectangle.setFill(Color.GREEN);
            rectangle.setHeight(DIM);
            rectangle.setWidth(DIM);
            rectangle.setX(snake.getTailXCoordinate(i)*DIM - DIM);
            rectangle.setY((board.getHeight() - snake.getTailYCoordinate(i))*DIM - DIM);

            pane.getChildren().add(rectangle);
        }

        Circle circle = new Circle();
        circle.setRadius(DIM/3);
        circle.setFill(Color.RED);
        circle.setCenterX((fruit.getPosX())*DIM - (DIM/2));
        circle.setCenterY((board.getHeight() - fruit.getPosY())*DIM + (DIM/2) - DIM);

        pane.getChildren().add(circle);


        return pane;
    }

}
