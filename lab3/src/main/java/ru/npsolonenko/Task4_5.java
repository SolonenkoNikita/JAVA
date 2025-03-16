package ru.npsolonenko;

public class Task4_5 {

    public static void main(String[] args) {

        IntSequence sequence = IntSequence.of(3, 1, 4, 1, 5, 9);

        while (sequence.hasNext())
            System.out.print(sequence.next() + " ");
        System.out.println();

        IntSequence constantSequence = IntSequence.constant(1);
        for (int i = 0; i < 5; ++i)
                System.out.print(constantSequence.next() + " ");
        System.out.println();

        IntSequence constantLambdaSequence = IntSequence.constantLambda(2);
        for (int i = 0; i < 25; ++i)
            System.out.print(constantLambdaSequence.next() + " ");
    }
}
