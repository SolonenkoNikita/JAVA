package ru.npsolonenko;

import java.util.List;

public class Task_8 {

    public static class InnerClass {}

    public static void main(String[] args) {

        Class<?> intClass = int.class;

        Class<?> stringArrayClass = String[].class;

        Class<?> listClass = List.class;

        Class<?> innerClass = InnerClass.class;


        System.out.println(" The primitive type (int)");
        printClassInfo(intClass);

        System.out.println("\n\n Array (String[])");
        printClassInfo(stringArrayClass);

        System.out.println("\n\n Generalized type (List)" );
        printClassInfo(listClass);
        
        System.out.println("\n\n (InnerClass)");
        printClassInfo(innerClass);
    }

    public static void printClassInfo(Class<?> clazz) {
        System.out.println("getName(): " + clazz.getName());
        System.out.println("getSimpleName(): " + clazz.getSimpleName());
        System.out.println("getCanonicalName(): " + clazz.getCanonicalName());
        System.out.println("getTypeName(): " + clazz.getTypeName());
        System.out.println("toGenericString(): " + clazz.toGenericString());
        System.out.println("toString(): " + clazz.toString());
    }
}
