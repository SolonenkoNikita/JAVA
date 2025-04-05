package ru.npsolonenko;

public class Calculator {

    public int add(int a, int b) {
        System.out.println("INT WITH TWO");
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("INT WITH THREE");
        return a + b + c;
    }

    public double add(double a, double b) {
        System.out.println("DOUBLE WITH TWO");
        return a + b;
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 6;
        Calculator c = new Calculator();
        c.add(a, b);
    }
}
