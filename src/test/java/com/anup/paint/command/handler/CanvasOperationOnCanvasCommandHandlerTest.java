package com.anup.paint.command.handler;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;
import com.anup.paint.canvas.operation.Line;
import com.anup.paint.command.exception.CommandTypeNotSupportedException;
import com.anup.paint.command.exception.InputCommandException;
import com.anup.paint.command.model.CommandType;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CanvasOperationOnCanvasCommandHandlerTest {
    @Mock
    CanvasOperationObjectFactory objectFactory;
    @Mock
    Line line ;
    InputCommand input = new InputCommand(CommandType.LINE,new Coordinates(1,2),new Coordinates(1,4));;
    Canvas canvas =  new Canvas(4,4);

    @Before
    public void setup() throws CommandTypeNotSupportedException {
        when(objectFactory.getCanvasOperationObject(input)).thenReturn(line);
    }

    @Test
    public void executeCommandTest() throws InputCommandException, CanvasOperationBaseException {
        DrawOnCanvasCommandHandler cmdHandler = new DrawOnCanvasCommandHandler(objectFactory);
        cmdHandler.executeCommand(input,canvas);
        verify(line,times(1)).execute(input,canvas);
    }
}