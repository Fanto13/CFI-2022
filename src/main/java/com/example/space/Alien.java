package com.example.space;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Alien {
    double x;
    double y;
    double vx;
    double vy;
    Image image;

    public Alien(double x, double y, double vx, double vy, Image image) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.image = image;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void paint(GraphicsContext gc) {
        //gc.drawImage(image, x, y);
        gc.setFill(Color.RED);
        gc.fillOval(x, y, 40, 40);
    }

    public Rectangle2D getBounds() {
        return new Rectangle2D(x, y, 40, 40);
    }

    @Override
    public String toString() {
        return "Missile{" + "x=" + x + ", y=" + y + ", vx=" + vx + ", vy=" + vy + ", image=" + image + '}';
    }
}
