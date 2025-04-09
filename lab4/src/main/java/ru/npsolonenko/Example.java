package ru.npsolonenko;

public enum Example {

    INSTANCE;

    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
