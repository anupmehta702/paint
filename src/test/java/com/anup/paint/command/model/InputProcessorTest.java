package com.anup.paint.command.model;

import com.anup.paint.command.exception.CommandTypeNotSupportedBaseException;
import com.anup.paint.command.exception.InputCommandBaseException;
import com.anup.paint.command.exception.InsufficientInputException;
import com.anup.paint.command.exception.InvalidInputDataException;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputProcessorTest {



    @Test
    public void convertInputToCommandForAllCommandsTest() throws InputCommandBaseException {
        InputCommand actualCanvasInputCommand = InputProcessor.convertInputToCommand("C 20 4");
        assertEquals(new InputCommand(CommandType.CANVAS,new Coordinates(4,20))
                ,actualCanvasInputCommand);

        InputCommand actualLineInputCommand = InputProcessor.convertInputToCommand("L 1 2 6 2");
        assertEquals(new InputCommand(CommandType.LINE,new Coordinates(2,1),new Coordinates(2,6))
                ,actualLineInputCommand);


        InputCommand actualBucketFillInputCommand = InputProcessor.convertInputToCommand("B 10 3 c ");
        assertEquals(new InputCommand(CommandType.BUCKET_FILL,new Coordinates(3,10),null,'c')
                ,actualBucketFillInputCommand);
    }

    @Test(expected = CommandTypeNotSupportedBaseException.class)
    public void convertInputToCommandForNotSupportedCommandsTest() throws InputCommandBaseException {
        InputProcessor.convertInputToCommand("X 20 4");
    }

    @Test(expected = InvalidInputDataException.class)
    public void convertInputToCommandForInvalidInputExceptionTest() throws InputCommandBaseException {
        InputProcessor.convertInputToCommand("C b2 4ce");
    }

    @Test(expected = InsufficientInputException.class)
    public void convertInputToCommandForInsufficientInputExceptionTest() throws InputCommandBaseException {
        InputProcessor.convertInputToCommand("B 10 3");
    }
}