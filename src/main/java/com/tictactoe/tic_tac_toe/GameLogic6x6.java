package com.tictactoe.tic_tac_toe;

import javafx.scene.control.Button;

public class GameLogic6x6 extends GameLogic {

    private int size = 6;

    public boolean isEndAndWhoWins(Cell[][] logicTable, Button[][] buttonTable) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 6; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j]) && logicTable[i][j].equals(logicTable[i + 2][j]) && logicTable[i][j].equals(logicTable[i + 3][j])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i + 1][j]);
                    ElementHelper.coloringButton(buttonTable[i + 2][j]);
                    ElementHelper.coloringButton(buttonTable[i + 3][j]);

                    return true;
                }
            }
        }

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 3; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i][j + 1]) && logicTable[i][j].equals(logicTable[i][j + 2]) && logicTable[i][j].equals(logicTable[i][j + 3])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j + 1]);
                    ElementHelper.coloringButton(buttonTable[i][j + 2]);
                    ElementHelper.coloringButton(buttonTable[i][j + 3]);

                    return true;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j + 1]) && logicTable[i][j].equals(logicTable[i + 2][j + 2]) && logicTable[i][j].equals(logicTable[i + 3][j + 3])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i + 1][j + 1]);
                    ElementHelper.coloringButton(buttonTable[i + 2][j + 2]);
                    ElementHelper.coloringButton(buttonTable[i + 3][j + 3]);

                    return true;
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 3; j < 6; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j -1]) && logicTable[i][j].equals(logicTable[i + 2][j - 2]) && logicTable[i][j].equals(logicTable[i + 3][j - 3])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i + 1][j - 1]);
                    ElementHelper.coloringButton(buttonTable[i + 2][j - 2]);
                    ElementHelper.coloringButton(buttonTable[i + 3][j - 3]);

                    return true;
                }
            }
        }

        if(isBoardFull(logicTable, size)) {
            nobodyWins();
            return true;
        } else {
            return false;
        }
    }
}
