package com.anup.paint.command.model;

import java.util.Objects;

public final class InputCommand {

    private final Coordinates start;
    private final Coordinates end;
    private final CommandType commandType;
    private char marker = 'x';

    public InputCommand(CommandType commandType, Coordinates start, Coordinates end) {
        this.start = start;
        this.end = end;
        this.commandType = commandType;
    }

    public InputCommand(CommandType commandType, Coordinates start, Coordinates end,char marker) {
        this.start = start;
        this.end = end;
        this.commandType = commandType;
        this.marker = marker;
    }
    public InputCommand(CommandType commandType, Coordinates start, char marker) {
        this.start = start;
        this.commandType = commandType;
        this.marker = marker;
        this.end = null;
    }

    public InputCommand(CommandType commandType, Coordinates start) {
        this.start = start;
        this.commandType = commandType;
        this.end = null;

    }

    public CommandType getCommandType() {
        return commandType;
    }

    public Coordinates getStart() {
        return start;
    }

    public Coordinates getEnd() {
        return end;
    }

    public char getMarker() {
        return marker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputCommand that = (InputCommand) o;
        return marker == that.marker &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                commandType == that.commandType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, commandType, marker);
    }
}
