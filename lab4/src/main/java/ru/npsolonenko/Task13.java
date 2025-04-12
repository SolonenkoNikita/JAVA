package ru.npsolonenko;

import java.util.function.DoubleFunction;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


public class Task13 {

    public static void printTable(Method method, double start, double end, double step) {
        System.out.println("Table for method: " + method.getName());
        System.out.println("An argument | The result");
        System.out.println("--------|----------");

        try {
            Object instance = null;
            if (!java.lang.reflect.Modifier.isStatic(method.getModifiers())) {
                instance = method.getDeclaringClass().getDeclaredConstructor().newInstance();
            }

            for (double x = start; x <= end; x += step) {
                Object result;
                if (method.getParameterTypes()[0] == double.class)
                    result = method.invoke(instance, x);
                else if (method.getParameterTypes()[0] == Double.class)
                    result = method.invoke(instance, Double.valueOf(x));
                else {
                    throw new IllegalArgumentException("There is not a double or a Double");
                }
                System.out.printf("%7.2f | %s%n", x, result);
            }
        }
        catch (IllegalAccessException | InstantiationException |
               InvocationTargetException | NoSuchMethodException e) {
            System.err.println("Error to call this method: " + e.getMessage());
        }
    }

    public static void printTable(DoubleFunction<Object> function,
                                  double start, double end, double step,
                                  String description) {
        System.out.println("Table: " + description);
        System.out.println("Аn argument | The result");
        System.out.println("--------|----------");

        for (double x = start; x <= end; x += step) {
            Object result = function.apply(x);
            System.out.printf("%7.2f | %s%n", x, result);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {

        /*Method sqrtMethod = Math.class.getMethod("sqrt", double.class);
        printTable(sqrtMethod, 1.0, 20.0, 1.0);

        Method toHexStringMethod = Double.class.getMethod("toHexString", double.class);
        printTable(toHexStringMethod, 0.5, 2.0, 0.25);*/

        printTable(Math::sqrt, 1.0, 20.0, 1.0, "Math.sqrt(double)");

        printTable(Double::toHexString, 0.5, 2.0, 0.25, "Double.toHexString(double)");
    }
}


