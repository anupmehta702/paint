package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;

import static com.anup.paint.canvas.operation.CanvasLineHelper.drawHorizontalLine;
import static com.anup.paint.canvas.operation.CanvasLineHelper.drawVerticalLine;

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
        drawVerticalLine(start.getRow(),start.getColumn(),end.getRow(),input.getMarker(),clonedDrawingArea);
        drawVerticalLine(start.getRow(),end.getColumn(),end.getRow(),input.getMarker(),clonedDrawingArea);
    }


    private void drawHorizontalLines(InputCommand input, Character[][] clonedDrawingArea) {
        Coordinates start = input.getStart();
        Coordinates end = input.getEnd();
        drawHorizontalLine(start.getRow(),start.getColumn(),end.getColumn(),input.getMarker(),clonedDrawingArea);
        drawHorizontalLine(end.getRow(),start.getColumn(),end.getColumn(),input.getMarker(),clonedDrawingArea);
    }


}
