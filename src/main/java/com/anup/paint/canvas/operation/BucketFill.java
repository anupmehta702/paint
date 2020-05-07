package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;

public class BucketFill implements CanvasOperation {
    @Override
    public void execute(InputCommand input, Canvas canvas) {
        Character[][] clonedDrawingArea = canvas.getClonedDrawingArea();
        Coordinates start = input.getStart();
        fillColor(start.getX(), start.getY(), clonedDrawingArea, input.getMarker());
        canvas.mergeDrawingChanges(clonedDrawingArea);
    }

    private void fillColor(int x, int y, Character[][] clonedDrawingArea, Character marker) {
        if (x > clonedDrawingArea.length - 2 || y > clonedDrawingArea[0].length - 2)
            return;
        if (x <= 0 || y <= 0)
            return;
        if (clonedDrawingArea[x][y] != ' ')
            return;
        clonedDrawingArea[x][y] = marker;
        fillColor(x + 1, y, clonedDrawingArea, marker);//bottom
        fillColor(x - 1, y, clonedDrawingArea, marker);//top
        fillColor(x, y + 1, clonedDrawingArea, marker);//right
        fillColor(x, y - 1, clonedDrawingArea, marker);//left

    }
}
