package com.tictactoe.tic_tac_toe.game6x6;

import com.tictactoe.tic_tac_toe.ElementHelper;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;

public class Board6x6 {

    private GameController6x6 gameController6x6;
    private double buttonSize = 100.0;
    private double radius = 30.0;
    private double stroke = 10.0;
    private int buttonTableSize = 6;
    private double displacement = 50.0;
    private Button[][] buttonTable = createButtonTable();

    public Board6x6(GameController6x6 gameController6x6) {
        this.gameController6x6 = gameController6x6;
    }

    private Button createButton(double layoutX, double layoutY) {
        Button button = ElementHelper.createButton(layoutX, layoutY, buttonSize);
        button.setOnAction(event -> gameController6x6.onMouseClickAction(button));

        return button;
    }

    private Button[][] createButtonTable() {
        Button[][] buttonTable = new Button[buttonTableSize][buttonTableSize];
        for(int i = 0; i < buttonTableSize; i++) {
            for(int j = 0; j < buttonTableSize; j++) {
                buttonTable[i][j] = createButton((buttonSize * j + 200.0), (buttonSize * i + 200.0));
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
        Line lineH1 = ElementHelper.createLine(200, 300, 800, 300);
        Line lineH2 = ElementHelper.createLine(200, 400, 800, 400);
        Line lineH3 = ElementHelper.createLine(200, 500, 800, 500);
        Line lineH4 = ElementHelper.createLine(200, 600, 800, 600);
        Line lineH5 = ElementHelper.createLine(200, 700, 800, 700);
        Line lineV1 = ElementHelper.createLine(300, 200, 300, 800);
        Line lineV2 = ElementHelper.createLine(400, 200, 400, 800);
        Line lineV3 = ElementHelper.createLine(500, 200, 500, 800);
        Line lineV4 = ElementHelper.createLine(600, 200, 600, 800);
        Line lineV5 = ElementHelper.createLine(700, 200, 700, 800);

        GridPane grid = ElementHelper.createBoardGrid();
        Group group = new Group(lineH1, lineH2, lineH3, lineH4, lineH5, lineV1, lineV2, lineV3, lineV4, lineV5);
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
