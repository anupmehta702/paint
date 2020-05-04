package com.anup.paint.command;

public final class InputCommand {

    private final Coordinates start;
    private Coordinates end;
    private final CommandType commandType;
    private char marker = 'x';

    public InputCommand(CommandType commandType, Coordinates start, Coordinates end) {
        this.start = start;
        this.end = end;
        this.commandType = commandType;
    }

    public InputCommand(CommandType commandType, Coordinates start, char marker) {
        this.start = start;
        this.commandType = commandType;
        this.marker = marker;
    }

    public InputCommand(CommandType commandType, Coordinates start) {
        this.start = start;
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InputCommand that = (InputCommand) o;

        if (marker != that.marker) return false;
        if (!start.equals(that.start)) return false;
        if (!end.equals(that.end)) return false;
        return commandType == that.commandType;
    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        result = 31 * result + commandType.hashCode();
        result = 31 * result + (int) marker;
        return result;
    }
}
