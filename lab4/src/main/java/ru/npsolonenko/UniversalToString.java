package ru.npsolonenko;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UniversalToString {

    public static String toString(Object obj) {
        if (obj == null)
            return "null";

        Class<?> clazz = obj.getClass();
        List<String> fieldStrings = new ArrayList<>();

        while (clazz != null && clazz != Object.class) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    fieldStrings.add(field.getName() + "=" + value);
                }
                catch (IllegalAccessException e) {
                    fieldStrings.add(field.getName() + "=<access denied>");
                }
            }
            clazz = clazz.getSuperclass();
        }

        return obj.getClass().getSimpleName() + "{ " + String.join(", ", fieldStrings) + " }";
    }
}
