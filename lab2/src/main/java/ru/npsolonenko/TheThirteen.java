package ru.npsolonenko;

import java.io.FileReader;
import com.opencsv.CSVReader;

public class TheThirteen {
    private static final String PATH = "src/main/java/numbers.csv";

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(PATH));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            for (String e : nextLine)
                System.out.format("%s ", e);
        }
    }
}
