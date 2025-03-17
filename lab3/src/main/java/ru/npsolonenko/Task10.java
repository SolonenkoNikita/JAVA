package ru.npsolonenko;

import java.io.File;
import java.nio.file.Path;
import java.io.FileFilter;

public class Task10 {

    public static File[] returnAllCatalogs(Path path) {
        File file = path.toFile();
        if(file.isDirectory())
            return file.listFiles(File::isDirectory);
        return null;
    }

    public static File[] returnAllCatalogsLamda(Path path) {
        File file = path.toFile();
        if (file.isDirectory())
            return file.listFiles(lam -> lam.isDirectory());
        return null;
    }

    private static File[] returnAllCatalogsWithAnon(Path path) {
        File file = path.toFile();
        return file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }

        });
    }

    public static void main(String[] args) {
        Path path = Path.of("/Users/user");
        File[] files = returnAllCatalogs(path);
        if(files != null)
        {
            for (File dir : files)
                System.out.println(dir);
        }
    }
}
