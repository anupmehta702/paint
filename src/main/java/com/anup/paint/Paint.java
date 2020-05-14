package com.anup.paint;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;
import com.anup.paint.command.exception.InputCommandBaseException;
import com.anup.paint.command.exception.InsufficientInputException;
import com.anup.paint.command.exception.NoCanvasCreatedException;
import com.anup.paint.command.exception.OutOfBoundaryBaseException;
import com.anup.paint.command.handler.CanvasOperationCommandHandler;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;

public class Paint {

    private Canvas canvas;
    private CanvasOperationCommandHandler canvasCommandHandler = new CanvasOperationCommandHandler(new CanvasOperationObjectFactory());

    public Canvas getCanvas() {
        return this.canvas;
    }

    private void print() {
        this.canvas.print();
    }


    public void executeInputCommand(InputCommand input) throws InputCommandBaseException {
        validateInputCommand(input);

        if (input.getCommandType().equals(CommandType.CANVAS)) {
            this.canvas = new Canvas(input.getStart().getRow(), input.getStart().getColumn());
        } else {
            executeCanvasCommand(input);
        }
        print();
    }

    private void executeCanvasCommand(InputCommand input) throws NoCanvasCreatedException {
        if (this.canvas == null) {
            throw new NoCanvasCreatedException("CANVAS not created. Cannot perform any operation without canvas");
        }
        try {
            canvasCommandHandler.executeCommand(input, canvas);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void validateInputCommand(InputCommand input) throws InputCommandBaseException {
        if(input == null ){
            throw new InsufficientInputException("input command cannot be null");
        }
        if(canvas != null) {
            checkCoordinatesForOutOfBoundaryCondition(input, canvas);
        }
    }

    private void checkCoordinatesForOutOfBoundaryCondition(InputCommand input, Canvas canvas) throws OutOfBoundaryBaseException {
        Coordinates start = input.getStart();
        Coordinates end = input.getEnd();
        int maxX = start.getRow();
        int maxY = start.getColumn();
        if (end != null) {
            maxX = start.getRow() > end.getRow() ? start.getRow() : end.getRow();
            maxY = start.getColumn() > end.getColumn() ? start.getColumn() : end.getColumn();
        }
        if (maxX > canvas.getWidth() || maxY > canvas.getHeight()) {
            throw new OutOfBoundaryBaseException("Coordinates are out of canvas boundary");
        }

    }
}
