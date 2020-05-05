package com.anup.paint.command.handler;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.exception.InputCommandException;
import com.anup.paint.canvas.operation.CanvasOperation;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;

public class DrawOnCanvasCommandHandler {
    private CanvasOperationObjectFactory canvasOperationObjectFactory;

    public DrawOnCanvasCommandHandler(CanvasOperationObjectFactory canvasOperationObjectFactory) {
        this.canvasOperationObjectFactory = canvasOperationObjectFactory;
    }

    public void executeCommand(InputCommand input, Canvas canvas) throws CanvasOperationBaseException, InputCommandException {
        CanvasOperation canvasOperation = canvasOperationObjectFactory.getCanvasOperationObject(input);
        canvasOperation.execute(input, canvas);

    }


}
