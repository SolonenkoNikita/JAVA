package ru.npsolonenko;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path path1 = Path.of("db1.dbf");
        Path path2 = Path.of("db2.dbf");
        Path path3 = Path.of("db3.dbf");

        try (DistributedDBMS dbms = new DistributedDBMS(path1, path2, path3)) {
            dbms.init();

            long id = dbms.add("Hello, World!");
            System.out.println("Added with ID: " + id);

            String value = dbms.get(id);
            System.out.println("Retrieved value: " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
