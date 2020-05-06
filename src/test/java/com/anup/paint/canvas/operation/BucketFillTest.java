package com.anup.paint.canvas.operation;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.exception.OutOfBoundaryBaseException;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Test;

public class BucketFillTest {

    Canvas inputCanvas = new Canvas(7, 7);
    BucketFill bucketFill = new BucketFill();
    Character[][] expectedDrawingArea = inputCanvas.getClonedDrawingArea();


    @Test
    public void executeTest() throws OutOfBoundaryBaseException {
        Rectangle rectangle = new Rectangle();
        InputCommand rectInput = new InputCommand(CommandType.RECTANGLE,
                new Coordinates(2, 2), new Coordinates(5, 5));
        rectangle.execute(rectInput, inputCanvas);
        expectedDrawingArea = inputCanvas.getClonedDrawingArea();
        bucketFill.execute(new InputCommand(CommandType.BUCKET_FILL, new Coordinates(6, 2), 'c'), inputCanvas);

        System.out.println("-->");
        for (int i = 1; i <= 6; i++) {
            for (int j = expectedDrawingArea[0].length - 2; j >= 1; j--) {
                if(expectedDrawingArea[i][j] == 'x'){
                    do{
                        j--;
                    }while((expectedDrawingArea[i][j] != 'x'));
                }else{
                    expectedDrawingArea[i][j] = 'c';
                }
            }
        }
        inputCanvas.mergeDrawingChanges(expectedDrawingArea);
        inputCanvas.print();


        //assertArrayEquals(expectedDrawingArea, inputCanvas.getClonedDrawingArea());
    }

}