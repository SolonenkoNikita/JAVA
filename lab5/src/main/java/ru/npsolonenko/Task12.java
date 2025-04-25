package ru.npsolonenko;

import java.util.Arrays;
import java.util.Random;

public class Task12 {

    private static final int MAX_NUMBER = 10000;

    public static void main(String[] args) {
        int[] array = generateRandomArrayBySize(100000000);
        long start = System.currentTimeMillis();
        System.out.println(min(array));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    public static int min(int[] values) {
        if (values.length < 1)
            throw new IllegalArgumentException("values.length == 0");

        int minNumber = Arrays.stream(values).min().getAsInt();
        assert Arrays.stream(values).allMatch(value -> value >= minNumber);
        return minNumber;
    }

    public static int[] generateRandomArrayBySize(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; ++i)
            array[i] = random.nextInt(MAX_NUMBER);
        return array;
    }

}
