package com.tictactoe.tic_tac_toe;

import javafx.scene.control.Button;

public abstract class GameLogic {

    private boolean isEnded = false;
    private WhoWins whoWins = WhoWins.NOBODY;

    public abstract boolean isEndAndWhoWins(Cell[][] logicTable, Button[][] buttonTable);

    public boolean isBoardFull(Cell[][] logicTable, int size) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
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

    public void nobodyWins() {
        isEnded = true;
        whoWins = WhoWins.DRAW;
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
