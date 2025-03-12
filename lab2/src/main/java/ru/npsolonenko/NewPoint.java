package ru.npsolonenko;

public class NewPoint {
    private double x;
    private double y;

    public NewPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public NewPoint() {

        this(0.0, 0.0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void scale(double value) {
        this.x *= value;
        this.y *= value;
    }
}
