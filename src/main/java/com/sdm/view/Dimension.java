package com.sdm.view;

public class Dimension {


    private static int boardStartingWidth;
    private static int boardStartingHeight;
    private static final int squareDimension = 15;

    public static double getWindow_X() {
        return (((boardStartingWidth + 2 + Graphic.SPACEx * 2) / 7) * 9) * squareDimension;
    }
    public static double getWindow_Y() {
        return ((((boardStartingHeight + 2 + Graphic.SPACEy * 2) / 5) * 9)) * squareDimension;
    }
    public static void setDimension(int width, int height){
        boardStartingWidth = width;
        boardStartingHeight = height;
    }
    public static double scale(double val) {
        return val * squareDimension;
    }

}
