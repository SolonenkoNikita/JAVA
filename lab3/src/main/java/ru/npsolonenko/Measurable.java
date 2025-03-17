package ru.npsolonenko;

public interface Measurable {

    double getMeasure();

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
}
