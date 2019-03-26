package com.tictactoe.tic_tac_toe;

import javafx.scene.control.Button;

public class GameLogic3x3 extends GameLogic {

    private int size = 3;

    public boolean isEndAndWhoWins(Cell[][] logicTable, Button[][] buttonTable) {
        for(int i = 0; i < 3; i++) {
            if(!(logicTable[i][0].equals(Cell.EMPTY)) && logicTable[i][0].equals(logicTable[i][1]) && logicTable[i][0].equals(logicTable[i][2])) {
                whoWinGame(logicTable[i][0]);
                ElementHelper.coloringButton(buttonTable[i][0]);
                ElementHelper.coloringButton(buttonTable[i][1]);
                ElementHelper.coloringButton(buttonTable[i][2]);

                return true;
            }
        }

        for(int i = 0; i < 3; i++) {
            if(!(logicTable[0][i].equals(Cell.EMPTY)) && logicTable[0][i].equals(logicTable[1][i]) && logicTable[0][i].equals(logicTable[2][i])) {
                whoWinGame(logicTable[0][i]);
                ElementHelper.coloringButton(buttonTable[0][i]);
                ElementHelper.coloringButton(buttonTable[1][i]);
                ElementHelper.coloringButton(buttonTable[2][i]);

                return true;
            }
        }

        if(!(logicTable[0][0].equals(Cell.EMPTY)) && logicTable[0][0].equals(logicTable[1][1]) && logicTable[0][0].equals(logicTable[2][2])) {
            whoWinGame(logicTable[0][0]);
            ElementHelper.coloringButton(buttonTable[0][0]);
            ElementHelper.coloringButton(buttonTable[1][1]);
            ElementHelper.coloringButton(buttonTable[2][2]);

            return true;
        } else if(!(logicTable[0][2].equals(Cell.EMPTY)) && logicTable[0][2].equals(logicTable[1][1]) && logicTable[0][2].equals(logicTable[2][0])) {
            whoWinGame(logicTable[0][2]);
            ElementHelper.coloringButton(buttonTable[0][2]);
            ElementHelper.coloringButton(buttonTable[1][1]);
            ElementHelper.coloringButton(buttonTable[2][0]);

            return true;
        }

        if(isBoardFull(logicTable, size)) {
            nobodyWins();
            return true;
        } else {
            return false;
        }
    }

}
