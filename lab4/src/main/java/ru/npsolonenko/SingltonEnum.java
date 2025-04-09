package ru.npsolonenko;

public class SingltonEnum {

    public enum Singleton {
        INSTANCE;

        public void doWork() {
            System.out.println("Doing work...");
        }
    }

}
