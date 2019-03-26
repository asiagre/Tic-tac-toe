package com.tictactoe.tic_tac_toe;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public abstract class Board {

    private GameController gameController;
    private ChangeBoard changeBoard;
    private double[] buttonSize = { 193.0, 100.0, 67.0 };
    private double[] buttonWidth = { 200.0, 100.0, 67.0 };
    private double[] radius = { 75.0, 30.0, 20.0 };
    private double[] stroke = { 15.0, 10.0, 7.0 };
    private int[] buttonTableSize = { 3, 6, 9 };
    private double[] displacement = { 97.0, 50.0, 15.0 };
    private double[] buttonsStart = { 203.0, 200.0, 198.0 };
    private Button[][] buttonTable;
    private int tableIndex;

    public Board(GameController gameController, ChangeBoard changeBoard) {
        this.gameController = gameController;
        this.changeBoard = changeBoard;
        if(this.changeBoard == ChangeBoard.THREE) {
            tableIndex = 0;
            buttonTable = createButtonTable();
        } else if(this.changeBoard == ChangeBoard.SIX) {
            tableIndex = 1;
            buttonTable = createButtonTable();
        } else {
            tableIndex = 2;
            buttonTable = createButtonTable();
        }
    }

    public Button createButton(double layoutX, double layoutY) {
        Button button = ElementHelper.createButton(layoutX, layoutY, buttonSize[tableIndex]);
        button.setOnAction(event -> gameController.onMouseClickAction(button));

        return button;
    }

    public Button[][] createButtonTable() {
        Button[][] createdButtonTable = new Button[buttonTableSize[tableIndex]][buttonTableSize[tableIndex]];
        for(int i = 0; i < buttonTableSize[tableIndex]; i++) {
            for(int j = 0; j < buttonTableSize[tableIndex]; j++) {
                createdButtonTable[i][j] = createButton((buttonWidth[tableIndex] * j + buttonsStart[tableIndex]), (buttonWidth[tableIndex] * i + buttonsStart[tableIndex]));
            }
        }

        return createdButtonTable;
    }

    public void addCircle(Button button) {
            ElementHelper.addCircle(button, displacement[tableIndex], radius[tableIndex], stroke[tableIndex]);
    }

    public void addCross(Button button) {
        ElementHelper.addCross(button, displacement[tableIndex], radius[tableIndex], stroke[tableIndex]);
    }

    public abstract Group lines();

    public GridPane createBoard() {

        GridPane grid = ElementHelper.createBoardGrid();
        Group group = lines();
        for(int i = 0; i < buttonTableSize[tableIndex]; i++) {
            for(int j = 0; j < buttonTableSize[tableIndex]; j++) {
                group.getChildren().add(buttonTable[i][j]);
            }
        }
        grid.add(group, 0, 1);

        return grid;
    }

    public Button[][] getButtonTable() {
        return buttonTable;
    }

    public void setNewButtonTable() {
        buttonTable = createButtonTable();
    }
}
