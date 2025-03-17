package ru.npsolonenko;

import java.util.Comparator;

public class Task15 {
    public static void main(String[] args) {
        IntSequence randomSequence = new IntSequence.RandomSequence(-1000, 1000);
        for (int i = 0; i < 10; ++i)
            System.out.println(randomSequence.next());
    }
}