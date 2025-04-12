package ru.npsolonenko;

import java.util.List;

public class Person {
    @Key
    private String name;

    @Key
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws Exception{
        List<Pair<String, Object>> values = List.of(
                new Pair<>("name", "John Doe"),
                new Pair<>("age", 30)
        );

        Person person = AnnotationProcessor.set(Person.class, values);

        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}


