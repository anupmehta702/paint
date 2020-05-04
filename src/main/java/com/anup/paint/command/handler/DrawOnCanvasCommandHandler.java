package com.anup.paint.command.handler;

import com.anup.paint.command.InputCommand;
import com.anup.paint.draw.Draw;
import com.anup.paint.draw.DrawObjectFactory;
import com.anup.paint.draw.exception.NotSupportedCommandType;

public class DrawOnCanvasCommandHandler {
    private DrawObjectFactory drawObjectFactory = new DrawObjectFactory();

    public DrawOnCanvasCommandHandler(DrawObjectFactory drawObjectFactory) {
        this.drawObjectFactory = drawObjectFactory;
    }

    public void executeCommand(InputCommand input, char[][] canvas) {
        try {
            Draw draw = drawObjectFactory.getDrawObject(input);
            draw.execute(input,canvas);
        } catch (NotSupportedCommandType notSupportedCommandType) {
            notSupportedCommandType.printStackTrace();
        }
    }


}
