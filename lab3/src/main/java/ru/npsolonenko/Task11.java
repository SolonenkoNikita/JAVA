package ru.npsolonenko;

import java.io.File;
import java.nio.file.Path;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class Task11 {

    public static List<File> returnParticular(Path path, String extention) {
        File directory = path.toFile();

        if(directory == null || !directory.isDirectory())
            throw new IllegalArgumentException("There's not a catalog");

        FileFilter fileFilter = new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().toLowerCase().endsWith("." + extention.toLowerCase());
            }
        };
        File[] files = directory.listFiles(fileFilter);

        if (files == null)
            return List.of();

        return Arrays.asList(files);
    }

    public static List<File> returnParticularLamda(Path path, String ext) {
        File directory = path.toFile();
        if(directory == null || !directory.isDirectory())
            throw new IllegalArgumentException("There's not a catalog");

        File[] files = directory.listFiles(file ->
                file.isFile() && file.getName().toLowerCase().endsWith("." + ext.toLowerCase())
        );

        if (files == null)
            return List.of();

        return Arrays.asList(files);
    }

    public static void main(String[] args) {
        List<File> files = returnParticularLamda(Path.of("D:/2222/Beauty"), "txt");
        for (File dir : files)
            System.out.println(dir);
    }

}
