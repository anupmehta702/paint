package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.exception.OutOfBoundaryBaseException;
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

    static void checkCoordinatesForOutOfBoundaryCondition(Coordinates start, Coordinates end, Canvas canvas) throws OutOfBoundaryBaseException {
        int maxX = start.getRow() > end.getRow() ? start.getRow() : end.getRow();
        int maxY = start.getColumn() > end.getColumn() ? start.getColumn() : end.getColumn();
        if(maxX > canvas.getHeight() || maxY > canvas.getWidth()){
            throw new OutOfBoundaryBaseException("Coordinates are out of canvas boundary");
        }
    }


}
