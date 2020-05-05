package com.anup.paint.canvas.operation;

import com.anup.paint.command.model.InputCommand;
import com.anup.paint.canvas.exception.DrawException;

public interface CanvasOperation {
    public char[][] execute(InputCommand input, char[][] canvas) throws DrawException;
}
