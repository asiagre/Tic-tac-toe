package com.tictactoe.tic_tac_toe;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;

public class GameLogic9x9 {

    private boolean isEnded = false;
    private WhoWins whoWins = WhoWins.NOBODY;

    public Cell[][] addElementsToLogicTable(Button[][] buttonTable, Cell[][] logicTable) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
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
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 9; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j]) && logicTable[i][j].equals(logicTable[i + 2][j]) && logicTable[i][j].equals(logicTable[i + 3][j]) && logicTable[i][j].equals(logicTable[i + 4][j])) {
                    isEnded = true;
                    if(logicTable[i][j] == Cell.CIRCLE) {
                        whoWins = WhoWins.CIRCLES;
                    } else {
                        whoWins = WhoWins.CROSSES;
                    }
                    return true;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 5; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i][j + 1]) && logicTable[i][j].equals(logicTable[i][j + 2]) && logicTable[i][j].equals(logicTable[i][j + 3]) && logicTable[i][j].equals(logicTable[i][j + 4])) {
                    isEnded = true;
                    if(logicTable[i][j] == Cell.CIRCLE) {
                        whoWins = WhoWins.CIRCLES;
                    } else {
                        whoWins = WhoWins.CROSSES;
                    }
                    return true;
                }
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j + 1]) && logicTable[i][j].equals(logicTable[i + 2][j + 2]) && logicTable[i][j].equals(logicTable[i + 3][j + 3]) && logicTable[i][j].equals(logicTable[i + 4][j + 4])) {
                    isEnded = true;
                    if(logicTable[i][j] == Cell.CIRCLE) {
                        whoWins = WhoWins.CIRCLES;
                    } else {
                        whoWins = WhoWins.CROSSES;
                    }
                    return true;
                }
            }
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 4; j < 9; j++) {
                if(!(logicTable[i][j].equals(Cell.EMPTY)) && logicTable[i][j].equals(logicTable[i + 1][j -1]) && logicTable[i][j].equals(logicTable[i + 2][j - 2]) && logicTable[i][j].equals(logicTable[i + 3][j - 3]) && logicTable[i][j].equals(logicTable[i + 4][j - 4])) {
                    isEnded = true;
                    if(logicTable[i][j] == Cell.CIRCLE) {
                        whoWins = WhoWins.CIRCLES;
                    } else {
                        whoWins = WhoWins.CROSSES;
                    }
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
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
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
