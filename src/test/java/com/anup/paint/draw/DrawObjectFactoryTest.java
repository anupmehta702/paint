package com.anup.paint.draw;

import com.anup.paint.command.CommandType;
import com.anup.paint.command.Coordinates;
import com.anup.paint.command.InputCommand;
import com.anup.paint.draw.exception.NotSupportedCommandType;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawObjectFactoryTest {

    DrawObjectFactory objectFactory = new DrawObjectFactory();

    @Test
    public void getDrawObjectTest() throws NotSupportedCommandType {
        InputCommand input_one = new InputCommand(CommandType.LINE, new Coordinates(1, 2), new Coordinates(1, 3));
        Draw drawObj = objectFactory.getDrawObject(input_one);
        assertTrue(drawObj instanceof Line);

        InputCommand input_two = new InputCommand(CommandType.RECTANGLE, new Coordinates(1, 2), new Coordinates(1, 3));
        drawObj = objectFactory.getDrawObject(input_two);
        assertTrue(drawObj instanceof Rectangle);

        InputCommand input_three = new InputCommand(CommandType.BUCKET_FILL, new Coordinates(1, 2), 'c');
        drawObj = objectFactory.getDrawObject(input_three);
        assertTrue(drawObj instanceof BucketFill);
    }

    @Test(expected = NotSupportedCommandType.class)
    public void exceptionHandlingForGetObjectMethodTest() throws NotSupportedCommandType {
        InputCommand input_one = new InputCommand(CommandType.CANVAS, new Coordinates(1, 2));
        Draw drawObj = objectFactory.getDrawObject(input_one);
    }


}
