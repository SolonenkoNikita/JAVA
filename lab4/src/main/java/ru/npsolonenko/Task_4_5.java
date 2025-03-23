package ru.npsolonenko;

public class Task_4_5 {

    public static void main(String[] args) {
        Line line = new Line(new Point(-1, 100), new Point(31.5, -12));
        Rectangle rectangle = new Rectangle(new Point(0, 11), 0.5, 5);
        Circle circle = new Circle(new Point(0, 0), 10);

        System.out.println(line);
        System.out.println(rectangle);
        System.out.println(circle);

        Line lineCopy = line.clone();
        Rectangle rectangleCopy = rectangle.clone();
        Circle circleCopy = circle.clone();

        System.out.println("\n\n");
        System.out.println(lineCopy);
        System.out.println(rectangleCopy);
        System.out.println(circleCopy);
    }
}
