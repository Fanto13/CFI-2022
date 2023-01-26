package com.example.space;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.random.RandomGenerator;

public class SpaceInvadersApplication extends Application {
    Image backgroundImage, shipImage, alienImage, alienBomb, missileImage;
    Canvas canvas;
    Pane canvasPane;
    Timeline mainTimeline;
    Timeline secondTimeline;
    SpaceShip ship;
    List<Missile> shipMissiles;
    List<Missile> alienMissiles;
    List<Alien> aliens;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loadResorces();
        // canvas
        canvas = new Canvas(1200, 800);
        canvasPane = new Pane();
        canvasPane.getChildren().add(canvas);
        canvasPane.setOnMouseClicked(event -> shipMissiles.add(new Missile(ship.getX() + ship.getBounds().getWidth() / 5, ship.getY() - ship.getBounds().getHeight() / 5, 0.0, -10.0, missileImage)));
        canvasPane.setOnMouseMoved(event -> ship.setX(event.getX()));
        Scene scene = new Scene(canvasPane);
        primaryStage.setTitle("YA Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        initializeGameObjects();
        initializeTimers();
    }

    public void loadResorces() {
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"), 1200, 800, false, true);
        missileImage = new Image(getClass().getResourceAsStream("missile.png"), 50, 50, false, true);
        shipImage = new Image(getClass().getResourceAsStream("spaceship.png"), 80, 80, false, true);
        alienImage = new Image(getClass().getResourceAsStream("alien.png"), 70, 70, false, true);
        alienBomb = new Image(getClass().getResourceAsStream("alienbomb.png"), 50, 50, false, true);
    }

    public void initializeTimers() {
        // every 30ms
        mainTimeline = new Timeline(new KeyFrame(Duration.ZERO, event -> mainTimeline()), new KeyFrame(Duration.millis(30)));
        mainTimeline.setCycleCount(Timeline.INDEFINITE);
        mainTimeline.play();
        // every second
        secondTimeline = new Timeline(new KeyFrame(Duration.ZERO, event -> secondTimeline()), new KeyFrame(Duration.millis(1000)));
        secondTimeline.setCycleCount(Timeline.INDEFINITE);
        secondTimeline.play();
    }

    public void initializeGameObjects() {
        shipMissiles = new ArrayList<>();
        alienMissiles = new ArrayList<>();
        ship = new SpaceShip(550, 650, shipImage);
        aliens = new ArrayList<>();
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 7; col++) {
                aliens.add(new Alien(200 + 120 * col, 100 + 70 * row, 0.3, 0.2, alienImage));
            }
        }
    }

    public void mainTimeline() {
        for (ListIterator<Missile> i = shipMissiles.listIterator(); i.hasNext(); ) {
            Missile m = i.next();
            m.setY(m.getY() + m.getVy());
            if (m.getY() < 0) {
                i.remove();
            }
            for (ListIterator<Alien> j = aliens.listIterator(); j.hasNext(); ) {
                Alien a = j.next();
                if (a.getBounds().intersects(m.getBounds())) {
                    i.remove();
                    j.remove();
                }
            }
        }
        for (ListIterator<Missile> i = alienMissiles.listIterator(); i.hasNext(); ) {
            Missile m = i.next();
            m.setY(m.getY() + m.getVy());
            if (m.getY() > canvasPane.getHeight()) {
                i.remove();
            }
            if (m.getBounds().intersects(ship.getBounds())) {
                endGame("You Loose! Click OK to restart.");
            }
        }
        for (Alien alien : aliens) {
            alien.setX(alien.getX() + alien.getVx());
            alien.setY(alien.getY() + alien.getVy());
        }
        if (aliens.size() == 0) {
            endGame("You Won! Click OK to restart.");
        }
        paint();
    }

    public void secondTimeline() {
        RandomGenerator rnd = RandomGenerator.of("Random");
        Alien a = aliens.get(rnd.nextInt(aliens.size()));
        alienMissiles.add(new Missile(a.getX() + a.getBounds().getWidth() / 5, a.getY() + a.getBounds().getHeight(), 0.0, 10.0, alienBomb));
        for (Alien i : aliens) {
            i.setVx(-i.getVx());
        }
    }

    public void endGame(String message) {
        mainTimeline.stop();
        secondTimeline.stop();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(null);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.setOnHidden(evt -> {
            initializeGameObjects();
            initializeTimers();
        });
        alert.show();
    }

    public void paint() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // background
        gc.drawImage(backgroundImage, 0, 0);
        // spaceship
        ship.paint(gc);
        // aliens
        for (Alien a : aliens) {
            a.paint(gc);
        }
        // missiles
        for (Missile m : shipMissiles) {
            m.paint(gc);
        }
        // alien missiles
        for (Missile m : alienMissiles) {
            m.paint(gc);
        }
    }
}
