package com.example.space;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class SpaceShip {
    double x;
    double y;
    double life;
    Image image;

    public SpaceShip(double x, double y, Image image) {
        this.x = x;
        this.y = y;
        this.life = 1.0;
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

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void paint(GraphicsContext gc) {
        gc.drawImage(image, x, y);
    }

    @Override
    public String toString() {
        return "SpaceShip{" + "x=" + x + ", y=" + y + ", life=" + life + ", image=" + image + '}';
    }
}
