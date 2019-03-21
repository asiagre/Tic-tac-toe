package com.tictactoe.tic_tac_toe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToeApplication extends Application {

    private StackPane stackPane = new StackPane();
    private GUIHelper guiHelper = new GUIHelper(stackPane);


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        StackPane firstStackPane = guiHelper.generateMenuVBox();
        stackPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        Scene scene = new Scene(firstStackPane, 1600, 900, Color.BLACK);

        primaryStage.setTitle("TIC TAC TOE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
