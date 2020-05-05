package com.anup.paint.canvas.operation;

import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.exception.CommandTypeNotSupportedException;

public class CanvasOperationObjectFactory {
    public CanvasOperation getCanvasOperationObject(InputCommand input) throws CommandTypeNotSupportedException {
        if(CommandType.LINE == input.getCommandType() ){
            return new Line();
        }else if (CommandType.RECTANGLE == input.getCommandType() ){
            return new Rectangle();
        }
        throw new CommandTypeNotSupportedException(input);

    }
}
