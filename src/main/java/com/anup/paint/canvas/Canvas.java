package com.anup.paint.canvas;

public final class Canvas {
    private final int width;
    private final int height;
    private  char[][] drawingArea;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.drawingArea = new char[width + 2][height + 2];
        initializeCanvas();
        markBorder();
    }
    private void initializeCanvas() {
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                drawingArea[i][j] = ' ';
            }
        }
    }

    private void markBorder() {
        //for  columns
        for (int i = 0; i < height + 2; i++) {
            drawingArea[i][0] = '|';
            drawingArea[i][width + 1] = '|';
        }
        //for rows
        for (int i = 0; i < width + 2; i++) {
            drawingArea[0][i] = '-';
            drawingArea[height + 1][i] = '-';
        }
    }

    public char[][] getDrawingArea() {
        return drawingArea.clone();
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < width + 2; i++) {
            System.out.println();
            for (int j = 0; j < height + 2; j++) {
                System.out.print(drawingArea[i][j]);
            }
        }
        System.out.println();
    }

}
