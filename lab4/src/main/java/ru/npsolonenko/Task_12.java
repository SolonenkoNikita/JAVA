package ru.npsolonenko;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class Task_12 {

    public static void main(String[] args) {
        Point point = new Point(0, 1);

        int[] iterations = { 100, 1000, 10000, 100000,
                200000, 1000000, 2000000, 3000000,
                10000000, 20000000, 30000000};

        try (FileWriter writer = new FileWriter("results.txt")) {
            writer.write("Iterations,DirectTime(ms),ReflectionTime(ms)\n");

            for (int iter : iterations) {
                long timeDirect = System.currentTimeMillis();
                for (int j = 0; j < iter; ++j)
                    point.getX();

                long directTime = System.currentTimeMillis() - timeDirect;

                long reflectionTime = 0;
                try {
                    Method method = point.getClass().getMethod("getX");
                    long timeReflection = System.currentTimeMillis();
                    for (int j = 0; j < iter; ++j)
                        method.invoke(point);
                    reflectionTime = System.currentTimeMillis() - timeReflection;
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                writer.write(iter + "," + directTime + "," + reflectionTime + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
