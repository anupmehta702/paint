package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.OutOfBoundaryException;
import com.anup.paint.command.model.Coordinates;

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

    static void checkCoordinatesForOutOfBoundaryCondition(Coordinates start, Coordinates end, Canvas canvas) throws OutOfBoundaryException {
        int maxX = start.getX() > end.getX() ? start.getX() : end.getX();
        int maxY = start.getY() > end.getY() ? start.getY() : end.getY();
        if(maxX > canvas.getHeight() || maxY > canvas.getWidth()){
            throw new OutOfBoundaryException("Coordinates are out of canvas boundary");
        }
    }


}
