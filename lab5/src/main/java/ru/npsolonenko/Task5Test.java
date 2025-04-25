package ru.npsolonenko;

import org.mockito.Mockito;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task5Test {

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
            //  in = new Scanner(Paths.get(DATA));
            in = Mockito.mock(Scanner.class);
            Mockito.when(in.next()).thenThrow(new RuntimeException("Simulated IO error"));
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
}
