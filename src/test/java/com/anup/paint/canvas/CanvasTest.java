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

        char expectedCanvas[][] = new char[width + 2][height + 2];

        initalizeDrawingArea(expectedCanvas);
        markColumnBoundary(expectedCanvas);
        markRowBoundary(expectedCanvas);

        assertArrayEquals(expectedCanvas, canvas.getClonedDrawingArea());
        canvas.print();
    }

    private void markRowBoundary(char[][] expectedCanvas) {
        expectedCanvas[0][0] = '-';
        expectedCanvas[0][1] = '-';
        expectedCanvas[0][2] = '-';
        expectedCanvas[0][3] = '-';
        expectedCanvas[0][4] = '-';
        expectedCanvas[0][5] = '-';
        expectedCanvas[5][0] = '-';
        expectedCanvas[5][1] = '-';
        expectedCanvas[5][2] = '-';
        expectedCanvas[5][3] = '-';
        expectedCanvas[5][4] = '-';
        expectedCanvas[5][5] = '-';
    }

    private void markColumnBoundary(char[][] expectedCanvas) {
        expectedCanvas[1][0] = '|';
        expectedCanvas[2][0] = '|';
        expectedCanvas[3][0] = '|';
        expectedCanvas[4][0] = '|';
        expectedCanvas[5][0] = '|';
        expectedCanvas[1][5] = '|';
        expectedCanvas[2][5] = '|';
        expectedCanvas[3][5] = '|';
        expectedCanvas[4][5] = '|';
        expectedCanvas[5][5] = '|';
    }

    private void initalizeDrawingArea(char[][] expectedCanvas) {
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                expectedCanvas[i][j] = ' ';
            }
        }
    }

    @Test
    public void canvasCloneTest() {
        char[][] originalCanvas = canvas.getClonedDrawingArea();
        originalCanvas[2][3] = 'x';
        assertNotEquals(originalCanvas, canvas.getClonedDrawingArea());
    }

    @Test
    public void mergeDrawingChangesTest(){
        char[][] newDrawingArea = canvas.getClonedDrawingArea();
        newDrawingArea[2][3] = 'x';
        assertNotEquals(newDrawingArea, canvas.getClonedDrawingArea());
        canvas.mergeDrawingChanges(newDrawingArea);
        assertArrayEquals(newDrawingArea,canvas.getClonedDrawingArea());
    }


}