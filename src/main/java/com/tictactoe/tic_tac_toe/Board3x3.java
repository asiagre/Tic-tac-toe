package com.tictactoe.tic_tac_toe;

import javafx.scene.Group;
import javafx.scene.shape.*;

public class Board3x3 extends Board{

    public Board3x3(GameController gameController, ChangeBoard changeBoard) {
        super(gameController, changeBoard);
    }

    public Group lines() {
        Line lineH1 = ElementHelper.createLine(200, 400, 800, 400);
        Line lineH2 = ElementHelper.createLine(200, 600, 800, 600);
        Line lineV1 = ElementHelper.createLine(400, 200, 400, 800);
        Line lineV2 = ElementHelper.createLine(600, 200, 600, 800);

        Group group = new Group(lineH1, lineH2, lineV1, lineV2);

        return group;
    }
}
