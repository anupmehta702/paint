package com.anup.paint;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.command.exception.NoCanvasCreatedException;
import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.handler.DrawOnCanvasCommandHandler;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;

public  class Paint {

    private Canvas canvas;
    private DrawOnCanvasCommandHandler canvasCommandHandler = new DrawOnCanvasCommandHandler(new CanvasOperationObjectFactory());

    public Paint() {

    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public void print(){
        this.canvas.print();
    }


    public void createCanvas(int width , int height){
        this.canvas = new Canvas(width, height);
        print();
    }

    public void executeCanvasCommand( InputCommand input) throws NoCanvasCreatedException {
        if(this.canvas == null){
            throw new NoCanvasCreatedException("Canvas not created. Cannot perform any operation without canvas");
        }
        try {
            canvasCommandHandler.executeCommand(input,canvas);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
