package com.tictactoe.tic_tac_toe;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;

public class GameLogic {

    private boolean isEnded = false;
    private WhoWins whoWins = WhoWins.NOBODY;

    public Cell[][] addElementsToLogicTable(Button[][] buttonTable, Cell[][] logicTable) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttonTable[i][j].getGraphic() instanceof Path) {
                    logicTable[i][j] = Cell.CROSS;
                } else if (buttonTable[i][j].getGraphic() instanceof Circle) {
                    logicTable[i][j] = Cell.CIRCLE;
                }
            }
        }
        return logicTable;
    }

    public boolean isEndAndWhoWins(Cell[][] logicTable) {
        for(int i = 0; i < 3; i++) {
            if(!(logicTable[i][0].equals(Cell.EMPTY)) && logicTable[i][0].equals(logicTable[i][1]) && logicTable[i][0].equals(logicTable[i][2])) {
                isEnded = true;
                if(logicTable[i][0] == Cell.CIRCLE) {
                    whoWins = WhoWins.CIRCLES;
                } else {
                    whoWins = WhoWins.CROSSES;
                }
                return true;
            }
        }

        for(int i = 0; i < 3; i++) {
            if(!(logicTable[0][i].equals(Cell.EMPTY)) && logicTable[0][i].equals(logicTable[1][i]) && logicTable[0][i].equals(logicTable[2][i])) {
                isEnded = true;
                if(logicTable[0][i] == Cell.CIRCLE) {
                    whoWins = WhoWins.CIRCLES;
                } else {
                    whoWins = WhoWins.CROSSES;
                }
                return true;
            }
        }

        if(!(logicTable[0][0].equals(Cell.EMPTY)) && logicTable[0][0].equals(logicTable[1][1]) && logicTable[0][0].equals(logicTable[2][2])) {
            isEnded = true;
            if(logicTable[0][0] == Cell.CIRCLE) {
                whoWins = WhoWins.CIRCLES;
            } else {
                whoWins = WhoWins.CROSSES;
            }
            return true;
        } else if(!(logicTable[0][2].equals(Cell.EMPTY)) && logicTable[0][2].equals(logicTable[1][1]) && logicTable[0][2].equals(logicTable[2][0])) {
            isEnded = true;
            if(logicTable[0][2] == Cell.CIRCLE) {
                whoWins = WhoWins.CIRCLES;
            } else {
                whoWins = WhoWins.CROSSES;
            }
            return true;
        } else if(isBoardFull(logicTable)) {
            isEnded = true;
            whoWins = WhoWins.DRAW;
            return true;
        }

        return false;
    }

    public boolean isBoardFull(Cell[][] logicTable) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(logicTable[i][j].equals(Cell.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
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
