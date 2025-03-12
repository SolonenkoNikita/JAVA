package ru.npsolonenko;

import java.util.Objects;

//all methods are generated automatically with commands or button Generate
public class NewPointEight
{
    private double x;

    private double y;

    public NewPointEight(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NewPointEight that = (NewPointEight) o;
        return Double.compare(x, that.x) == 0 && Double.compare(y, that.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "NewPointEight{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
