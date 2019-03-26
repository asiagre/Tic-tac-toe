package com.tictactoe.tic_tac_toe;

import javafx.scene.Group;
import javafx.scene.shape.*;

public class Board9x9 extends Board{

    public Board9x9(GameController gameController, ChangeBoard changeBoard) {
        super(gameController, changeBoard);
    }

    public Group lines() {
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

        Group group = new Group(lineH1, lineH2, lineH3, lineH4, lineH5, lineH6, lineH7, lineH8,
                lineV1, lineV2, lineV3, lineV4, lineV5, lineV6, lineV7, lineV8);

        return group;
    }
}
