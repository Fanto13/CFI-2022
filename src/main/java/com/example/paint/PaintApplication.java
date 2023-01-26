package com.example.paint;

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

public class PaintApplication extends Application {
    Canvas canvas;
    Pane canvasPane;
    ColorPicker cpForeground;
    ColorPicker cpBackground;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.setPadding(new Insets(10));
        cpForeground = new ColorPicker();
        cpBackground = new ColorPicker();
        cpBackground.setOnAction(event -> {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.setFill(cpBackground.getValue());
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });
        cpForeground.setTooltip(new Tooltip("Select Foreground Color"));
        cpBackground.setTooltip(new Tooltip("Select Background Color"));
        hbox.getChildren().addAll(cpForeground, cpBackground);
        canvas = new Canvas(600, 600);
        canvasPane = new Pane();
        canvasPane.getChildren().add(canvas);
        canvasPane.setOnMouseClicked(event -> {
            drawPoint(event.getX(), event.getY());
        });
        canvasPane.setOnMouseDragged(event -> {
            drawPoint(event.getX(), event.getY());
        });
        BorderPane bp = new BorderPane();
        bp.setBottom(hbox);
        bp.setCenter(canvasPane);
        Scene scene = new Scene(bp);
        primaryStage.setTitle("Paint");
        primaryStage.setScene(scene);
        primaryStage.show();
        canvasPane.requestFocus();
    }

    public void drawPoint(double x, double y) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(cpForeground.getValue());
        gc.fillOval(x, y, 10, 10);
    }
}
