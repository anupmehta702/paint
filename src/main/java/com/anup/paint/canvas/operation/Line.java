package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;
import com.anup.paint.canvas.exception.DiagonalLineNotAllowedException;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;

import static com.anup.paint.canvas.operation.CanvasLineHelper.drawHorizontalLine;
import static com.anup.paint.canvas.operation.CanvasLineHelper.drawVerticalLine;

public class Line implements CanvasOperation {

    @Override
    public void execute(InputCommand input, Canvas canvas) throws CanvasOperationBaseException {
        Character[][] clonedDrawingArea = canvas.getClonedDrawingArea();
        Coordinates start = input.getStart();
        Coordinates end = input.getEnd();
        if (isLineToDrawHorizontal(input)) {
            drawHorizontalLine(start.getX(),start.getY(),end.getY(),input.getMarker(),clonedDrawingArea);
        } else if (isLineToDrawVertical(input)) {
            drawVerticalLine(start.getX(),start.getY(),end.getX(),input.getMarker(),clonedDrawingArea);
        }else{
            throw new DiagonalLineNotAllowedException("diagonal line not allowed ");
        }
        canvas.mergeDrawingChanges(clonedDrawingArea);
    }

    private boolean isLineToDrawHorizontal(InputCommand input) {
        return input.getStart().getX() == input.getEnd().getX();
    }

    private boolean isLineToDrawVertical(InputCommand input) {
        return input.getStart().getY() == input.getEnd().getY();
    }


}
