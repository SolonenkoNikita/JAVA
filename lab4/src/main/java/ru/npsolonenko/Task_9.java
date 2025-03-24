package ru.npsolonenko;

public class Task_9 {

    static class Parent {

        private String parent = "parent";
        protected String name = "Papa";
        protected int age = 30;
    }

    static class Child extends Parent {

        Child() {
            name = "Child";
            age = 10;
        }
    }

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(UniversalToString.toString(child));
    }
}
