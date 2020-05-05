package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.DiagonalLineNotAllowedException;
import com.anup.paint.canvas.exception.DrawException;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;

import static com.anup.paint.CreateCanvasHelper.printCanvas;
import static com.anup.paint.command.model.CommandType.LINE;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LineTest {
    Canvas inputCanvas;
    char[][] expectedCanvas;
    Line line;

    @Before
    public void setup() {
        inputCanvas = new Canvas(4,4);
        line = new Line();
        expectedCanvas = inputCanvas.getClonedDrawingArea();
    }

    @Test
    public void executeMethodTestForHorizontalLine() throws DrawException {
        InputCommand cmdForHorizontalLine = new InputCommand(LINE,
                new Coordinates(2, 2), new Coordinates(2, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

        expectedCanvas[2][2] = 'x';expectedCanvas[2][3] = 'x';expectedCanvas[2][4] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas.getClonedDrawingArea());
        printCanvas(inputCanvas.getClonedDrawingArea());

    }


    @Test
    public void executeMethodTestForVerticalLine() throws DrawException {
        InputCommand cmdForVerticalLine = new InputCommand(LINE,
                new Coordinates(1, 2), new Coordinates(3, 2));
        line.execute(cmdForVerticalLine, inputCanvas);

        expectedCanvas[1][2] = 'x';expectedCanvas[2][2] = 'x';expectedCanvas[3][2] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas.getClonedDrawingArea());
        inputCanvas.print();

    }

    @Test
    public void executeMethodTestForOverlappingLine() throws DrawException {
        InputCommand cmdForHorizontalLine = new InputCommand(LINE,
                new Coordinates(2, 2), new Coordinates(2, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

        expectedCanvas[2][2] = 'x';expectedCanvas[2][3] = 'x';expectedCanvas[2][4] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas.getClonedDrawingArea());

        InputCommand cmdForVerticalLine = new InputCommand(LINE,
                new Coordinates(1, 2), new Coordinates(3, 2));
        line.execute(cmdForVerticalLine, inputCanvas);

        expectedCanvas[1][2] = 'x';expectedCanvas[2][2] = 'x';expectedCanvas[3][2] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas.getClonedDrawingArea());
        inputCanvas.print();

    }


    @Test(expected = DiagonalLineNotAllowedException.class)
    public void executeMethodTestForDiagonalLine() throws DrawException {
        InputCommand cmdForHorizontalLine = new InputCommand(LINE,
                new Coordinates(2, 1), new Coordinates(3, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

    }

    @Test
    public void executeMethodTestForOutOfCanvasBoundaryCoordinates() {
       //TODO
    }
}