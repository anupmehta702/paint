package com.anup.paint;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;


import static com.anup.paint.CreateCanvasHelper.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class PaintTest {

    Paint paint;

    @Before
    public void setup(){
        paint = new Paint();
    }

    @Test
    public void createCanvasTest(){
        paint.createCanvas(4,4);
        assertNotNull(paint.getCanvas());
    }

    @Test
    public void executeCommandTest(){
        InputCommand drawLineCommand = new InputCommand(CommandType.LINE,new Coordinates(2,2),new Coordinates(2,4));
        paint.createCanvas(width, height);
        paint.executeCanvasCommand(drawLineCommand);
        Canvas expectedCanvas = new Canvas(width,height);
        char[][] drawingArea = expectedCanvas.getClonedDrawingArea();
        drawingArea[2][2] = 'x';drawingArea[2][3] = 'x';drawingArea[2][4] = 'x';
        assertArrayEquals(drawingArea,paint.getCanvas().getClonedDrawingArea());
    }

    @Test
    public void executeCommandTestWithoutCanvas(){

    }


}