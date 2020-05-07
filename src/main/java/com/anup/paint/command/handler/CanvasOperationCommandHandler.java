package com.anup.paint.command.handler;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.exception.OutOfBoundaryBaseException;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.exception.InputCommandBaseException;
import com.anup.paint.canvas.operation.CanvasOperation;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;

public class CanvasOperationCommandHandler {
    private CanvasOperationObjectFactory canvasOperationObjectFactory;

    public CanvasOperationCommandHandler(CanvasOperationObjectFactory canvasOperationObjectFactory) {
        this.canvasOperationObjectFactory = canvasOperationObjectFactory;
    }

    public void executeCommand(InputCommand input, Canvas canvas) throws CanvasOperationBaseException, InputCommandBaseException {
        checkCoordinatesForOutOfBoundaryCondition(input, canvas);
        CanvasOperation canvasOperation = canvasOperationObjectFactory.getCanvasOperationObject(input);
        canvasOperation.execute(input, canvas);
    }

    private void checkCoordinatesForOutOfBoundaryCondition(InputCommand input, Canvas canvas) throws OutOfBoundaryBaseException {
        Coordinates start = input.getStart();
        Coordinates end = input.getEnd();
        int maxX = start.getX();
        int maxY = start.getY();
        if (end != null) {
            maxX = start.getX() > end.getX() ? start.getX() : end.getX();
            maxY = start.getY() > end.getY() ? start.getY() : end.getY();
        }
        if (maxX > canvas.getWidth() || maxY > canvas.getHeight()) {
            throw new OutOfBoundaryBaseException("Coordinates are out of canvas boundary");
        }
        /*if (maxX > canvas.getHeight() || maxY > canvas.getWidth()) {
            throw new OutOfBoundaryBaseException("Coordinates are out of canvas boundary");
        }*/
    }

}
