package ru.npsolonenko;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

public class ExamplesHOFunctions {

    static public class SortExample {
        public static void main(String[] args) {
            List<String> words = Arrays.asList("apple", "banana", "cherry");

            Collections.sort(words, (a, b) -> a.length() - b.length());

            System.out.println(words); // [apple, cherry, banana]
        }
    }

    static public class MapExample {
        public static void main(String[] args) {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5);

            List<Integer> squared = numbers.stream().map(n -> n * n)
                    .collect(Collectors.toList());

            System.out.println(squared); // [1, 4, 9, 16, 25]
        }
    }

    static public class FilterExample {
        public static void main(String[] args) {
            List<Integer> numbers = List.of(1, 2, 3, 4, 5);

            List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0)
                    .collect(Collectors.toList());

            System.out.println(evens); // [2, 4]
        }
    }

    static public class FunctionCompositionExample {
        public static void main(String[] args) {

            Function<Integer, Integer> multiplyByTwo = x -> x * 2;
            Function<Integer, Integer> addThree = x -> x + 3;

            Function<Integer, Integer> combined = multiplyByTwo.andThen(addThree);

            System.out.println(combined.apply(5)); // (5 * 2) + 3 = 13
        }
    }
}
