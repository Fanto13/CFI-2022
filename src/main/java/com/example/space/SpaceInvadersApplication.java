package com.example.space;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SpaceInvadersApplication extends Application {
    Canvas canvas;
    Pane canvasPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(800, 800);
        canvasPane = new Pane();
        canvasPane.getChildren().add(canvas);
        canvasPane.setOnMouseClicked(event -> {

        });
        canvasPane.setOnMouseMoved(event -> {

        });
        Scene scene = new Scene(canvasPane);
        primaryStage.setTitle("YA Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
