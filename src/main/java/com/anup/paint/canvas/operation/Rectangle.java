package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;

public class Rectangle implements CanvasOperation {

    @Override
    public void execute(InputCommand input, Canvas canvas) {
        Character[][] clonedDrawingArea = canvas.getClonedDrawingArea();

        drawHorizontalLines(input, clonedDrawingArea);
        drawVerticalLines(input,clonedDrawingArea);

        canvas.mergeDrawingChanges(clonedDrawingArea);
    }

    private void drawVerticalLines(InputCommand input, Character[][] clonedDrawingArea) {
        Coordinates start = input.getStart();
        Coordinates end = input.getEnd();
        drawVerticalLine(start.getX(),start.getY(),end.getX(),input.getMarker(),clonedDrawingArea);
        drawVerticalLine(start.getX(),end.getY(),end.getX(),input.getMarker(),clonedDrawingArea);
    }


    private void drawHorizontalLines(InputCommand input, Character[][] clonedDrawingArea) {
        Coordinates start = input.getStart();
        Coordinates end = input.getEnd();
        drawHorizontalLine(start.getX(),start.getY(),end.getY(),input.getMarker(),clonedDrawingArea);
        drawHorizontalLine(end.getX(),start.getY(),end.getY(),input.getMarker(),clonedDrawingArea);
    }

    private void drawVerticalLine(int x ,int y,int x1,char marker, Character[][] clonedDrawingArea) {
        for (int i = x; i <= x1; i++) {
            clonedDrawingArea[i][y] = marker;
        }
    }
    private void drawHorizontalLine(int x, int y, int y1,char marker, Character[][] clonedDrawingArea) {
        for (int i = y; i <= y1; i++) {
            clonedDrawingArea[x][i] = marker;
        }
    }

}
