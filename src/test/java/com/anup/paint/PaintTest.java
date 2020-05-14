package com.anup.paint;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;
import com.anup.paint.command.exception.InputCommandBaseException;
import com.anup.paint.command.exception.InsufficientInputException;
import com.anup.paint.command.exception.NoCanvasCreatedException;
import com.anup.paint.command.exception.OutOfBoundaryBaseException;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;

import static com.anup.paint.command.model.CommandType.LINE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;


public class PaintTest {

    private Paint paint;
    private int width = 4;
    private int height = 4 ;

    @Before
    public void setup(){
        paint = new Paint();
    }

    @Test
    public void createCanvasTest() throws InputCommandBaseException {
        InputCommand createCanvasCommand = new InputCommand(CommandType.CANVAS,new Coordinates(width,height));
        paint.executeInputCommand(createCanvasCommand);
        assertNotNull(paint.getCanvas());
    }

    @Test
    public void executeCommandTest() throws InputCommandBaseException {
        InputCommand createCanvasCommand = new InputCommand(CommandType.CANVAS,new Coordinates(width,height));
        paint.executeInputCommand(createCanvasCommand);

        InputCommand drawLineCommand = new InputCommand(CommandType.LINE,new Coordinates(2,2),new Coordinates(2,4));
        paint.executeInputCommand(drawLineCommand);

        Canvas expectedCanvas = new Canvas(width,height);
        Character[][] drawingArea = expectedCanvas.getClonedDrawingArea();
        drawingArea[2][2] = 'x';drawingArea[2][3] = 'x';drawingArea[2][4] = 'x';

        assertArrayEquals(drawingArea,paint.getCanvas().getClonedDrawingArea());
    }

    @Test(expected = NoCanvasCreatedException.class)
    public void executeCommandTestWithoutCanvas() throws InputCommandBaseException {
        InputCommand drawLineCommand = new InputCommand(CommandType.LINE,new Coordinates(2,2),new Coordinates(2,4));
        paint.executeInputCommand(drawLineCommand);
    }

    @Test(expected = InsufficientInputException.class)
    public void executeCommandTestWithIncorrectInput() throws InputCommandBaseException {
        paint.executeInputCommand(null);
    }

    @Test(expected = OutOfBoundaryBaseException.class)
    public void executeMethodTestForOutOfCanvasBoundaryCoordinates() throws InputCommandBaseException {
        InputCommand createCanvasCommand = new InputCommand(CommandType.CANVAS,new Coordinates(width,height));
        paint.executeInputCommand(createCanvasCommand);

        InputCommand cmdForHorizontalLine = new InputCommand(LINE,
                new Coordinates(1, 1), new Coordinates(10, 4));
        paint.executeInputCommand(cmdForHorizontalLine);

    }

}