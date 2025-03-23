package ru.npsolonenko;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class Task12 {

    public static void printInfo(Path path) {
        File dir = path.toFile();
        if(dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                Comparator<File> comp = Comparator.comparing((File s) -> !s.isDirectory()).thenComparing(File::getName);
                Arrays.sort(files, comp);
                for (File file : files)
                    System.out.println(file.getName());
            }
        }
    }

    public static void main(String[] args) {
        Path path = Path.of("D:/Example");
        printInfo(path);
    }
}
