package ru.npsolonenko;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Nikita", 100000),
                new Employee("Dima", 60000),
                new Employee("Artem", 70000),
                new Employee("Bulat", 60000)
        };

        Arrays.sort(employees,  Comparator.comparing(Employee::getMeasure).thenComparing(Employee::getName));

        for(Employee employee : employees)
            System.out.println(employee.getMeasure() + " " + employee.getName());

        System.out.println("\nReverse:");

        Arrays.sort(employees,  Comparator.comparing(Employee::getName).thenComparing(Employee::getMeasure));

        for(Employee employee : employees)
            System.out.println(employee.getMeasure() + " " + employee.getName());
    }
}
