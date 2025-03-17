package ru.npsolonenko;

import java.util.Random;

public interface IntSequence {
    int next();

    default boolean hasNext() {
        return true;
    }

    static IntSequence of(int... values) {
        return new IntSequence() {
            private int index = 0;

            @Override
            public int next() {
                if (!hasNext())
                    throw new IllegalStateException("No more elements");
                return values[index++];
            }

            @Override
            public boolean hasNext() {
                return index < values.length;
            }
        };
    }

    static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public int next() {
                return value;
            }
        };
    }

    static IntSequence constantLambda(int value) {
        return () -> value;
    }

    class RandomSequence implements IntSequence {

        final Random generator = new Random();
        int high;
        int low;

        public RandomSequence(int low, int high) {
            this.high = high;
            this.low = low;
        }

        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }
}
