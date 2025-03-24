package ru.npsolonenko;

public class Task13 {

    public static void main(String[] args) {
        Runnable[] tasks = {
                () -> System.out.println("Task 1"),
                () -> System.out.println("Task 2"),
                () -> System.out.println("Task 3")
        };

        Runnable combinedRunnable = () -> {
            for (Runnable r : tasks)
                r.run();
        };

        combinedRunnable.run(); 
    }
}
