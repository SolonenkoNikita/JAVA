package ru.npsolonenko;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task5 {

    private static final String OUTPUT = "src/main/files/output.txt";
    private static final String DATA = "src/main/files/Task5.txt";

    private static void close(Closeable out) {
        if (out != null) {
            try {
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeableFunc() {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(DATA));
            out = new PrintWriter(OUTPUT);
            while (in.hasNext())
                out.print(in.next().toUpperCase() + " ");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            close(in);
            close(out);
        }
    }

    public static void main(String[] args) {
        closeableFunc();
    }
}
