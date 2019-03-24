package com.tictactoe.tic_tac_toe;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;

import java.util.Random;


public class GameController {

    private static int counterWinCircle = 0;
    private static int counterWinCross = 0;
    private static int counterDraw = 0;
    private Random generator = new Random();

    public Cell[][] createLogicTable(int size) {
        Cell[][] createdLogicTable = new Cell[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                createdLogicTable[i][j] = Cell.EMPTY;
            }
        }
        return createdLogicTable;
    }

    public Button computerChoice(Cell[][] logicTable, Button[][] buttonTable, int size) {
        Button button = null;
        int random1;
        int random2;
        do {
            random1 = generator.nextInt(size);
            random2 = generator.nextInt(size);
            if(logicTable[random1][random2] == Cell.EMPTY) {
                button = buttonTable[random1][random2];
            }
        } while(logicTable[random1][random2] != Cell.EMPTY);

        return button;
    }

    public Cell[][] addElementsToLogicTable(Button[][] buttonTable, Cell[][] logicTable, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (buttonTable[i][j].getGraphic() instanceof Path) {
                    logicTable[i][j] = Cell.CROSS;
                } else if (buttonTable[i][j].getGraphic() instanceof Circle) {
                    logicTable[i][j] = Cell.CIRCLE;
                }
            }
        }
        return logicTable;
    }

    public static void addWinCircle() {
        counterWinCircle++;
    }

    public static void addWinCross() {
        counterWinCross++;
    }

    public static void addDraw() {
        counterDraw++;
    }

    public static int getCounterWinCircle() {
        return counterWinCircle;
    }

    public static int getCounterWinCross() {
        return counterWinCross;
    }

    public static int getCounterDraw() {
        return counterDraw;
    }

}
