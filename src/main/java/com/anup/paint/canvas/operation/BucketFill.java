package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;

public class BucketFill implements CanvasOperation {
    @Override
    public void execute(InputCommand input, Canvas canvas) {
        Character[][] clonedDrawingArea = canvas.getClonedDrawingArea();
        Coordinates start = input.getStart();
        fillColor(start.getRow(), start.getColumn(), clonedDrawingArea, input.getMarker());
        canvas.mergeDrawingChanges(clonedDrawingArea);
    }

    private void fillColor(int row, int column, Character[][] clonedDrawingArea, Character marker) {
        if (row > clonedDrawingArea.length - 2 || column > clonedDrawingArea[0].length - 2)
            return;
        if (row <= 0 || column <= 0)
            return;
        if (clonedDrawingArea[row][column] != ' ')
            return;
        clonedDrawingArea[row][column] = marker;
        fillColor(row + 1, column, clonedDrawingArea, marker);//bottom
        fillColor(row - 1, column, clonedDrawingArea, marker);//top
        fillColor(row, column + 1, clonedDrawingArea, marker);//right
        fillColor(row, column - 1, clonedDrawingArea, marker);//left

    }
}
