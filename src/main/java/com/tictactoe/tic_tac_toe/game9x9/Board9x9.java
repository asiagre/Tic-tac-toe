package com.tictactoe.tic_tac_toe.game9x9;

import com.tictactoe.tic_tac_toe.ElementHelper;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;

public class Board9x9 {

    private GameController9x9 gameController9x9;
    private double buttonSize = 67.0;
    private double radius = 20.0;
    private double stroke = 7.0;
    private int buttonTableSize = 9;
    private double displacement = 15.0;
    private Button[][] buttonTable = createButtonTable();

    public Board9x9(GameController9x9 gameController9x9) {
        this.gameController9x9 = gameController9x9;
    }

    private Button createButton(double layoutX, double layoutY) {
        Button button = ElementHelper.createButton(layoutX, layoutY, buttonSize);
        button.setOnAction(event -> gameController9x9.onMouseClickAction(button));

        return button;
    }

    public Button[][] createButtonTable() {
        Button[][] buttonTable = new Button[buttonTableSize][buttonTableSize];
        for(int i = 0; i < buttonTableSize; i++) {
            for(int j = 0; j < buttonTableSize; j++) {
                buttonTable[i][j] = createButton((buttonSize * j + 198.0), (buttonSize * i + 198.0));
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
        Line lineH1 = ElementHelper.createLine(200, 267, 800, 268);
        Line lineH2 = ElementHelper.createLine(200, 334, 800, 334);
        Line lineH3 = ElementHelper.createLine(200, 400, 800, 400);
        Line lineH4 = ElementHelper.createLine(200, 467, 800, 467);
        Line lineH5 = ElementHelper.createLine(200, 534, 800, 534);
        Line lineH6 = ElementHelper.createLine(200, 600, 800, 600);
        Line lineH7 = ElementHelper.createLine(200, 667, 800, 667);
        Line lineH8 = ElementHelper.createLine(200, 734, 800, 734);
        Line lineV1 = ElementHelper.createLine(267, 200, 267, 800);
        Line lineV2 = ElementHelper.createLine(334, 200, 334, 800);
        Line lineV3 = ElementHelper.createLine(400, 200, 400, 800);
        Line lineV4 = ElementHelper.createLine(467, 200, 467, 800);
        Line lineV5 = ElementHelper.createLine(534, 200, 534, 800);
        Line lineV6 = ElementHelper.createLine(600, 200, 600, 800);
        Line lineV7 = ElementHelper.createLine(667, 200, 667, 800);
        Line lineV8 = ElementHelper.createLine(734, 200, 734, 800);

        GridPane grid = ElementHelper.createBoardGrid();
        Group group = new Group(lineH1, lineH2, lineH3, lineH4, lineH5, lineH6, lineH7, lineH8,
                lineV1, lineV2, lineV3, lineV4, lineV5, lineV6, lineV7, lineV8);
        for(Button[] btns : buttonTable) {
            for(Button btn : btns) {
                group.getChildren().add(btn);
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
