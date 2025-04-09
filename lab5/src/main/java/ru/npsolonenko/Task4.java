package ru.npsolonenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {

    private static final String FILE_PATH_TO_CORRECTED_DATA =
            "src/main/files/correct.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA =
            "src/main/files/uncorrect.txt";
    private static final int ERROR = 1;
    private static final int OK = 0;

    private static double result = 0;

    private static int calculateSum(List<Double> numbers) {
        for (double number : numbers) {
            result += number;
            if (result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY)
                return ERROR;
        }
        return OK;
    }

    private static int readValuesScan(Scanner scanner, List<Double> numbers) {
        while (scanner.hasNext())
            numbers.add(Double.parseDouble(scanner.next()));
        return OK;
    }

    public static int readValues(String filename, List<Double> numbers) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            return readValuesScan(scanner, numbers);
        }
        catch (FileNotFoundException | NumberFormatException | IllegalStateException e) {
            return ERROR;
        }
    }

    public static double sumOfValuesFromFile(String filename) {
        List<Double> numbers = new ArrayList<>();
        if (readValues(filename, numbers) == ERROR)
            return ERROR;
        return calculateSum(numbers);
    }

    public static void printSumOfValues(String filename) {
        if (sumOfValuesFromFile(filename) == ERROR)
            System.out.println("We caught error code");
        else
            System.out.println("Answer: " + result);
    }

    public static void main(String[] args) {
        printSumOfValues(FILE_PATH_TO_UNCORRECTED_DATA);
    }

}
