package com.anup.paint.canvas.operation;

import com.anup.paint.command.model.InputCommand;

public class BucketFill implements CanvasOperation {
    @Override
    public char[][] execute(InputCommand input, char[][] canvas) {
        return new char[0][];
    }
}
