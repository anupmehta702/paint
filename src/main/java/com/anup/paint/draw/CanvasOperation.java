package com.anup.paint.draw;

import com.anup.paint.command.InputCommand;
import com.anup.paint.draw.exception.DrawException;

public interface CanvasOperation {
    public char[][] execute(InputCommand input, char[][] canvas) throws DrawException;
}
