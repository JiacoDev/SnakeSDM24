package com.sdm;

public class Dimension {


    private final int boardStartingWidth = 32;
    private final int boardStartingHeight = 32;
    private final int dim = 15;

    public Dimension() {
    }

    public double getWindow_X() {
        return (((boardStartingWidth + 2 + Graphic.SPACEx * 2) / 7) * 9) * dim;
    }
    public double getWindow_Y() {
        return ((((boardStartingHeight + 2 + Graphic.SPACEy * 2) / 5) * 9)) * dim;
    }
    public int getBoardStartingWidth() {
        return boardStartingWidth;
    }
    public int getBoardStartingHeight() {
        return boardStartingHeight;
    }
    public int getDim() {
        return dim;
    }

}
