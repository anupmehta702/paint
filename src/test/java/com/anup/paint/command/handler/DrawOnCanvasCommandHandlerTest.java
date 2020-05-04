package com.anup.paint.command.handler;

import com.anup.paint.command.CommandType;
import com.anup.paint.command.Coordinates;
import com.anup.paint.command.InputCommand;
import com.anup.paint.draw.DrawObjectFactory;
import com.anup.paint.draw.Line;
import com.anup.paint.draw.exception.NotSupportedCommandType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DrawOnCanvasCommandHandlerTest {
    @Mock
    DrawObjectFactory objectFactory;
    @Mock
    Line line ;
    InputCommand input = new InputCommand(CommandType.LINE,new Coordinates(1,2),new Coordinates(1,4));;
    char[][] canvas = new char[5][5];

    @Before
    public void setup() throws NotSupportedCommandType {
        when(objectFactory.getDrawObject(input)).thenReturn(line);
    }

    @Test
    public void executeCommandTest() {
        DrawOnCanvasCommandHandler cmdHandler = new DrawOnCanvasCommandHandler(objectFactory);
        cmdHandler.executeCommand(input,canvas);
        verify(line,times(1)).execute(input,canvas);
    }
}