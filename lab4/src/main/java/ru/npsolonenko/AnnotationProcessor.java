package ru.npsolonenko;

import java.lang.reflect.Field;
import java.util.List;

public class AnnotationProcessor {

    public static <T> T set(Class<T> clazz, List<Pair<String, Object>> pairs) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Key.class)) {
                field.setAccessible(true);

                for (Pair<String, Object> pair : pairs) {
                    if (pair.getKey().equals(field.getName())) {
                        field.set(instance, pair.getValue());
                        break;
                    }
                }
            }
        }
        return instance;
    }
}
