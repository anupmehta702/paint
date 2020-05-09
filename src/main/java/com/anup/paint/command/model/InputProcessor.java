package com.anup.paint.command.model;

import com.anup.paint.command.exception.CommandTypeNotSupportedBaseException;
import com.anup.paint.command.exception.InputCommandBaseException;
import com.anup.paint.command.exception.InsufficientInputException;
import com.anup.paint.command.exception.InvalidInputDataException;

import static com.anup.paint.command.model.CommandType.*;


//Note We are treating x as columns and y as rows

public class InputProcessor {

    public static InputCommand convertInputToCommand(String inputStr) throws InputCommandBaseException {
        String[] inputArr = inputStr.split(" ");
        CommandType commandType = getCommandTypeFrom(inputArr[0]);
        return getInputCommand(inputArr, commandType);
    }

    private static InputCommand getInputCommand(String[] inputArr, CommandType commandType) throws InsufficientInputException, InvalidInputDataException {
        if (inputArr.length != commandType.noOfInputParametersReq + 1) {
            throw new InsufficientInputException("Insufficient input for command - " + commandType);
        }

        Coordinates start = new Coordinates(getIntegerVal(inputArr[2]), getIntegerVal(inputArr[1]));
        Coordinates end = null;
        char marker = 'x';
        if (inputArr.length == 5) {
            end = new Coordinates(getIntegerVal(inputArr[4]), getIntegerVal(inputArr[3]));
        }
        if (inputArr.length == 4) {
            marker = inputArr[3].toCharArray()[0];
        }
        return new InputCommand(commandType, start, end, marker);
    }

    private static CommandType getCommandTypeFrom(String input) throws CommandTypeNotSupportedBaseException {
        CommandType commandType = fromString(input);
        if (commandType == null) {
            throw new CommandTypeNotSupportedBaseException("Command type -" + input + " not supported");
        }
        return commandType;
    }


    private static int getIntegerVal(String input) throws InvalidInputDataException {
        if (input.matches("[0-9]*")) {
            return Integer.parseInt(input);
        } else {
            throw new InvalidInputDataException("Invalid data type .(Expected number )");
        }
    }
}
