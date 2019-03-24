package com.tictactoe.tic_tac_toe.game9x9;

import com.tictactoe.tic_tac_toe.*;
import javafx.event.Event;
import javafx.scene.control.Button;

public class GameController9x9 {

    private GUIHelper guiHelper;
    private GameController gameController;
    private Board9x9 board9x9 = new Board9x9(this);
    private Button[][] buttonTable = board9x9.getButtonTable();
    private GameLogic9x9 gameLogic9x9 = new GameLogic9x9();
    private boolean circleOrCross;
    private int tableSize = 9;
    private Cell[][] logicTable;

    public GameController9x9(GUIHelper guiHelper, GameController gameController) {
        this.guiHelper = guiHelper;
        this.gameController = gameController;
        logicTable = gameController.createLogicTable(tableSize);
    }

    public void onMouseClickAction(Button button) {
        if(!gameLogic9x9.isEnded()) {
            userAction(button);
        }
        if(!gameLogic9x9.isEnded()) {
            computerAction();
        }
    }

    public void computerFirst() {
        circleOrCross = guiHelper.isCrossOrCircle();
        computerAction();
    }

    private void userAction(Button button) {
        if(!circleOrCross) {
            board9x9.addCircle(button);
        } else {
            board9x9.addCross(button);
        }
        action(button);
    }

    private void computerAction() {
        Button button = gameController.computerChoice(logicTable, buttonTable, tableSize);
        if(circleOrCross) {
            board9x9.addCircle(button);
        } else {
            board9x9.addCross(button);
        }
        action(button);
    }

    private void action(Button button) {
        logicTable = gameController.addElementsToLogicTable(buttonTable, logicTable, tableSize);
        if(gameLogic9x9.isEndAndWhoWins(logicTable, buttonTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }


    public void newGame() {
        gameLogic9x9.setEnded(false);
        gameLogic9x9.setWhoWins(WhoWins.NOBODY);
        board9x9.setNewButtonTable();
        buttonTable = board9x9.getButtonTable();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                logicTable[i][j] = Cell.EMPTY;
            }
        }
    }

    private void counter() {
        if(gameLogic9x9.getWhoWins() == WhoWins.CIRCLES) {
            GameController.addWinCircle();
        } else if(gameLogic9x9.getWhoWins() == WhoWins.CROSSES) {
            GameController.addWinCross();
        } else {
            GameController.addDraw();
        }
    }

    private void endGame() {
        Button btn = guiHelper.getSummary();
        btn.setVisible(true);
        counter();
    }

    public Board9x9 getBoard9x9() {
        return board9x9;
    }

    public GameLogic9x9 getGameLogic9x9() {
        return gameLogic9x9;
    }

}
