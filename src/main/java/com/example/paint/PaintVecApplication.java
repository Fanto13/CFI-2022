package com.example.paint;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class PaintVecApplication extends Application {
    Canvas canvas;
    Pane canvasPane;
    ColorPicker cpForeground;
    ColorPicker cpBackground;
    Slider slider;
    List<Circle> circles;
    Timeline timeline;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        circles = new ArrayList<>();
        HBox hbox = new HBox();
        hbox.setSpacing(30);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.setPadding(new Insets(10));
        slider = new Slider(1, 50, 10);
        slider.setTooltip(new Tooltip("Circle Radius"));
        slider.setShowTickMarks(true);
        cpForeground = new ColorPicker();
        cpForeground.setTooltip(new Tooltip("Circle Color"));
        cpBackground = new ColorPicker();
        cpBackground.setOnAction(event -> {
            paint();
        });
        cpBackground.setTooltip(new Tooltip("Background Color"));
        cpBackground.setValue(Color.web("#456080"));
        hbox.getChildren().addAll(cpBackground, cpForeground, slider);
        canvas = new Canvas(600, 600);
        canvasPane = new Pane();
        canvasPane.getChildren().add(canvas);
        canvasPane.setOnMouseClicked(event -> {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Circle circle = new Circle(event.getX(), event.getY(), slider.getValue(), cpForeground.getValue());
            circle.paint(gc);
            circles.add(circle);
        });
        canvasPane.setOnMouseDragged(event -> {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Circle circle = new Circle(event.getX(), event.getY(), slider.getValue(), cpForeground.getValue());
            circle.paint(gc);
            circles.add(circle);
        });
        BorderPane bp = new BorderPane();
        bp.setBottom(hbox);
        bp.setCenter(canvasPane);
        Scene scene = new Scene(bp);
        primaryStage.setTitle("Paint");
        primaryStage.setScene(scene);
        primaryStage.show();
        initializeTimer();
    }

    public void initializeTimer() {
        timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> shortenList()),
                new KeyFrame(Duration.millis(50)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void paint() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // background
        gc.setFill(cpBackground.getValue());
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // foreground
        for (Circle c : circles) {
            c.paint(gc);
        }
    }

    public void shortenList() {
        int initialLength = circles.size();
        while (circles.size() > initialLength / 2) {
            circles.remove(0);
        }
        paint();
    }
}
