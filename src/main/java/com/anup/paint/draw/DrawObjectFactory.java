package com.anup.paint.draw;

import com.anup.paint.command.CommandType;
import com.anup.paint.command.InputCommand;
import com.anup.paint.draw.exception.NotSupportedCommandType;

public class DrawObjectFactory {
    public  Draw getDrawObject(InputCommand input) throws NotSupportedCommandType {
        if(CommandType.LINE == input.getCommandType() ){
            return new Line();
        }else if (CommandType.RECTANGLE == input.getCommandType() ){
            return new Rectangle();
        }
        throw new NotSupportedCommandType(input);

    }
}
