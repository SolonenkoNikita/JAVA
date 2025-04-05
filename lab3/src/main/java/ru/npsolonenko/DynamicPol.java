package ru.npsolonenko;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.function.Supplier;

public class DynamicPol {


    static class Animal {

        public void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    static class Dog extends Animal {

        @Override
        public void makeSound() {
            System.out.println("Woof! Woof!");
        }
    }

    static class Cat extends Animal {

        @Override
        public void makeSound() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {

        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound();
        cat.makeSound();

        ArrayList<Animal> animal = new ArrayList<>();
        int i = 0;
        for(; i < 10; ++i) {
            if(i % 2 == 0) {
                Animal a = new Cat();
                animal.add(a);
            }
            else {
                Animal a = new Dog();
                animal.add(a);
            }
        }

        for(Animal a : animal) {
            a.makeSound(); // Meow || Woof
        }
    }


}
