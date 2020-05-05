package com.anup.paint.canvas;

public final class Canvas {
    private final int width;
    private final int height;
    private Character[][] drawingArea;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.drawingArea = new Character[height + 2][width + 2];
        initializeCanvas();
        markBorder();
    }

    private void initializeCanvas() {
        for (int i = 0; i < drawingArea.length; i++) {
            for (int j = 0; j < drawingArea[0].length; j++) {
                drawingArea[i][j] = ' ';
            }
        }
    }

    private void markBorder() {
        //for  columns
        for (int i = 0; i < drawingArea[0].length; i++) {
            drawingArea[i][0] = '|';
            drawingArea[i][width + 1] = '|';
        }
        //for rows
        for (int i = 0; i < drawingArea.length; i++) {
            drawingArea[0][i] = '-';
            drawingArea[height + 1][i] = '-';
        }
    }


    public Character[][] getClonedDrawingArea() {
        Character[][] clonedDrawingArea = new Character[drawingArea.length][drawingArea[0].length];
        for (int i = 0; i < drawingArea.length; i++) {
            for (int j = 0; j < drawingArea[0].length; j++) {
                clonedDrawingArea[i][j] = drawingArea[i][j];
            }
        }
        return clonedDrawingArea;//drawingArea.clone();
    }

    public void mergeDrawingChanges(Character[][] inputDrawingArea) {
        for (int i = 0; i < drawingArea.length; i++) {//row
            for (int j = 0; j < drawingArea[0].length; j++) {//column
                if (inputDrawingArea[i][j] != ' ' && inputDrawingArea[i][j] != this.drawingArea[i][j]) {
                    this.drawingArea[i][j] = inputDrawingArea[i][j];
                }
            }
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < drawingArea.length; i++) {//row
            System.out.println();
            for (int j = 0; j < drawingArea[0].length; j++) {//column
                System.out.print(drawingArea[i][j]);
            }
        }
        System.out.println();
    }

}
