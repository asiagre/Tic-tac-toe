package com.tictactoe.tic_tac_toe;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.Random;


public class GameController {

    private static int counterWinCircle = 0;
    private static int counterWinCross = 0;
    private static int counterDraw = 0;
    private GUIHelper guiHelper;
    private ElementHelper elementHelper = new ElementHelper(this);
    private Button[][] buttonTable = elementHelper.createButtonTable();
    private GameLogic gameLogic = new GameLogic();
    private Random generator = new Random();
    private boolean circleOrCross;

    private Cell[][] logicTable = createLogicTable();

    public GameController(GUIHelper guiHelper) {
        this.guiHelper = guiHelper;
    }

    private Cell[][] createLogicTable() {
        Cell[][] createdLogicTable = new Cell[9][9];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                createdLogicTable[i][j] = Cell.EMPTY;
            }
        }
        return createdLogicTable;
    }

    public void onMouseClickAction(Button button) {
        if(!gameLogic.isEnded()) {
            userAction(button);
        }
        if(!gameLogic.isEnded()) {
            computerAction();
        }
    }

    public void computerFirst() {
        computerAction();
    }

    private void userAction(Button button) {
        circleOrCross = guiHelper.isCrossOrCircle();
        if(!circleOrCross) {
            elementHelper.addCircle(button);
        } else {
            elementHelper.addCross(button);
        }
        logicTable = gameLogic.addElementsToLogicTable(buttonTable, logicTable);
        if(gameLogic.isEndAndWhoWins(logicTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }

    private void computerAction() {
        circleOrCross = guiHelper.isCrossOrCircle();
        Button button = computerChoice();
        if(circleOrCross) {
            elementHelper.addCircle(button);
        } else {
            elementHelper.addCross(button);
        }
        logicTable = gameLogic.addElementsToLogicTable(buttonTable, logicTable);
        if(gameLogic.isEndAndWhoWins(logicTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }

    private Button computerChoice() {
        Button button = null;
        int random1;
        int random2;
        do {
            random1 = generator.nextInt(3);
            random2 = generator.nextInt(3);
            if(logicTable[random1][random2] == Cell.EMPTY) {
                button = buttonTable[random1][random2];
            }
        } while(logicTable[random1][random2] != Cell.EMPTY);

        return button;
    }

    public void newGame() {
        gameLogic.setEnded(false);
        gameLogic.setWhoWins(WhoWins.NOBODY);
        buttonTable = elementHelper.getButtonTable();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                logicTable[i][j] = Cell.EMPTY;
            }
        }
    }

    public void counter() {
        if(gameLogic.getWhoWins() == WhoWins.CIRCLES) {
            counterWinCircle++;
        } else if(gameLogic.getWhoWins() == WhoWins.CROSSES) {
            counterWinCross++;
        } else {
            counterDraw++;
        }
    }

    public void endGame() {
        Button btn = guiHelper.getSummary();
        btn.setVisible(true);
        counter();
    }

    public ElementHelper getElementHelper() {
        return elementHelper;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public static int getCounterWinCircle() {
        return counterWinCircle;
    }

    public static int getCounterWinCross() {
        return counterWinCross;
    }

    public static int getCounterDraw() {
        return counterDraw;
    }
}
