package com.anup.paint.draw;

import com.anup.paint.CreateCanvasHelper;
import com.anup.paint.command.CommandType;
import com.anup.paint.command.Coordinates;
import com.anup.paint.command.InputCommand;
import com.anup.paint.draw.exception.DiagonalLineNotAllowedException;
import com.anup.paint.draw.exception.DrawException;
import org.junit.Before;
import org.junit.Test;

import static com.anup.paint.CreateCanvasHelper.printCanvas;
import static org.junit.Assert.*;

import static com.anup.paint.CreateCanvasHelper.createNewCanvas;

public class LineTest {
    char[][] inputCanvas;
    char[][] expectedCanvas;
    Line line;

    @Before
    public void setup() {
        inputCanvas = createNewCanvas();
        line = new Line();
        expectedCanvas = createNewCanvas();
    }

    @Test
    public void executeMethodTestForHorizontalLine() throws DrawException {
        InputCommand cmdForHorizontalLine = new InputCommand(CommandType.LINE,
                new Coordinates(2, 2), new Coordinates(2, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

        expectedCanvas[2][2] = 'x';
        expectedCanvas[2][3] = 'x';
        expectedCanvas[2][4] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas);
        printCanvas(inputCanvas);

    }


    @Test
    public void executeMethodTestForVerticalLine() throws DrawException {
        InputCommand cmdForVerticalLine = new InputCommand(CommandType.LINE,
                new Coordinates(1, 2), new Coordinates(3, 2));
        line.execute(cmdForVerticalLine, inputCanvas);

        expectedCanvas[1][2] = 'x';expectedCanvas[2][2] = 'x';expectedCanvas[3][2] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas);
        printCanvas(inputCanvas);

    }

    @Test
    public void executeMethodTestForOverlappingLine() throws DrawException {
        InputCommand cmdForHorizontalLine = new InputCommand(CommandType.LINE,
                new Coordinates(2, 2), new Coordinates(2, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

        expectedCanvas[2][2] = 'x';expectedCanvas[2][3] = 'x';expectedCanvas[2][4] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas);

        InputCommand cmdForVerticalLine = new InputCommand(CommandType.LINE,
                new Coordinates(1, 2), new Coordinates(3, 2));
        line.execute(cmdForVerticalLine, inputCanvas);

        expectedCanvas[1][2] = 'x';expectedCanvas[2][2] = 'x';expectedCanvas[3][2] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas);
        printCanvas(inputCanvas);

    }


    @Test(expected = DiagonalLineNotAllowedException.class)
    public void executeMethodTestForDiagonalLine() throws DrawException {
        InputCommand cmdForHorizontalLine = new InputCommand(CommandType.LINE,
                new Coordinates(2, 1), new Coordinates(3, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

    }

    @Test
    public void executeMethodTestForOutOfCanvasBoundaryCoordinates() {

    }
}