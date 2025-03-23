package ru.npsolonenko;

public class Line extends Shape {

    private Point pointTo;

    public Line(Point pointFrom, Point pointTo) {
        super(pointFrom);
        this.pointTo = pointTo;
    }

    public Point getPointTo() {
        return pointTo;
    }

    public void setPointTo(Point pointTo) {
        this.pointTo = pointTo;
    }

    @Override
    public String toString() {
        return " Line { pointFrom = " + point +
                ", pointTo = " + pointTo +
                " }";
    }

    @Override
    public Line clone() {
        return new Line(point, pointTo);
    }
}
