package com.tictactoe.tic_tac_toe;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import java.util.Random;

public class GameController {

    private static int counterWinCircle = 0;
    private static int counterWinCross = 0;
    private static int counterDraw = 0;
    private GUIHelper guiHelper;
    private ChangeBoard changeBoard;
    private GameLogic gameLogic;
    private Board board;
    private boolean circleOrCross;
    private int[] tableSize = { 3, 6, 9 };
    private int tableIndex;
    private Cell[][] logicTable;
    private Random generator = new Random();
    private Button[][] buttonTable;

    public GameController(GUIHelper guiHelper, ChangeBoard changeBoard) {
        this.guiHelper = guiHelper;
        this.changeBoard = changeBoard;
        if(this.changeBoard == ChangeBoard.THREE) {
            gameLogic = new GameLogic3x3();
            board = new Board3x3(this, this.changeBoard);
            tableIndex = 0;
        } else if(this.changeBoard == ChangeBoard.SIX) {
            gameLogic = new GameLogic6x6();
            board = new Board6x6(this, this.changeBoard);
            tableIndex = 1;
        } else {
            gameLogic = new GameLogic9x9();
            board = new Board9x9(this, this.changeBoard);
            tableIndex = 2;
        }
        buttonTable = board.getButtonTable();
        createLogicTable();
        circleOrCross = this.guiHelper.isCrossOrCircle();
    }

    public void createLogicTable() {
        logicTable = new Cell[tableSize[tableIndex]][tableSize[tableIndex]];
        resetLogicTable();
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

    public void userAction(Button button) {
        if(!circleOrCross) {
            board.addCircle(button);
        } else {
            board.addCross(button);
        }
        action(button);
    }

    public void computerAction() {
        Button button = computerChoice();
        if(circleOrCross) {
            board.addCircle(button);
        } else {
            board.addCross(button);
        }
        action(button);
    }

    public Button computerChoice() {
        Button button = null;
        int random1;
        int random2;
        do {
            random1 = generator.nextInt(tableSize[tableIndex]);
            random2 = generator.nextInt(tableSize[tableIndex]);
            if(logicTable[random1][random2] == Cell.EMPTY) {
                button = buttonTable[random1][random2];
            }
        } while(logicTable[random1][random2] != Cell.EMPTY);

        return button;
    }


    public void action(Button button) {
        addElementsToLogicTable();
        if(gameLogic.isEndAndWhoWins(logicTable, buttonTable)) {
            endGame();
        }
        button.setOnAction(Event::consume);
    }


    public void newGame() {
        gameLogic.setEnded(false);
        gameLogic.setWhoWins(WhoWins.NOBODY);
        board.setNewButtonTable();
        buttonTable = board.getButtonTable();
        resetLogicTable();
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

    public void resetLogicTable() {
        for(int i = 0; i < tableSize[tableIndex]; i++) {
            for(int j = 0; j < tableSize[tableIndex]; j++) {
                logicTable[i][j] = Cell.EMPTY;
            }
        }

    }

    public Cell[][] addElementsToLogicTable() {
        for (int i = 0; i < tableSize[tableIndex]; i++) {
            for (int j = 0; j < tableSize[tableIndex]; j++) {
                if (buttonTable[i][j].getGraphic() instanceof Path) {
                    logicTable[i][j] = Cell.CROSS;
                } else if (buttonTable[i][j].getGraphic() instanceof Circle) {
                    logicTable[i][j] = Cell.CIRCLE;
                }
            }
        }
        return logicTable;
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

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public Board getBoard() {
        return board;
    }
}
