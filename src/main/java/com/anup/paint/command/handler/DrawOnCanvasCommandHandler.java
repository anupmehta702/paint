package com.anup.paint.command.handler;

import com.anup.paint.command.InputCommand;
import com.anup.paint.command.exception.InputCommandException;
import com.anup.paint.draw.Draw;
import com.anup.paint.draw.DrawObjectFactory;
import com.anup.paint.command.exception.CommandTypeNotSupportedException;
import com.anup.paint.draw.exception.DrawException;

public class DrawOnCanvasCommandHandler {
    private DrawObjectFactory drawObjectFactory;

    public DrawOnCanvasCommandHandler(DrawObjectFactory drawObjectFactory) {
        this.drawObjectFactory = drawObjectFactory;
    }

    public void executeCommand(InputCommand input, char[][] canvas) throws DrawException, InputCommandException {
        Draw draw = drawObjectFactory.getDrawObject(input);
        draw.execute(input, canvas);

    }


}
