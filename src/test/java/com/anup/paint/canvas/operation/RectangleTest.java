package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RectangleTest {
    private Canvas inputCanvas;
    private Character[][] expectedDrawingArea;
    private Rectangle rectangle;

    @Before
    public void setup() {
        inputCanvas = new Canvas(4, 4);
        rectangle = new Rectangle();
        expectedDrawingArea = inputCanvas.getClonedDrawingArea();
    }

    @Test
    public void executeTest()  {
        InputCommand rectInput = new InputCommand(CommandType.RECTANGLE,
                new Coordinates(1, 1), new Coordinates(3, 4));
        rectangle.execute(rectInput, inputCanvas);
        createCustomRectangle();

        assertArrayEquals(expectedDrawingArea, inputCanvas.getClonedDrawingArea());
        inputCanvas.print();
    }


    @Test
    public void executeMethodForOverlappingRectangleTest()  {
        InputCommand rectInput = new InputCommand(CommandType.RECTANGLE,
                new Coordinates(1, 1), new Coordinates(3, 4));
        rectangle.execute(rectInput, inputCanvas);

        createCustomRectangle();

        InputCommand rectInput2 = new InputCommand(CommandType.RECTANGLE,
                new Coordinates(1, 1), new Coordinates(4, 4));
        rectangle.execute(rectInput2, inputCanvas);

        //horizontal lines
        expectedDrawingArea[4][1] = 'x';
        expectedDrawingArea[4][2] = 'x';
        expectedDrawingArea[4][3] = 'x';
        expectedDrawingArea[4][4] = 'x';

        assertArrayEquals(expectedDrawingArea, inputCanvas.getClonedDrawingArea());
        inputCanvas.print();
    }



    private void createCustomRectangle() {
        //horizontal lines
        expectedDrawingArea[1][1] = 'x';
        expectedDrawingArea[1][2] = 'x';
        expectedDrawingArea[1][3] = 'x';
        expectedDrawingArea[1][4] = 'x';
        expectedDrawingArea[3][1] = 'x';
        expectedDrawingArea[3][2] = 'x';
        expectedDrawingArea[3][3] = 'x';
        expectedDrawingArea[3][4] = 'x';
        //vertical lines
        expectedDrawingArea[2][1] = 'x';
        expectedDrawingArea[3][1] = 'x';
        expectedDrawingArea[2][4] = 'x';
        expectedDrawingArea[3][4] = 'x';
    }
}