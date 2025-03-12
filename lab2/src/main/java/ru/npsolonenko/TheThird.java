package ru.npsolonenko;

//1. Да, можно
//Один из классических примеров, где модифицирующий метод возвращает не void,
// — это реализация паттерна Builder
// В этом случае методы, которые изменяют состояние объекта,
// возвращают сам объект (this), чтобы позволить цепочку вызовов (method chaining)

public class TheThird {

    static class Counter {
        private int count;

        public Counter() {
            this.count = 0;
        }

        // Модифицирующий метод, который возвращает текущее значение счетчика
        public int incrementAndGet() {
            ++count;
            return count;
        }

        public int getCount() {
            return count;
        }
    }

    static class Printer {
        private final String message;

        public Printer(String message) {
            this.message = message;
        }

        // Метод доступа, который ничего не возвращает, а выводит значение на экран
        public void printMessage() {
            System.out.println(message);
        }
    }

}
