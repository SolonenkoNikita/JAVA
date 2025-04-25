package ru.npsolonenko;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class DistributedDBMS {

    private final List<Path> dbPaths;
    private final int size;
    private final Map<Path, RandomAccessFile> dbFiles;

    public DistributedDBMS(Path... paths) {
        if(paths.length % 2 == 0) {
            throw new IllegalArgumentException("There's not a even number");
        }
        this.dbPaths = List.of(paths);
        this.size = paths.length;
        this.dbFiles = new HashMap<>();
    }

    public void init() throws IOException {
        for(Path path : dbPaths) {
            if(Files.exists(path)) {
                throw new IllegalStateException("File exists");
            }

            RandomAccessFile file = new RandomAccessFile(path.toFile(), "rw");
            dbFiles.put(path, file);
        }
    }

    public long add(String value) throws IOException {
        if(value == null) {
            throw new IllegalArgumentException("This state must be not null");
        }

        long id = System.currentTimeMillis(); //timestamp как ID
        byte[] values = value.getBytes();
        int successful = 0;

        for(Path path : dbPaths) {
            RandomAccessFile file = dbFiles.get(path);
            try {
                file.seek(file.length());
                file.writeLong(id);
                file.writeInt(values.length);
                file.write(values);
                ++successful;
            }
            catch (IOException e) {
                System.err.println("Error write in file " + path + e.getMessage());
            }
        }
        int required = size / 2 + 1;
        if(successful < required) {
            throw new IOException("Can't write - uncorrect successful writers");
        }
        return id;
    }

    public String get(long id) throws IOException {
        Map<String, Integer> values = new HashMap<>();
        String consistentValue = null;
        int max = 0;
        return null;
    }

}
