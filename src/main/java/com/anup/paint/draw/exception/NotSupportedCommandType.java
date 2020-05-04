package com.anup.paint.draw.exception;

import com.anup.paint.command.InputCommand;

public class NotSupportedCommandType extends Exception{
    public NotSupportedCommandType(InputCommand input) {
        super("Command type - "+input.getCommandType()+" not supported ");
    }
}
