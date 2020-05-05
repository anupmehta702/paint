package com.anup.paint.draw;

import com.anup.paint.command.InputCommand;
import com.anup.paint.draw.exception.DiagonalLineNotAllowedException;
import com.anup.paint.draw.exception.DrawException;

public class Line implements Draw {

    @Override
    public char[][] execute(InputCommand input, char[][] canvas) throws DrawException{
        if (isLineToDrawHorizontal(input)) {
            drawHorizontalLine(input, canvas);
        } else if (isLineToDrawVertical(input)) {
            drawVerticalLine(input, canvas);
        }else{
            throw new DiagonalLineNotAllowedException("diagonal line not allowed ");
        }
        return canvas;
    }

    private void drawVerticalLine(InputCommand input, char[][] canvas) {
        for (int i = input.getStart().getX(); i <= input.getEnd().getX(); i++) {
            canvas[i][input.getStart().getY()] = input.getMarker();
        }
    }

    private boolean isLineToDrawHorizontal(InputCommand input) {
        return input.getStart().getX() == input.getEnd().getX();
    }

    private boolean isLineToDrawVertical(InputCommand input) {
        return input.getStart().getY() == input.getEnd().getY();
    }

    private void drawHorizontalLine(InputCommand input, char[][] canvas) {
        for (int i = input.getStart().getY(); i <= input.getEnd().getY(); i++) {
            canvas[input.getStart().getX()][i] = input.getMarker();
        }
    }
}
