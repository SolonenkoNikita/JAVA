package ru.npsolonenko;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {

    private final int number;
    int count = 0;
    int size;

    DigitSequence(int number, int size) {
        this.number = number;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return size != count++;
    }

    @Override
    public Integer next() {
        return number;
    }

    @Override
    public void remove() {
    }
}
