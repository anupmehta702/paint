package com.anup.paint;

public class CreateCanvasHelper {

    static int width = 4 ,height = 4;

    public static char[][] createNewCanvas(){

        char defaultCanvas[][] = new char[width + 2][height + 2];

        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                defaultCanvas[i][j]=' ';
            }
        }

        //for  columns
        defaultCanvas[1][0]='|';defaultCanvas[2][0]='|';defaultCanvas[3][0]='|';defaultCanvas[4][0]='|';defaultCanvas[5][0]='|';
        defaultCanvas[1][5]='|';defaultCanvas[2][5]='|';defaultCanvas[3][5]='|';defaultCanvas[4][5]='|';defaultCanvas[5][5]='|';

        //rows
        defaultCanvas[0][0]='-';defaultCanvas[0][1]='-';defaultCanvas[0][2]='-';defaultCanvas[0][3]='-';defaultCanvas[0][4]='-';defaultCanvas[0][5]='-';
        defaultCanvas[5][0]='-';defaultCanvas[5][1]='-';defaultCanvas[5][2]='-';defaultCanvas[5][3]='-';defaultCanvas[5][4]='-';defaultCanvas[5][5]='-';

        return defaultCanvas;
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
