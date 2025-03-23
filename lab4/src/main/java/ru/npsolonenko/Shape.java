package ru.npsolonenko;

public abstract class Shape {
    Point point;

    Shape(Point point) {
        this.point = point;
    }

    public void moveBy(int x, int y) {
        point = point.moveX(x).moveY(y);
    }

    public Point getCentre() {
        return point;
    }

    @Override
    public abstract Shape clone();
}
