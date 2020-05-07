package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BucketFillTest {

    private Canvas inputCanvas;
    private BucketFill bucketFill;
    private Character[][] expectedDrawingArea;
    private InputCommand input;

    @Before
    public void setup() {
        inputCanvas = new Canvas(7, 7);
        bucketFill = new BucketFill();
        expectedDrawingArea = inputCanvas.getClonedDrawingArea();
        input = new InputCommand(CommandType.BUCKET_FILL, new Coordinates(7, 7), 'c');
    }


    @Test
    public void executeTest() throws CanvasOperationBaseException {
        Rectangle rectangle = new Rectangle();
        InputCommand rectInput = new InputCommand(CommandType.RECTANGLE,
                new Coordinates(2, 2), new Coordinates(4, 4));
        rectangle.execute(rectInput, inputCanvas);

        Line line = new Line();
        InputCommand hLine = new InputCommand(CommandType.LINE,
                new Coordinates(6, 1), new Coordinates(6, 2));
        line.execute(hLine, inputCanvas);
        InputCommand vLine = new InputCommand(CommandType.LINE,
                new Coordinates(6, 2), new Coordinates(7, 2));
        line.execute(vLine, inputCanvas);

        InputCommand hLine2 = new InputCommand(CommandType.LINE,
                new Coordinates(2, 6), new Coordinates(2, 7));
        line.execute(hLine2, inputCanvas);
        InputCommand vLine2 = new InputCommand(CommandType.LINE,
                new Coordinates(1, 6), new Coordinates(2, 6));
        line.execute(vLine2, inputCanvas);

        expectedDrawingArea = inputCanvas.getClonedDrawingArea();
        bucketFill.execute(input, inputCanvas);

        expectedBucketFilledArea();

        inputCanvas.mergeDrawingChanges(expectedDrawingArea);
        inputCanvas.print();

    assertArrayEquals(expectedDrawingArea, inputCanvas.getClonedDrawingArea());
}

    private void expectedBucketFilledArea() {
        for (int i = 1; i <= expectedDrawingArea.length - 2; i++) {
            for (int j = 1; j <= expectedDrawingArea[0].length - 2; j++) {
                if (expectedDrawingArea[i][j] != 'x') {
                    expectedDrawingArea[i][j] = 'c';
                }
            }
        }
        expectedDrawingArea[3][3]=' ';
        expectedDrawingArea[1][7]=' ';
        expectedDrawingArea[7][1]=' ';
    }

}