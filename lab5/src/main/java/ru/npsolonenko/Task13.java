package ru.npsolonenko;

import java.io.*;
import java.util.*;

public class Task13 {

    private static final String INPUT_FILE = "src/main/files/Task13.txt";

    private static final String OUTPUT_FILE = "src/main/files/Task13Output.txt";

    private static final Set<String> BAD_WORDS = Set.of(
            "секс", "наркотики", "с++", "си++"
    );

    private static final String REPLACEMENT = "[ЦЕНЗУРА]";

    public static void filterProtocol(String inputPath, String outputPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String filteredLine = filterLine(line);
                writer.write(filteredLine);
                writer.newLine();
            }
        }
    }

    private static String filterLine(String line) {
        String[] words = line.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (isBadWord(word))
                result.append(REPLACEMENT).append(" ");
            else
                result.append(word).append(" ");
        }

        return result.toString().trim();
    }

    private static boolean isBadWord(String word) {
        String lowerWord = word.toLowerCase();
        return BAD_WORDS.contains(lowerWord) ||
                lowerWord.contains("секс") ||
                lowerWord.contains("наркотик") ||
                lowerWord.matches(".*c\\+\\+.*");
    }

    public static void main(String[] args) {

        try {
            filterProtocol(INPUT_FILE, OUTPUT_FILE);
            System.out.println("Success");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
