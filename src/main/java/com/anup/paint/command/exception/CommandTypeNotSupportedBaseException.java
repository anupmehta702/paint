package com.anup.paint.command.exception;

import com.anup.paint.command.model.InputCommand;

public class CommandTypeNotSupportedBaseException extends InputCommandBaseException {
    public CommandTypeNotSupportedBaseException(InputCommand input) {
        super("Command type - "+input.getCommandType()+" not supported ");
    }
    public CommandTypeNotSupportedBaseException(String s) {
        super(s);
    }
}
