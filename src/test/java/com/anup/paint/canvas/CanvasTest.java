package com.anup.paint.canvas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class CanvasTest {

    Canvas canvas;
    int width;
    int height;

    @Before
    public void test() {
        width = 4;
        height = 4;
        canvas = new Canvas(width, height);
    }

    @Test
    public void paintInitializationTest() {

        Character expectedDrawingArea[][] = new Character[width + 2][height + 2];

        initalizeDrawingArea(expectedDrawingArea);
        markColumnBoundary(expectedDrawingArea);
        markRowBoundary(expectedDrawingArea);

        assertArrayEquals(expectedDrawingArea, canvas.getClonedDrawingArea());
        canvas.print();
    }

    private void markRowBoundary(Character[][] expectedDrawingArea) {
        expectedDrawingArea[0][0] = '-';
        expectedDrawingArea[0][1] = '-';
        expectedDrawingArea[0][2] = '-';
        expectedDrawingArea[0][3] = '-';
        expectedDrawingArea[0][4] = '-';
        expectedDrawingArea[0][5] = '-';
        expectedDrawingArea[5][0] = '-';
        expectedDrawingArea[5][1] = '-';
        expectedDrawingArea[5][2] = '-';
        expectedDrawingArea[5][3] = '-';
        expectedDrawingArea[5][4] = '-';
        expectedDrawingArea[5][5] = '-';
    }

    private void markColumnBoundary(Character[][] expectedDrawingArea) {
        expectedDrawingArea[1][0] = '|';
        expectedDrawingArea[2][0] = '|';
        expectedDrawingArea[3][0] = '|';
        expectedDrawingArea[4][0] = '|';
        expectedDrawingArea[5][0] = '|';
        expectedDrawingArea[1][5] = '|';
        expectedDrawingArea[2][5] = '|';
        expectedDrawingArea[3][5] = '|';
        expectedDrawingArea[4][5] = '|';
        expectedDrawingArea[5][5] = '|';
    }

    private void initalizeDrawingArea(Character[][] expectedDrawingArea) {
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                expectedDrawingArea[i][j] = ' ';
            }
        }
    }

    @Test
    public void canvasCloneTest() {
        Character[][] clonedDrawingArea = canvas.getClonedDrawingArea();
        clonedDrawingArea[2][3] = 'x';
        assertNotEquals(clonedDrawingArea[2][3], canvas.getClonedDrawingArea()[2][3]);
    }

    @Test
    public void mergeDrawingChangesTest(){
        Character[][] newDrawingArea = canvas.getClonedDrawingArea();
        newDrawingArea[2][3] = 'x';
        assertNotEquals(newDrawingArea, canvas.getClonedDrawingArea());
        canvas.mergeDrawingChanges(newDrawingArea);
        assertArrayEquals(newDrawingArea,canvas.getClonedDrawingArea());
    }


}