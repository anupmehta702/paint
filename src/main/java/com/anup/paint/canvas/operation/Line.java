package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.canvas.exception.DiagonalLineNotAllowedException;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;

public class Line implements CanvasOperation {

    @Override
    public void execute(InputCommand input, Canvas canvas) throws CanvasOperationBaseException {
        Character[][] initialDrawingArea = canvas.getClonedDrawingArea();
        if (isLineToDrawHorizontal(input)) {
            drawHorizontalLine(input, initialDrawingArea);
        } else if (isLineToDrawVertical(input)) {
            drawVerticalLine(input, initialDrawingArea);
        }else{
            throw new DiagonalLineNotAllowedException("diagonal line not allowed ");
        }
        canvas.mergeDrawingChanges(initialDrawingArea);
    }

    private void drawVerticalLine(InputCommand input, Character[][] canvas) {
        for (int i = input.getStart().getX(); i <= input.getEnd().getX(); i++) {
            canvas[i][input.getStart().getY()] = input.getMarker();
        }
    }

    private boolean isLineToDrawHorizontal(InputCommand input) {
        return input.getStart().getX() == input.getEnd().getX();
    }

    private boolean isLineToDrawVertical(InputCommand input) {
        return input.getStart().getY() == input.getEnd().getY();
    }

    private void drawHorizontalLine(InputCommand input, Character[][] canvas) {
        for (int i = input.getStart().getY(); i <= input.getEnd().getY(); i++) {
            canvas[input.getStart().getX()][i] = input.getMarker();
        }
    }
}
