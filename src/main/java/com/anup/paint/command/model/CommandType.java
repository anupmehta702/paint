package com.anup.paint.command.model;

public enum CommandType {
    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET_FILL("B");
    private String commandString;

    CommandType(String commandString) {
        this.commandString = commandString;
    }
}
