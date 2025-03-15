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

    public NewPoint translate(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public NewPoint scale(double value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    public String toString() {
        return "NewPoint {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        NewPoint p = new NewPoint(3, 4).translate(1, 1);
        System.out.println(p);
    }
}
