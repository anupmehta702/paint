package com.anup.paint.command.model;

public enum CommandType {
    LINE("L",4),
    RECTANGLE("R",4),
    BUCKET_FILL("B",3),
    CANVAS("C",2);
    String commandString;
    int noOfInputParametersReq;

    public String getCommandString() {
        return commandString;
    }

    CommandType(String commandString,int noOfInputParametersReq) {
        this.commandString = commandString;
        this.noOfInputParametersReq = noOfInputParametersReq;
    }

    public static CommandType fromString(String input){
        for(CommandType c : CommandType.values()){
            if(c.getCommandString().equalsIgnoreCase(input)){
                return c;
            }
        }
        return null;
    }
}
