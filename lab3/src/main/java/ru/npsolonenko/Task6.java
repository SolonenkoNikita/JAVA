package ru.npsolonenko;

public class Task6 {

    public static void main(String[] args) {
        DigitSequence digitSequence = new DigitSequence(100, 10);
        digitSequence.remove();
        while (digitSequence.hasNext())
            System.out.println(digitSequence.next());
    }
}
