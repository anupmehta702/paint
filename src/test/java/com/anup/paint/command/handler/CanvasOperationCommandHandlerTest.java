package com.anup.paint.command.handler;

import com.anup.paint.canvas.Canvas;
import com.anup.paint.canvas.exception.CanvasOperationBaseException;
import com.anup.paint.canvas.operation.CanvasOperationObjectFactory;
import com.anup.paint.canvas.operation.Line;
import com.anup.paint.command.exception.CommandTypeNotSupportedBaseException;
import com.anup.paint.command.exception.InputCommandBaseException;
import com.anup.paint.command.model.Coordinates;
import com.anup.paint.command.model.InputCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.anup.paint.command.model.CommandType.LINE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CanvasOperationCommandHandlerTest {
    private CanvasOperationCommandHandler cmdHandler;
    @Mock
     CanvasOperationObjectFactory objectFactory;
    @Mock
     Line line ;
    private InputCommand input = new InputCommand(LINE,new Coordinates(1,2),new Coordinates(1,4));
    private Canvas canvas =  new Canvas(4,4);

    @Before
    public void setup() throws CommandTypeNotSupportedBaseException {
        when(objectFactory.getCanvasOperationObject(input)).thenReturn(line);
        cmdHandler = new CanvasOperationCommandHandler(objectFactory);
    }

    @Test
    public void executeCommandTest() throws InputCommandBaseException, CanvasOperationBaseException {

        cmdHandler.executeCommand(input,canvas);
        verify(line,times(1)).execute(input,canvas);
    }

}