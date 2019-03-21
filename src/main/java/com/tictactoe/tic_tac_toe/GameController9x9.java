package com.tictactoe.tic_tac_toe;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.util.Random;

public class GameController9x9 {
    private static int counterWinCircle = 0;
    private static int counterWinCross = 0;
    private static int counterDraw = 0;
    private GUIHelper guiHelper;
    private Board9x9 board9x9 = new Board9x9(this);
    private Button[][] buttonTable = board9x9.createButtonTable();
    private GameLogic9x9 gameLogic9x9 = new GameLogic9x9();
    private Random generator = new Random();
    private boolean circleOrCross;

    private Cell[][] logicTable = createLogicTable();

    public GameController9x9(GUIHelper guiHelper) {
        this.guiHelper = guiHelper;
    }

    private Cell[][] createLogicTable() {
        Cell[][] createdLogicTable = new Cell[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                createdLogicTable[i][j] = Cell.EMPTY;
            }
        }
        return createdLogicTable;
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
        computerAction();
    }

    private void userAction(Button button) {
        circleOrCross = guiHelper.isCrossOrCircle();
        if(!circleOrCross) {
            board9x9.addCircle(button);
        } else {
            board9x9.addCross(button);
        }
        logicTable = gameLogic9x9.addElementsToLogicTable(buttonTable, logicTable);
        if(gameLogic9x9.isEndAndWhoWins(logicTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }

    private void computerAction() {
        circleOrCross = guiHelper.isCrossOrCircle();
        Button button = computerChoice();
        button.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        if(circleOrCross) {
            board9x9.addCircle(button);
            System.out.println("cosik");
            button.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        } else {
            board9x9.addCross(button);
            System.out.println("cosik");
            button.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        }
        logicTable = gameLogic9x9.addElementsToLogicTable(buttonTable, logicTable);
        if(gameLogic9x9.isEndAndWhoWins(logicTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }

    private Button computerChoice() {
        Button button = null;
        int random1;
        int random2;
        do {
            random1 = generator.nextInt(9);
            random2 = generator.nextInt(9);
            if(logicTable[random1][random2] == Cell.EMPTY) {
                button = buttonTable[random1][random2];
            }
        } while(logicTable[random1][random2] != Cell.EMPTY);

        return button;
    }

    public void newGame() {
        gameLogic9x9.setEnded(false);
        gameLogic9x9.setWhoWins(WhoWins.NOBODY);
        buttonTable = board9x9.getButtonTable();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                logicTable[i][j] = Cell.EMPTY;
            }
        }
    }

    public void counter() {
        if(gameLogic9x9.getWhoWins() == WhoWins.CIRCLES) {
            counterWinCircle++;
        } else if(gameLogic9x9.getWhoWins() == WhoWins.CROSSES) {
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

    public Board9x9 getBoard9x9() {
        return board9x9;
    }

    public GameLogic9x9 getGameLogic9x9() {
        return gameLogic9x9;
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
