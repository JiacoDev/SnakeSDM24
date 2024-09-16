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


    final static double SPACEx = 2;
    final static double SPACEy = 1;
    final static Color color = Color.BLACK;
    final static double opacity = 0.8;

    public static Pane draw(Snake snake, Fruit fruit, Board board, Score score) {
        Pane pane = new Pane();

        //--Board limits

        pane.getChildren().add(drawVerticalLine(board, 0));

        pane.getChildren().add(drawVerticalLine(board, board.width()));

        pane.getChildren().add(drawHorizontalLine(board, 0));

        pane.getChildren().add(drawHorizontalLine(board, board.height()));

        //--Fruit

        pane.getChildren().add(drawFruit(fruit,board));

        //---Snake

        drawSnake(snake,board,pane);

        //--Score

        pane.getChildren().add(drawText(score,board));

        //--Set the game in the Nokia

        StackPane stackPane = Nokia3310.drawNokia3310();
        stackPane.getChildren().add(pane);
        StackPane.setAlignment(pane, Pos.CENTER); // Centrare il pane
        StackPane.setMargin(pane, new Insets(Dimension.getWindow_Y()/9 + Dimension.scale(1.5), 0, 0, Dimension.getWindow_X()/9 + Dimension.scale(1.5)));


        return stackPane;
    }

    private static void setDrawStyle (Shape shape){
        shape.setFill(color);
        shape.setOpacity(opacity);
    }

    private static void setDimension(Rectangle rectangle, double width, double height){
        rectangle.setWidth(Dimension.scale(width));
        rectangle.setHeight(Dimension.scale(height));
    }

    private static void setPosition(Rectangle rectangle, double x, double y){
        rectangle.setX(Dimension.scale(x));
        rectangle.setY(Dimension.scale(y));
    }

    private static void setPosition(Circle circle, double x, double y){
        circle.setCenterX(Dimension.scale(x));
        circle.setCenterY(Dimension.scale(y));
    }

    private static void setPosition(Text text, double x, double y){
        text.setX(Dimension.scale(x));
        text.setY(Dimension.scale(y));
    }

    private static Rectangle drawHorizontalLine(Board board, double yPosition){

        Rectangle rectangle = new Rectangle();

        setDrawStyle(rectangle);

        setDimension(rectangle, board.width()-1, 1);

        setPosition(rectangle, SPACEx, yPosition - 1 + SPACEy);

        return rectangle;
    }
    private static Rectangle drawVerticalLine(Board board, double xPosition){

        Rectangle rectangle = new Rectangle();

        setDrawStyle(rectangle);

        setDimension(rectangle,1,board.height() + 1);

        setPosition(rectangle, xPosition - 1 + SPACEx, SPACEy - 1);

        return rectangle;
    }
    private static Circle drawFruit(Fruit fruit , Board board){

        Circle circle = new Circle();

        setDrawStyle(circle);

        circle.setRadius(Dimension.scale((double) 1 /3));

        setPosition(circle,fruit.getPosition().getX() + SPACEx - (double) 1 /2,board.height() - fruit.getPosition().getY() + SPACEy - (double) 1/2);

        return circle;
    }
    private static void drawSnake(Snake snake, Board board, Pane pane){
        Rectangle rectangle;

        for(int i = 0; i < snake.getBody().getSize(); i++){

            rectangle = new Rectangle();

            setDrawStyle(rectangle);

            setDimension(rectangle, 1, 1);

            setPosition(rectangle, snake.getBody().getBodySegment(i).getX() + SPACEx - 1, board.height() - snake.getBody().getBodySegment(i).getY()+ SPACEy - 1);

            rectangle.setArcWidth(10);
            rectangle.setArcHeight(10);

            pane.getChildren().add(rectangle);

        }
    }
    public static Text drawText(Score score, Board board ){
        Text text = new Text();

        setDrawStyle(text);

        text.setText("SCORE: " + score.getScore());
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, Dimension.scale(1)));

        setPosition(text, SPACEx-1, board.height()+SPACEy+1);

        return text;
    }

}
