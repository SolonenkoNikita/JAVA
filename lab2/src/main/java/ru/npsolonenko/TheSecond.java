package ru.npsolonenko;

import java.util.Random;
import java.util.Scanner;

public class TheSecond {
    public static void main (String[] argv) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        //модифицирующий, т.к. вызывает метод setRadix();

        Random random = new Random();
        random.nextInt();
        //метод доступа, не изменяет поля
    }
}