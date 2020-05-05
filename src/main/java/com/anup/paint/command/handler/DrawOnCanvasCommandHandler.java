package com.anup.paint.command.handler;

import com.anup.paint.command.InputCommand;
import com.anup.paint.command.exception.InputCommandException;
import com.anup.paint.draw.CanvasOperation;
import com.anup.paint.draw.CanvasOperationObjectFactory;
import com.anup.paint.draw.exception.DrawException;

public class DrawOnCanvasCommandHandler {
    private CanvasOperationObjectFactory canvasOperationObjectFactory;

    public DrawOnCanvasCommandHandler(CanvasOperationObjectFactory canvasOperationObjectFactory) {
        this.canvasOperationObjectFactory = canvasOperationObjectFactory;
    }

    public void executeCommand(InputCommand input, char[][] canvas) throws DrawException, InputCommandException {
        CanvasOperation canvasOperation = canvasOperationObjectFactory.getCanvasOperationObject(input);
        canvasOperation.execute(input, canvas);

    }


}
