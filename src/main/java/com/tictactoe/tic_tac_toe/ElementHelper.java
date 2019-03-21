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

public class ElementHelper {

    private Button[][] buttonTable = createButtonTable();
    private GameController gameController;

    public ElementHelper(GameController gameController) {
        this.gameController = gameController;
    }

    private Button createButton(double layoutX, double layoutY) {
        Button button = new Button();
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setMinSize(193, 193);
        button.setBackground(Background.EMPTY);
        button.setOnAction(event -> {
            gameController.onMouseClickAction(button);
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
        circle.setRadius(75);
        circle.setStroke(Color.WHITESMOKE);
        circle.setStrokeWidth(15.0);
        circle.setFill(Color.TRANSPARENT);

        return circle;
    }

    private Path createCross(double centerX, double centerY) {
        Path cross = new Path();
        double start1X = centerX - 75;
        double start1Y = centerY + 75;
        double end1X = centerX + 75;
        double end1Y = centerY - 75;
        double start2X = centerX - 75;
        double start2Y = centerY - 75;
        double end2X = centerX + 75;
        double end2Y = centerY + 75;
        cross.getElements().addAll(new MoveTo(start1X, start1Y), new LineTo(end1X, end1Y), new MoveTo(start2X, start2Y), new LineTo(end2X, end2Y), new ClosePath());
        cross.setStroke(Color.WHITESMOKE);
        cross.setStrokeWidth(15.0);

        return cross;
    }

    public void addCircle(Button button) {
        double centerX = button.getLayoutX() + 97.0;
        double centerY = button.getLayoutY() + 97.0;
        Circle circle = createCircle(centerX, centerY);
        button.setGraphic(circle);
    }

    public void addCross(Button button) {
        double centerX = button.getLayoutX() + 97.0;
        double centerY = button.getLayoutY() + 97.0;
        Path cross = createCross(centerX, centerY);
        button.setGraphic(cross);
    }

    public Button[][] createButtonTable() {
        buttonTable = new Button[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                buttonTable[i][j] = createButton((200 * j + 203), (200 * i + 203));
            }
        }

        return buttonTable;
    }

    public GridPane createBoard() {
        Label label = createLabel("Make your move");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));
        Line lineH1 = createLine(200, 400, 800, 400);
        Line lineH2 = createLine(200, 600, 800, 600);
        Line lineV1 = createLine(400, 200, 400, 800);
        Line lineV2 = createLine(600, 200, 600, 800);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15.5);
        grid.setVgap(15.5);
        grid.add(label, 0, 0);
        Group group = new Group(lineH1, lineH2, lineV1, lineV2, buttonTable[0][0], buttonTable[0][1], buttonTable[0][2], buttonTable[1][0], buttonTable[1][1], buttonTable[1][2], buttonTable[2][0], buttonTable[2][1], buttonTable[2][2]);
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
