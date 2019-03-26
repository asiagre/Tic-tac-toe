package com.tictactoe.tic_tac_toe;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GUIHelper {

    private StackPane stackPane;
    private GameController gameController;
    private Board board;
    private Button summary;
    private boolean crossOrCircle = false;

    public GUIHelper(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public StackPane generateMenuVBox() {
        VBox vBox = generateDefaultVBox();
        vBox.setSpacing(30.0);
        Label label = ElementHelper.createLabel("This is the tic-tac-toe game. In this game you have to put circles or crosses in one of the compartments of the grid to get a row of three(3x3), four(6x6) or five(9x9) circles/crosses before the opponent does.");
        Button board3x3Button = new Button("3 x 3");
        board3x3Button.setOnAction(event -> {
            gameController = new GameController(this, ChangeBoard.THREE);
            board = gameController.getBoard();
            vBox.getChildren().clear();
            generateBoardVBox();
            if(crossOrCircle) {
                gameController.computerFirst();
            }
        });
        Button board6x6Button = new Button("6 x 6");
        board6x6Button.setOnAction(event -> {
            gameController = new GameController(this, ChangeBoard.SIX);
            board = gameController.getBoard();
            vBox.getChildren().clear();
            generateBoardVBox();
            if(crossOrCircle) {
                gameController.computerFirst();
            }
        });
        Button board9x9Button = new Button("9 x 9");
        board9x9Button.setOnAction(event -> {
            gameController = new GameController(this, ChangeBoard.NINE);
            board = gameController.getBoard();
            vBox.getChildren().clear();
            generateBoardVBox();
            if(crossOrCircle) {
                gameController.computerFirst();
            }
        });
        Label labelChoiceBox = ElementHelper.createLabel("Choice: circle or cross");
        labelChoiceBox.setAlignment(Pos.CENTER);
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("circle", "cross"));
        choiceBox.setOnAction(event -> {
            if (choiceBox.getValue().equalsIgnoreCase("cross")) {
                crossOrCircle = true;
            } else if (choiceBox.getValue().equalsIgnoreCase("circle")) {
                crossOrCircle = false;
            }
        });

        vBox.getChildren().addAll(label, labelChoiceBox, choiceBox, board3x3Button, board6x6Button, board9x9Button);
        stackPane.getChildren().add(vBox);

        return stackPane;
    }

    private void generateBoardVBox() {
        VBox vBox = generateDefaultVBox();
        summary = ElementHelper.createSummaryButton();
        summary.setOnAction(event -> generateResultVBox(gameController.getGameLogic().getWhoWins()));
        vBox.setSpacing(10.0);
        vBox.getChildren().addAll(board.createBoard(), summary);
        stackPane.getChildren().add(vBox);
    }

    private void generateResultVBox(WhoWins whoWins) {
        VBox vBox = generateDefaultVBox();
        vBox.setSpacing(30.0);
        Label label;
        if(whoWins.equals(WhoWins.CIRCLES)) {
            label = ElementHelper.createLabel("Circles won!".toUpperCase());
        } else if(whoWins.equals(WhoWins.CROSSES)) {
            label = ElementHelper.createLabel("Crosses won!".toUpperCase());
        } else {
            label = ElementHelper.createLabel("It is a draw".toUpperCase());
        }
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(50));

        HBox hBox = new HBox();
        hBox.setSpacing(30.0);
        hBox.setAlignment(Pos.CENTER);
        Button newGame = new Button("New game".toUpperCase());
        newGame.setOnAction(event -> {
            vBox.getChildren().clear();
            gameController.newGame();
            generateMenuVBox();
        });
        Button endGame = new Button("End game".toUpperCase());
        endGame.setOnAction(event -> Platform.exit());
        Text text = new Text();
        text.setText("Ranking: \nCircles' winnings: " + GameController.getCounterWinCircle() + "\nCrosses' winnings: " + GameController.getCounterWinCross() + "\nDraws: " + GameController.getCounterDraw());
        text.setFill(Color.WHITE);
        text.setFont(new Font(24));
        hBox.getChildren().addAll(newGame, endGame);
        vBox.getChildren().addAll(label, hBox, text);
        stackPane.getChildren().clear();
        stackPane.getChildren().add(vBox);
    }

    private static VBox generateDefaultVBox() {
        Image imageback = new Image("file/background.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        VBox vBox = new VBox();
        vBox.setBackground(background);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        return vBox;
    }

    public Button getSummary() {
        return summary;
    }

    public boolean isCrossOrCircle() {
        return crossOrCircle;
    }
}
