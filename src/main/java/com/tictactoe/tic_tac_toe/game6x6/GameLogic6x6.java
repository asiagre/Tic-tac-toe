package com.tictactoe.tic_tac_toe.game6x6;


import com.tictactoe.tic_tac_toe.Cell;
import com.tictactoe.tic_tac_toe.ElementHelper;
import com.tictactoe.tic_tac_toe.WhoWins;
import javafx.scene.control.Button;

public class GameLogic6x6 {

    private boolean isEnded = false;
    private WhoWins whoWins = WhoWins.NOBODY;

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

        if(boardFull(logicTable)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean boardFull(Cell[][] logicTable) {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(logicTable[i][j].equals(Cell.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void whoWinGame(Enum<Cell> inCell) {
        isEnded = true;
        if(inCell == Cell.CIRCLE) {
            whoWins = WhoWins.CIRCLES;
        } else {
            whoWins = WhoWins.CROSSES;
        }
    }

    public boolean isEnded() {
        return isEnded;
    }

    public WhoWins getWhoWins() {
        return whoWins;
    }

    public void setWhoWins(WhoWins whoWins) {
        this.whoWins = whoWins;
    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

}
