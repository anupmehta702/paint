package com.anup.paint.canvas.operation;

import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.exception.CommandTypeNotSupportedBaseException;

public class CanvasOperationObjectFactory {
    public CanvasOperation getCanvasOperationObject(InputCommand input) throws CommandTypeNotSupportedBaseException {
        if(CommandType.LINE == input.getCommandType() ){
            return new Line();
        }else if (CommandType.RECTANGLE == input.getCommandType() ){
            return new Rectangle();
        }else if (CommandType.BUCKET_FILL == input.getCommandType() ){
            return new BucketFill();
        }
        throw new CommandTypeNotSupportedBaseException(input);

    }
}
