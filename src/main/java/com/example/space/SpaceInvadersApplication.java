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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SpaceInvadersApplication extends Application {
    Image backgroundImage;
    Canvas canvas;
    Pane canvasPane;
    Timeline timeline;
    SpaceShip ship;
    List<Missile> missiles;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"), 1200, 800, false, true);
        // ship
        Image image = new Image(getClass().getResourceAsStream("spaceship.png"), 100, 100, true, true);
        ship = new SpaceShip(550, 650, image);
        // missiles
        missiles = new ArrayList<>();
        // canvas
        canvas = new Canvas(1200, 800);
        canvasPane = new Pane();
        canvasPane.getChildren().add(canvas);
        canvasPane.setOnMouseClicked(event -> {
            missiles.add(new Missile(ship.getX() + ship.getBounds().getWidth() / 2,
                    ship.getY() - ship.getBounds().getHeight() / 5, 0.0, -10.0, null));
        });
        canvasPane.setOnMouseMoved(event -> {
            ship.setX(event.getX());
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
        for (ListIterator<Missile> i = missiles.listIterator(); i.hasNext();) {
            Missile m = i.next();
            m.setY(m.getY() + m.getVy());
            if (m.getY() < 0) {
                i.remove();
            }
        }
        paint();
    }

    public void paint() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // background
        gc.drawImage(backgroundImage, 0,0);
        // spaceship
        ship.paint(gc);
        // missiles
        for (Missile m : missiles) {
            m.paint(gc);
        }
        // aliens
        /*
        for (Alien a : aliens) {
            a.paint();
        }
        */
    }
}
