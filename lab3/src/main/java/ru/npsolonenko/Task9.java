package ru.npsolonenko;

import java.util.ArrayList;

public class Task9 {

    private static Runnable[] createTasks(int count, int countTime) {
        ArrayList<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < count; ++i)
            tasks.add(new Greeter(countTime, "Hello, " + i));
        return tasks.toArray(new Runnable[0]);
    }

    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks)
            new Thread(task).start();
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void main(String[] args) {

        Runnable[] tasks = createTasks(5, 5);

        //runTogether(tasks);

        runInOrder(tasks);
    }

}
