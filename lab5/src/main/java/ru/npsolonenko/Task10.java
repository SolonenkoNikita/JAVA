package ru.npsolonenko;

import java.util.Arrays;

public class Task10 {

    public static int factorialWithStackTrace(int number) {
        if (number == 1)
            return 1;
        Arrays.stream(new RuntimeException().getStackTrace()).forEach(System.out::println);
        return factorialWithStackTrace(number - 1) * number;
    }


    public static void main(String[] args) {
        System.out.println(factorialWithStackTrace(4));
    }
}
