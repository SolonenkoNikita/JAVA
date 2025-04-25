package ru.npsolonenko;

import java.io.PrintWriter;

public class FinallyHidesException {

    public static void main(String[] args) {
        System.out.println(test());
    }

    public static String test() {
        try {
            throw new RuntimeException("Exception in try");
        }
        finally {
            return "From finally";
        }
    }
}
