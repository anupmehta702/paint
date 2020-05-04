package com.anup.paint.draw;

import com.anup.paint.command.InputCommand;

public interface Draw {
    public char[][] execute(InputCommand input, char[][] canvas);
}
