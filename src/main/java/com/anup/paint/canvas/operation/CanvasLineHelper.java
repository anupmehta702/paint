package com.anup.paint.canvas.operation;

public class CanvasLineHelper {
     static void drawVerticalLine(int x ,int y,int x1,char marker, Character[][] clonedDrawingArea) {
        for (int i = x; i <= x1; i++) {
            clonedDrawingArea[i][y] = marker;
        }
    }
     static void drawHorizontalLine(int x, int y, int y1,char marker, Character[][] clonedDrawingArea) {
        for (int i = y; i <= y1; i++) {
            clonedDrawingArea[x][i] = marker;
        }
    }


}
