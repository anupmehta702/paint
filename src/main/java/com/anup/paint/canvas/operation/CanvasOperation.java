package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;

public interface CanvasOperation {
    public void execute(InputCommand input, Canvas canvas) throws CanvasOperationBaseException;
}
