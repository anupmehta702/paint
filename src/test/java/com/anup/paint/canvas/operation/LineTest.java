package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;
import com.anup.paint.canvas.exception.DiagonalLineNotAllowedException;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;

import static com.anup.paint.command.model.CommandType.LINE;
import static org.junit.Assert.assertArrayEquals;

public class LineTest {
    private Canvas inputCanvas;
    private Character[][] expectedCanvas;
    private Line line;

    @Before
    public void setup() {
        inputCanvas = new Canvas(4,4);
        line = new Line();
        expectedCanvas = new Canvas(4,4).getClonedDrawingArea();
    }

    @Test
    public void executeMethodTestForHorizontalLine() throws CanvasOperationBaseException {
        InputCommand cmdForHorizontalLine = new InputCommand(LINE,
                new Coordinates(2, 2), new Coordinates(2, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

        expectedCanvas[2][2] = 'x';expectedCanvas[2][3] = 'x';expectedCanvas[2][4] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas.getClonedDrawingArea());
        inputCanvas.print();

    }


    @Test
    public void executeMethodTestForVerticalLine() throws CanvasOperationBaseException {
        InputCommand cmdForVerticalLine = new InputCommand(LINE,
                new Coordinates(1, 2), new Coordinates(3, 2));
        line.execute(cmdForVerticalLine, inputCanvas);

        expectedCanvas[1][2] = 'x';expectedCanvas[2][2] = 'x';expectedCanvas[3][2] = 'x';
        assertArrayEquals(expectedCanvas, inputCanvas.getClonedDrawingArea());
        inputCanvas.print();

    }

    @Test
    public void executeMethodTestForOverlappingLine() throws CanvasOperationBaseException {
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
    public void executeMethodTestForDiagonalLine() throws CanvasOperationBaseException {
        InputCommand cmdForHorizontalLine = new InputCommand(LINE,
                new Coordinates(2, 1), new Coordinates(3, 4));
        line.execute(cmdForHorizontalLine, inputCanvas);

    }

  }