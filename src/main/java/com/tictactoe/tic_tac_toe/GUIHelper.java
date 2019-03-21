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
    private GameController gameController = new GameController(this);
    private ElementHelper elementHelper = gameController.getElementHelper();
    private GameController9x9 gameController9x9 = new GameController9x9(this);
    private Board9x9 board9x9 = new Board9x9(gameController9x9);
    private Button summary;
    private boolean crossOrCircle = false;

    public GUIHelper(StackPane stackPane) {
        this.stackPane = stackPane;
    }

    public StackPane generateMenuVBox() {
        VBox vBox = generateDefaultVBox();
        vBox.setSpacing(30.0);
        Label label = elementHelper.createLabel("This is the game tic-tac-toe. In this game you have to put circles or crosses in one of the compartments of the grid to get a row of three circles/crosses before the opponent does.");
        Button startGame = new Button("Start game".toUpperCase());
        Button board9x9Button = new Button("9 x 9");
        board9x9Button.setOnAction(event -> {
            vBox.getChildren().clear();
            generateBoard9x9VBox();
            if(crossOrCircle) {
                gameController9x9.computerFirst();
            }
        });
        startGame.setPrefSize(150, 50);
        startGame.setOnAction(event -> {
            vBox.getChildren().clear();
            generateBoardVBox();
            if(crossOrCircle) {
                gameController.computerFirst();
            }
        });
        Label labelChoiceBox = elementHelper.createLabel("Choice: circle or cross");
        labelChoiceBox.setAlignment(Pos.CENTER);
        ChoiceBox<String> choiceBox = new ChoiceBox<>(FXCollections.observableArrayList("circle", "cross"));
        choiceBox.setOnAction(event -> {
            if (choiceBox.getValue().equalsIgnoreCase("cross")) {
                crossOrCircle = true;
            } else if (choiceBox.getValue().equalsIgnoreCase("circle")) {
                crossOrCircle = false;
            }
        });

        vBox.getChildren().addAll(label, labelChoiceBox, choiceBox, startGame, board9x9Button);
        stackPane.getChildren().add(vBox);

        return stackPane;
    }

    private StackPane generateBoardVBox() {
        VBox vBox = generateDefaultVBox();
        summary = elementHelper.createSummaryButton();
        summary.setOnAction(e -> {
            generateResultVBox(gameController.getGameLogic().getWhoWins());
        });
        vBox.setSpacing(10.0);
        vBox.getChildren().addAll(elementHelper.createBoard(), summary);
        stackPane.getChildren().add(vBox);

        return stackPane;
    }

    private StackPane generateBoard9x9VBox() {
        VBox vBox = generateDefaultVBox();
        summary = board9x9.createSummaryButton();
        summary.setOnAction(e -> {
            generateResultVBox(gameController9x9.getGameLogic9x9().getWhoWins());
        });
        vBox.setSpacing(10.0);
        vBox.getChildren().addAll(board9x9.createBoard(), summary);
        stackPane.getChildren().add(vBox);

        return stackPane;
    }

    private StackPane generateResultVBox(WhoWins whoWins) {
        VBox vBox = generateDefaultVBox();
        vBox.setSpacing(30.0);
        Label label;
        if(whoWins.equals(WhoWins.CIRCLES)) {
            label = elementHelper.createLabel("Circles won!".toUpperCase());
        } else if(whoWins.equals(WhoWins.CROSSES)) {
            label = elementHelper.createLabel("Crosses won!".toUpperCase());
        } else {
            label = elementHelper.createLabel("It is a draw".toUpperCase());
        }
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(50));

        HBox hBox = new HBox();
        hBox.setSpacing(30.0);
        hBox.setAlignment(Pos.CENTER);
        Button newGame = new Button("New game".toUpperCase());
        newGame.setOnAction(event -> {
            vBox.getChildren().clear();
            elementHelper.setNewButtonTable();
            board9x9.setNewButtonTable();
            generateMenuVBox();
            gameController.newGame();
            gameController9x9.newGame();
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

        return stackPane;
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
