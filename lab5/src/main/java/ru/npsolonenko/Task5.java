package ru.npsolonenko;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task5 {

    private static final String OUTPUT = "src/main/files/output.txt";
    private static final String DATA = "src/main/files/Task5.txt";

    public static void main(String[] args) {
        closeableFunc();
    }

    public static void close(Closeable out) {
        if (out != null) {
            try {
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeableFunc() {
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

    protected Scanner createScanner(String filePath) throws IOException {
        return new Scanner(Paths.get(filePath));
    }

    protected PrintWriter createPrintWriter(String filePath) throws IOException {
        return new PrintWriter(filePath);
    }
}
