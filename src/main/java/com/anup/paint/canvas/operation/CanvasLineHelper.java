package com.anup.paint.canvas.operation;

public class CanvasLineHelper {
    static void drawVerticalLine(int row, int column, int row1, char marker, Character[][] clonedDrawingArea) {
        for (int i = row; i <= row1; i++) {
            clonedDrawingArea[i][column] = marker;
        }
    }

    static void drawHorizontalLine(int row, int column, int column1, char marker, Character[][] clonedDrawingArea) {
        for (int i = column; i <= column1; i++) {
            clonedDrawingArea[row][i] = marker;
        }
    }


}
