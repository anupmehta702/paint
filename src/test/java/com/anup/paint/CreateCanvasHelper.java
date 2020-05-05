package com.anup.paint;

import com.anup.paint.canvas.Canvas;

public class CreateCanvasHelper {

    static int width = 4 ,height = 4;

    public static Canvas createNewCanvas(){

        Canvas canvas = new Canvas(4,4);
        return canvas;
    }

    public static void printCanvas(char[][] canvas){
        System.out.println();
        for (int i = 0; i < width + 2; i++) {
            System.out.println();
            for (int j = 0; j < height + 2; j++) {
                System.out.print(canvas[i][j]);
            }
        }
        System.out.println();
    }

}
