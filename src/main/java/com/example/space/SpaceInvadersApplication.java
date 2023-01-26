package com.example.space;

import com.example.paint.Circle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpaceInvadersApplication extends Application {
    final Color backgroundColor = Color.web("#1010AA");
    Image backgroundImage;
    Canvas canvas;
    Pane canvasPane;
    Timeline timeline;
    SpaceShip ship;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"), 1200, 800, false, true);
        Image image = new Image(getClass().getResourceAsStream("spaceship.png"), 100, 100, true, true);
        ship = new SpaceShip(550, 650, image);
        canvas = new Canvas(1200, 800);
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
        initializeTimer();
    }

    public void initializeTimer() {
        timeline = new Timeline(new KeyFrame(Duration.ZERO, event -> mainLoop()),
                new KeyFrame(Duration.millis(30)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void mainLoop() {
        paint();
    }

    public void paint() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // background
        gc.setFill(backgroundColor);
        gc.drawImage(backgroundImage, 0,0);
        //gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // spaceship
        ship.paint(gc);
        // aliens
        /*
        for (Alien a : aliens) {
            a.paint();
        }
        */
    }
}
