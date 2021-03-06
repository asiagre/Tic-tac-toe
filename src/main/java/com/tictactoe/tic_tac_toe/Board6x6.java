package com.tictactoe.tic_tac_toe;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class Board6x6 extends Board {

    public Board6x6(GameController gameController, ChangeBoard changeBoard) {
        super(gameController, changeBoard);
    }

    public Group lines() {
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

        Group group = new Group(lineH1, lineH2, lineH3, lineH4, lineH5, lineV1, lineV2, lineV3, lineV4, lineV5);

        return group;
    }
}
