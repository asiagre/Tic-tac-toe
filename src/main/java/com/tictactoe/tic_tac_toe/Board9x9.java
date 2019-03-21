package com.tictactoe.tic_tac_toe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Board9x9 {

    private Button[][] buttonTable = createButtonTable();
    private GameController9x9 gameController9x9;

    public Board9x9(GameController9x9 gameController9x9) {
        this.gameController9x9 = gameController9x9;
    }

    private Button createButton(double layoutX, double layoutY) {
        Button button = new Button();
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setMinSize(64, 64);
        button.setBackground(Background.EMPTY);
        button.setOnAction(event -> {
            gameController9x9.onMouseClickAction(button);
        });

        return button;
    }

    public Label createLabel(String textGiven) {
        Label label = new Label();
        label.setText(textGiven);
        label.setPrefWidth(600);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setTextFill(Color.WHITESMOKE);
        label.setWrapText(true);
        label.setPadding(new Insets(10));
        label.setFont(new Font("Arial", 24));

        return label;
    }

    private Line createLine(double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(8.0);
        line.setStroke(Color.ANTIQUEWHITE.deriveColor(0.1, 0.2, 1.0, 0.6));

        return line;
    }

    private Circle createCircle(double centerX, double centerY) {
        Circle circle = new Circle();
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
        circle.setRadius(20);
        circle.setStroke(Color.WHITESMOKE);
        circle.setStrokeWidth(7.0);
        circle.setFill(Color.TRANSPARENT);

        return circle;
    }

    private Path createCross(double centerX, double centerY) {
        Path cross = new Path();
        double start1X = centerX - 20;
        double start1Y = centerY + 20;
        double end1X = centerX + 20;
        double end1Y = centerY - 20;
        double start2X = centerX - 20;
        double start2Y = centerY - 20;
        double end2X = centerX + 20;
        double end2Y = centerY + 20;
        cross.getElements().addAll(new MoveTo(start1X, start1Y), new LineTo(end1X, end1Y), new MoveTo(start2X, start2Y), new LineTo(end2X, end2Y), new ClosePath());
        cross.setStroke(Color.WHITESMOKE);
        cross.setStrokeWidth(7.0);

        return cross;
    }

    public void addCircle(Button button) {
        double centerX = button.getLayoutX() + 15.0;
        double centerY = button.getLayoutY() + 15.0;
        Circle circle = createCircle(centerX, centerY);
        button.setGraphic(circle);
    }

    public void addCross(Button button) {
        double centerX = button.getLayoutX() + 15.0;
        double centerY = button.getLayoutY() + 15.0;
        Path cross = createCross(centerX, centerY);
        button.setGraphic(cross);
    }

    public Button[][] createButtonTable() {
        buttonTable = new Button[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                buttonTable[i][j] = createButton((67 * j + 200), (67 * i + 200));
            }
        }

        return buttonTable;
    }

    public GridPane createBoard() {
        Label label = createLabel("Make your move");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));
        Line lineH1 = createLine(200, 267, 800, 268);
        Line lineH2 = createLine(200, 334, 800, 334);
        Line lineH3 = createLine(200, 400, 800, 400);
        Line lineH4 = createLine(200, 467, 800, 467);
        Line lineH5 = createLine(200, 534, 800, 534);
        Line lineH6 = createLine(200, 600, 800, 600);
        Line lineH7 = createLine(200, 667, 800, 667);
        Line lineH8 = createLine(200, 734, 800, 734);
        Line lineV1 = createLine(267, 200, 267, 800);
        Line lineV2 = createLine(334, 200, 334, 800);
        Line lineV3 = createLine(400, 200, 400, 800);
        Line lineV4 = createLine(467, 200, 467, 800);
        Line lineV5 = createLine(534, 200, 534, 800);
        Line lineV6 = createLine(600, 200, 600, 800);
        Line lineV7 = createLine(667, 200, 667, 800);
        Line lineV8 = createLine(734, 200, 734, 800);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15.5);
        grid.setVgap(15.5);
        grid.add(label, 0, 0);
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

    public Button createSummaryButton() {
        Button summary = new Button("Click to continue".toUpperCase());
        summary.setPrefSize(200, 40);
        summary.setTextFill(Color.WHITESMOKE);
        summary.setVisible(false);
        summary.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));

        return summary;
    }

    public Button[][] getButtonTable() {
        return buttonTable;
    }

    public void setNewButtonTable() {
        buttonTable = createButtonTable();
    }
}
