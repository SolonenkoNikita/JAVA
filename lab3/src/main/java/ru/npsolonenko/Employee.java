package ru.npsolonenko;

public class Employee implements Measurable {

    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }

    static Measurable largest(Measurable[] objects) {
        if (objects == null || objects.length == 0)
            throw new IllegalArgumentException("Array should be over 0 and not null");

        Measurable maxObject = objects[0];
        for (Measurable obj : objects) {
            if (obj.getMeasure() > maxObject.getMeasure())
                maxObject = obj;
        }

        return maxObject;
    }

    static double average(Measurable[] objects) {
        if (objects == null || objects.length == 0)
            throw new IllegalArgumentException("Array should be over 0 and not null");

        double sum = 0;
        for (Measurable obj : objects)
            sum += obj.getMeasure();

        return sum / objects.length;
    }

}
