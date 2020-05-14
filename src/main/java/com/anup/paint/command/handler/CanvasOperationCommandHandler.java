package com.anup.paint.command.handler;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;
import com.anup.paint.canvas.operation.CanvasOperation;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;
import com.anup.paint.command.exception.InputCommandBaseException;
import com.anup.paint.command.model.InputCommand;

public class CanvasOperationCommandHandler {
    private CanvasOperationObjectFactory canvasOperationObjectFactory;

    public CanvasOperationCommandHandler(CanvasOperationObjectFactory canvasOperationObjectFactory) {
        this.canvasOperationObjectFactory = canvasOperationObjectFactory;
    }

    public void executeCommand(InputCommand input, Canvas canvas) throws CanvasOperationBaseException, InputCommandBaseException {
        CanvasOperation canvasOperation = canvasOperationObjectFactory.getCanvasOperationObject(input);
        canvasOperation.execute(input, canvas);
    }


}
