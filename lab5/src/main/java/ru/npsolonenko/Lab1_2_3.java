package ru.npsolonenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab1_2_3 {

    private static final String FILE_PATH_TO_CORRECTED_DATA =
            "src/main/files/correct.txt";
    private static final String FILE_PATH_TO_UNCORRECTED_DATA =
            "src/main/files/uncorrect.txt";

    private static double calculateSum(List<Double> list) {
        double sum = 0;
        for (double number : list) {
            sum += number;
            if (sum == Double.POSITIVE_INFINITY || sum == Double.NEGATIVE_INFINITY)
                throw new RuntimeException("Sum of values > Double.MAX");
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
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e + " Error opening or reading from a file!");
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            System.err.println(e + " Some of the data in the file are'nt double numbers!");
        }
        catch (IllegalStateException e) {
            e.printStackTrace();
            System.err.println(e + " File closing error!");
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            System.err.println(e + " Sum of values in file > Double.MAX!");
        }
    }

    public static void main(String[] args) {
        printSumOfValues(FILE_PATH_TO_UNCORRECTED_DATA);
    }
}
