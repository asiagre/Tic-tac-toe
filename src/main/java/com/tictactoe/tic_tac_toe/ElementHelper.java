package com.tictactoe.tic_tac_toe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    public static Button createButton(double layoutX, double layoutY, double size) {
        Button button = new Button();
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setMinSize(size, size);
        button.setBackground(Background.EMPTY);

        return button;
    }

    public static Label createLabel(String textGiven) {
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

    public static Line createLine(double startX, double startY, double endX, double endY) {
        Line line = new Line(startX, startY, endX, endY);
        line.setStrokeWidth(8.0);
        line.setStroke(Color.ANTIQUEWHITE.deriveColor(0.1, 0.2, 1.0, 0.6));

        return line;
    }

    public static Circle createCircle(double centerX, double centerY, double radius, double stroke) {
        Circle circle = new Circle();
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
        circle.setRadius(radius);
        circle.setStroke(Color.WHITESMOKE);
        circle.setStrokeWidth(stroke);
        circle.setFill(Color.TRANSPARENT);

        return circle;
    }

    public static Path createCross(double centerX, double centerY, double radius, double stroke) {
        Path cross = new Path();
        double start1X = centerX - radius;
        double start1Y = centerY + radius;
        double end1X = centerX + radius;
        double end1Y = centerY - radius;
        double start2X = centerX - radius;
        double start2Y = centerY - radius;
        double end2X = centerX + radius;
        double end2Y = centerY + radius;
        cross.getElements().addAll(new MoveTo(start1X, start1Y), new LineTo(end1X, end1Y), new MoveTo(start2X, start2Y), new LineTo(end2X, end2Y), new ClosePath());
        cross.setStroke(Color.WHITESMOKE);
        cross.setStrokeWidth(stroke);

        return cross;
    }

    public static void addCircle(Button button, double displacement, double radius, double stroke) {
        double centerX = button.getLayoutX() + displacement;
        double centerY = button.getLayoutY() + displacement;
        Circle circle = createCircle(centerX, centerY, radius, stroke);
        button.setGraphic(circle);
    }

    public static void addCross(Button button, double displacement, double radius, double stroke) {
        double centerX = button.getLayoutX() + displacement;
        double centerY = button.getLayoutY() + displacement;
        Path cross = createCross(centerX, centerY, radius, stroke);
        button.setGraphic(cross);
    }

    public static GridPane createBoardGrid() {

        Label label = createLabel("Make your move");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15.5);
        grid.setVgap(15.5);
        grid.add(label, 0, 0);

        return grid;
    }

    public static Button createSummaryButton() {
        Button summary = new Button("Click to continue".toUpperCase());
        summary.setPrefSize(200, 40);
        summary.setTextFill(Color.WHITESMOKE);
        summary.setVisible(false);
        summary.setBackground(new Background(new BackgroundFill(Color.DARKBLUE, null, null)));

        return summary;
    }

    public static void coloringButton(Button button) {
        button.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        button.setOpacity(0.8);
    }
}
