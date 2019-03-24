package com.tictactoe.tic_tac_toe.game6x6;

import com.tictactoe.tic_tac_toe.*;
import javafx.event.Event;
import javafx.scene.control.Button;

public class GameController6x6 {

    private GUIHelper guiHelper;
    private GameController gameController;
    private Board6x6 board6x6 = new Board6x6(this);
    private Button[][] buttonTable = board6x6.getButtonTable();
    private GameLogic6x6 gameLogic6x6 = new GameLogic6x6();
    private boolean circleOrCross;
    private int tableSize = 6;
    private Cell[][] logicTable;

    public GameController6x6(GUIHelper guiHelper, GameController gameController) {
        this.guiHelper = guiHelper;
        this.gameController = gameController;
        logicTable = gameController.createLogicTable(tableSize);
    }

    public void onMouseClickAction(Button button) {
        if(!gameLogic6x6.isEnded()) {
            userAction(button);
        }
        if(!gameLogic6x6.isEnded()) {
            computerAction();
        }
    }

    public void computerFirst() {
        circleOrCross = guiHelper.isCrossOrCircle();
        computerAction();
    }

    private void userAction(Button button) {
        if(!circleOrCross) {
            board6x6.addCircle(button);
        } else {
            board6x6.addCross(button);
        }
        action(button);
    }

    private void computerAction() {
        Button button = gameController.computerChoice(logicTable, buttonTable, tableSize);
        if(circleOrCross) {
            board6x6.addCircle(button);
        } else {
            board6x6.addCross(button);
        }
        action(button);
    }

    private void action(Button button) {
        logicTable = gameController.addElementsToLogicTable(buttonTable, logicTable, tableSize);
        if(gameLogic6x6.isEndAndWhoWins(logicTable, buttonTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }


    public void newGame() {
        gameLogic6x6.setEnded(false);
        gameLogic6x6.setWhoWins(WhoWins.NOBODY);
        board6x6.setNewButtonTable();
        buttonTable = board6x6.getButtonTable();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                logicTable[i][j] = Cell.EMPTY;
            }
        }
    }

    private void counter() {
        if(gameLogic6x6.getWhoWins() == WhoWins.CIRCLES) {
            GameController.addWinCircle();
        } else if(gameLogic6x6.getWhoWins() == WhoWins.CROSSES) {
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

    public Board6x6 getBoard6x6() {
        return board6x6;
    }

    public GameLogic6x6 getGameLogic6x6() {
        return gameLogic6x6;
    }

}
