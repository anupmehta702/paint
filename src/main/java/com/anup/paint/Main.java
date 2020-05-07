package com.anup.paint;

import com.anup.paint.command.model.InputCommand;
import com.anup.paint.command.model.InputProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        getInput();
    }

    public static void getInput() {
        Paint paint = new Paint();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = null;
            while (!(input = br.readLine()).equals("Q")) {
                InputCommand inputCmd = InputProcessor.convertInputToCommand(input);
                paint.executeInputCommand(inputCmd);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }



}
