package com.anup.paint.command.exception;

import com.anup.paint.command.model.InputCommand;

public class CommandTypeNotSupportedException extends InputCommandException{
    public CommandTypeNotSupportedException(InputCommand input) {
        super("Command type - "+input.getCommandType()+" not supported ");
    }
}
