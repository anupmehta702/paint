package com.anup.paint;

import com.anup.paint.command.InputCommand;
import com.anup.paint.command.handler.DrawOnCanvasCommandHandler;
import com.anup.paint.draw.DrawObjectFactory;

public final class Paint {

    private final char canvas[][];
    private final int width;
    private final int height;
    private DrawOnCanvasCommandHandler canvasCommandHandler = new DrawOnCanvasCommandHandler(new DrawObjectFactory());

    public Paint(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new char[width + 2][height + 2];
        initializeCanvas();
        markBorder();

    }

    private void initializeCanvas() {
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    private void markBorder() {
        //for  columns
        for (int i = 0; i < height + 2; i++) {
            canvas[i][0] = '|';
            canvas[i][width + 1] = '|';
        }
        //for rows
        for (int i = 0; i < width + 2; i++) {
            canvas[0][i] = '-';
            canvas[height + 1][i] = '-';
        }
    }

    public char[][] getCanvas() {
        return canvas.clone();
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < width + 2; i++) {
            System.out.println();
            for (int j = 0; j < height + 2; j++) {
                System.out.print(canvas[i][j]);
            }
        }
        System.out.println();
    }

    public void executeCommand( InputCommand input){
        canvasCommandHandler.executeCommand(input,canvas.clone());
    }
}
