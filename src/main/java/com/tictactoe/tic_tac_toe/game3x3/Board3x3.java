package com.tictactoe.tic_tac_toe.game3x3;

import com.tictactoe.tic_tac_toe.ElementHelper;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;

public class Board3x3 {

    private GameController3x3 gameController3x3;
    private double buttonSize = 193.0;
    private double radius = 75;
    private double stroke = 15.0;
    private int buttonTableSize = 3;
    private double buttonWidth = 200.0;
    private double displacement = 97.0;
    private Button[][] buttonTable = createButtonTable();


    public Board3x3(GameController3x3 gameController3x3) {
        this.gameController3x3 = gameController3x3;
    }

    private Button createButton(double layoutX, double layoutY) {
        Button button = ElementHelper.createButton(layoutX, layoutY, buttonSize);
        button.setOnAction(event -> gameController3x3.onMouseClickAction(button));

        return button;
    }

    private Button[][] createButtonTable() {
        Button[][] buttonTable = new Button[buttonTableSize][buttonTableSize];
        for(int i = 0; i < buttonTableSize; i++) {
            for(int j = 0; j < buttonTableSize; j++) {
                buttonTable[i][j] = createButton((buttonWidth * j + 203.0), (buttonWidth * i + 203.0));
            }
        }

        return buttonTable;
    }

    public void addCircle(Button button) {
        ElementHelper.addCircle(button, displacement, radius, stroke);
    }

    public void addCross(Button button) {
        ElementHelper.addCross(button, displacement, radius, stroke);
    }

    public GridPane createBoard() {
        Line lineH1 = ElementHelper.createLine(200, 400, 800, 400);
        Line lineH2 = ElementHelper.createLine(200, 600, 800, 600);
        Line lineV1 = ElementHelper.createLine(400, 200, 400, 800);
        Line lineV2 = ElementHelper.createLine(600, 200, 600, 800);

        GridPane grid = ElementHelper.createBoardGrid();
        Group group = new Group(lineH1, lineH2, lineV1, lineV2);
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
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
