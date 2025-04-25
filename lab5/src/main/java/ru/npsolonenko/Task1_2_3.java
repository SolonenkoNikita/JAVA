package ru.npsolonenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1_2_3 {

    private static final String FILE_PATH_TO_CORRECTED_DATA =
            "src/main/files/correct.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA =
            "src/main/files/uncorrect.txt";

    public static void main(String[] args) {
        printSumOfValues(FILE_PATH_TO_UNCORRECTED_DATA);
    }

    private static double calculateSum(List<Double> list) {
        double sum = 0;
        for (double number : list) {
            sum += number;
            if (sum == Double.POSITIVE_INFINITY || sum == Double.NEGATIVE_INFINITY)
                throw new RuntimeException("Sum of values in file > Double.MAX!");
        }
        return sum;
    }

    public static List<Double> readValues(String filename) throws FileNotFoundException, NumberFormatException, IllegalStateException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<Double> result = new ArrayList<>();
            while (scanner.hasNext())
                result.add(Double.parseDouble(scanner.next()));
            return result;
        }
    }

    public static double sumOfValues(String filename) throws FileNotFoundException, IllegalStateException, NumberFormatException {
        List<Double> numbers = readValues(filename);
        return calculateSum(numbers);
    }

    public static void printSumOfValues(String filename) {
        try {
            System.out.println(sumOfValues(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening or reading from a file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Some of the data in the file aren't double numbers: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("File closing error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}