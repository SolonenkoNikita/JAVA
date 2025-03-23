package ru.npsolonenko;

public class Task1_2_3 {

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = null;

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));

        LabeledPoint lp1 = new LabeledPoint("Nikita", 1, 1);
        LabeledPoint lp2 = new LabeledPoint("Nikita", 1, 1);
        LabeledPoint lp3 = new LabeledPoint("Nik", 1, 1);

        System.out.println(lp1.equals(p2));
        System.out.println(lp1.equals(lp2));
        System.out.println(lp1.equals(lp3));

        lp1.x = 5; //change value -> the field is available

    }


}
