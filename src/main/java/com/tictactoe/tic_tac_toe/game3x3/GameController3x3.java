package com.tictactoe.tic_tac_toe.game3x3;

import com.tictactoe.tic_tac_toe.*;
import javafx.event.Event;
import javafx.scene.control.Button;

public class GameController3x3 {

    private GUIHelper guiHelper;
    private GameController gameController;
    private Board3x3 board3x3 = new Board3x3(this);
    private Button[][] buttonTable = board3x3.getButtonTable();
    private GameLogic3x3 gameLogic3x3 = new GameLogic3x3();
    private boolean circleOrCross;
    private int tableSize = 3;
    private Cell[][] logicTable;

    public GameController3x3(GUIHelper guiHelper, GameController gameController) {
        this.guiHelper = guiHelper;
        this.gameController = gameController;
        logicTable = gameController.createLogicTable(tableSize);
    }

    public void onMouseClickAction(Button button) {
        if(!gameLogic3x3.isEnded()) {
            userAction(button);
        }
        if(!gameLogic3x3.isEnded()) {
            computerAction();
        }
    }

    public void computerFirst() {
        circleOrCross = guiHelper.isCrossOrCircle();
        computerAction();
    }

    private void userAction(Button button) {
        if(!circleOrCross) {
            board3x3.addCircle(button);
        } else {
            board3x3.addCross(button);
        }
        action(button);
    }

    private void computerAction() {
        Button button = gameController.computerChoice(logicTable, buttonTable, tableSize);
        if(circleOrCross) {
            board3x3.addCircle(button);
        } else {
            board3x3.addCross(button);
        }
        action(button);
    }

    private void action(Button button) {
        logicTable = gameController.addElementsToLogicTable(buttonTable, logicTable, tableSize);
        if(gameLogic3x3.isEndAndWhoWins(logicTable, buttonTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }

    public void newGame() {
        gameLogic3x3.setEnded(false);
        gameLogic3x3.setWhoWins(WhoWins.NOBODY);
        board3x3.setNewButtonTable();
        buttonTable = board3x3.getButtonTable();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                logicTable[i][j] = Cell.EMPTY;
            }
        }
    }

    private void counter() {
        if(gameLogic3x3.getWhoWins() == WhoWins.CIRCLES) {
            GameController.addWinCircle();
        } else if(gameLogic3x3.getWhoWins() == WhoWins.CROSSES) {
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

    public Board3x3 getBoard3x3() {
        return board3x3;
    }

    public GameLogic3x3 getGameLogic3x3() {
        return gameLogic3x3;
    }

}
