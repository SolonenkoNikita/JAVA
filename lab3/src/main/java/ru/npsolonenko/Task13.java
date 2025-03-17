package ru.npsolonenko;

public class Task13 {

    public static Runnable combineRunnables(Runnable[] runnables) {
        return () -> {
            for (Runnable r : runnables)
                r.run();
        };
    }

    public static void main(String[] args) {
        Runnable[] tasks = {
                () -> System.out.println("Task 1"),
                () -> System.out.println("Task 2"),
                () -> System.out.println("Task 3")
        };

        Runnable combinedTask = combineRunnables(tasks);
        combinedTask.run();
    }
}
