package ru.npsolonenko;

public class Circle extends Shape{

    private double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return " Circle { radius = " + radius +  ", centre = " + point +  " }";
    }

    @Override
    public Circle clone() {
        return new Circle(point, radius);
    }
}
