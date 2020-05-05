package com.anup.paint.canvas.operation;

import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.exception.CommandTypeNotSupportedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasOperationObjectFactoryTest {

    CanvasOperationObjectFactory objectFactory = new CanvasOperationObjectFactory();

    @Test
    public void getDrawObjectTest() throws CommandTypeNotSupportedException {
        InputCommand input_one = new InputCommand(CommandType.LINE, new Coordinates(1, 2), new Coordinates(1, 3));
        CanvasOperation canvasOperationObj = objectFactory.getCanvasOperationObject(input_one);
        assertTrue(canvasOperationObj instanceof Line);

        InputCommand input_two = new InputCommand(CommandType.RECTANGLE, new Coordinates(1, 2), new Coordinates(1, 3));
        canvasOperationObj = objectFactory.getCanvasOperationObject(input_two);
        assertTrue(canvasOperationObj instanceof Rectangle);

        InputCommand input_three = new InputCommand(CommandType.BUCKET_FILL, new Coordinates(1, 2), 'c');
        canvasOperationObj = objectFactory.getCanvasOperationObject(input_three);
        assertTrue(canvasOperationObj instanceof BucketFill);
    }

    @Test(expected = CommandTypeNotSupportedException.class)
    public void exceptionHandlingForGetObjectMethodTest() throws CommandTypeNotSupportedException {
        InputCommand input_one = new InputCommand(CommandType.CANVAS, new Coordinates(1, 2));
        CanvasOperation canvasOperationObj = objectFactory.getCanvasOperationObject(input_one);
    }


}
