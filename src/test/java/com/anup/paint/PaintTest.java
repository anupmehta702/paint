package com.anup.paint;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class PaintTest {
    Paint paint;
    int width ;
    int height ;

    @Before
    public void test(){
        width = 4;
        height = 4;
        paint = new Paint(width, height);
    }

    @Test
    public void paintInitializationTest() {

        char expectedCanvas[][] = new char[width + 2][height + 2];

        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                expectedCanvas[i][j]=' ';
            }
        }

        //for  columns
        expectedCanvas[1][0]='|';expectedCanvas[2][0]='|';expectedCanvas[3][0]='|';expectedCanvas[4][0]='|';expectedCanvas[5][0]='|';
        expectedCanvas[1][5]='|';expectedCanvas[2][5]='|';expectedCanvas[3][5]='|';expectedCanvas[4][5]='|';expectedCanvas[5][5]='|';

        //rows
        expectedCanvas[0][0]='-';expectedCanvas[0][1]='-';expectedCanvas[0][2]='-';expectedCanvas[0][3]='-';expectedCanvas[0][4]='-';expectedCanvas[0][5]='-';
        expectedCanvas[5][0]='-';expectedCanvas[5][1]='-';expectedCanvas[5][2]='-';expectedCanvas[5][3]='-';expectedCanvas[5][4]='-';expectedCanvas[5][5]='-';

        assertArrayEquals(expectedCanvas, paint.getCanvas());
        paint.print();
    }

    @Test
    public void canvasCloneTest(){
        char[][] originalCanvas = paint.getCanvas();
        originalCanvas[2][3]='X';
        assertNotEquals(originalCanvas,paint.getCanvas());
    }


}