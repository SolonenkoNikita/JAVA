package ru.npsolonenko;

public class Task1_2 {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Nikita", 100000),
                new Employee("Dima", 60000),
                new Employee("Artem", 55000)
        };

        double averageSalary = Employee.average(employees);
        System.out.println("Average salary: " + averageSalary);

        Measurable maxMeasurable = Measurable.largest(employees);

        if (maxMeasurable instanceof Employee maxEmployee)
            System.out.println("Employee with max salary: " + maxEmployee.getName());
        else
            System.out.println("There's not an emloyee");
    }
}
