package com.tictactoe.tic_tac_toe;


import javafx.scene.control.Button;

public class GameLogic9x9  extends GameLogic{

    private int size = 9;

    public boolean isEndAndWhoWins(Cell[][] logicTable, Button[][] buttonTable) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 9; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j]) && logicTable[i][j].equals(logicTable[i + 2][j]) && logicTable[i][j].equals(logicTable[i + 3][j]) && logicTable[i][j].equals(logicTable[i + 4][j])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i + 1][j]);
                    ElementHelper.coloringButton(buttonTable[i + 2][j]);
                    ElementHelper.coloringButton(buttonTable[i + 3][j]);
                    ElementHelper.coloringButton(buttonTable[i + 4][j]);

                    return true;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 5; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i][j + 1]) && logicTable[i][j].equals(logicTable[i][j + 2]) && logicTable[i][j].equals(logicTable[i][j + 3]) && logicTable[i][j].equals(logicTable[i][j + 4])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j + 1]);
                    ElementHelper.coloringButton(buttonTable[i][j + 2]);
                    ElementHelper.coloringButton(buttonTable[i][j + 3]);
                    ElementHelper.coloringButton(buttonTable[i][j + 4]);

                    return true;
                }
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j + 1]) && logicTable[i][j].equals(logicTable[i + 2][j + 2]) && logicTable[i][j].equals(logicTable[i + 3][j + 3]) && logicTable[i][j].equals(logicTable[i + 4][j + 4])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i + 1][j + 1]);
                    ElementHelper.coloringButton(buttonTable[i + 2][j + 2]);
                    ElementHelper.coloringButton(buttonTable[i + 3][j + 3]);
                    ElementHelper.coloringButton(buttonTable[i + 4][j + 4]);

                    return true;
                }
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 4; j < 9; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j -1]) && logicTable[i][j].equals(logicTable[i + 2][j - 2]) && logicTable[i][j].equals(logicTable[i + 3][j - 3]) && logicTable[i][j].equals(logicTable[i + 4][j - 4])) {
                    whoWinGame(logicTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i][j]);
                    ElementHelper.coloringButton(buttonTable[i + 1][j - 1]);
                    ElementHelper.coloringButton(buttonTable[i + 2][j - 2]);
                    ElementHelper.coloringButton(buttonTable[i + 3][j - 3]);
                    ElementHelper.coloringButton(buttonTable[i + 4][j - 4]);

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
