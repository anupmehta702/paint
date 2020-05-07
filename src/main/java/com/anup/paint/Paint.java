package com.anup.paint;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.exception.NoCanvasCreatedException;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.handler.CanvasOperationCommandHandler;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;

public class Paint {

    private Canvas canvas;
    private CanvasOperationCommandHandler canvasCommandHandler = new CanvasOperationCommandHandler(new CanvasOperationObjectFactory());

    public Paint() {

    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public void print() {
        this.canvas.print();
    }


    public void executeInputCommand(InputCommand input) throws NoCanvasCreatedException {
        if (input.getCommandType().equals(CommandType.CANVAS)) {
            this.canvas = new Canvas(input.getStart().getX(), input.getStart().getY());
        } else {
            executeCanvasCommand(input);
        }
        print();
    }

    private void executeCanvasCommand(InputCommand input) throws NoCanvasCreatedException {
        if (this.canvas == null) {
            throw new NoCanvasCreatedException("CANVAS not created. Cannot perform any operation without canvas");
        }
        try {
            canvasCommandHandler.executeCommand(input, canvas);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
