package ru.npsolonenko;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DistributedDBMS implements AutoCloseable {

    private final List<Path> dbPaths;
    private final int size;
    private final Map<Path, RandomAccessFile> dbFiles;

    public DistributedDBMS(Path... paths) {
        if (paths.length % 2 == 0) {
            throw new IllegalArgumentException("Number of paths must be odd");
        }
        this.dbPaths = List.of(paths);
        this.size = paths.length;
        this.dbFiles = new HashMap<>();
    }

    public void init() throws IOException {
        for (Path path : dbPaths) {
            if (Files.exists(path)) {
                throw new IllegalStateException("File already exists: " + path);
            }

            RandomAccessFile file = new RandomAccessFile(path.toFile(), "rw");
            dbFiles.put(path, file);
        }
    }

    public long add(String value) throws IOException {
        if (value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }

        long id = System.currentTimeMillis(); // timestamp как ID
        byte[] values = value.getBytes();
        int successfulWrites = 0;

        for (Path path : dbPaths) {
            RandomAccessFile file = dbFiles.get(path);
            try {
                file.seek(file.length());
                file.writeLong(id);
                file.writeInt(values.length);
                file.write(values);
                successfulWrites++;
            } catch (IOException e) {
                throw new IOException("Failed to write to file: " + path, e);
            }
        }

        int requiredWrites = size / 2 + 1;
        if (successfulWrites < requiredWrites) {
            throw new IOException("Failed to write to the majority of files. Required: " + requiredWrites + ", written: " + successfulWrites);
        }

        return id;
    }

    public String get(long id) throws IOException {
        Map<String, Integer> valueCounts = new HashMap<>();
        int requiredConsistency = size / 2 + 1;

        for (Path path : dbPaths) {
            RandomAccessFile file = dbFiles.get(path);
            file.seek(0);

            while (file.getFilePointer() < file.length()) {
                long fileId = file.readLong();
                if (fileId == id) {
                    int length = file.readInt();
                    byte[] data = new byte[length];
                    file.readFully(data);
                    String value = new String(data);

                    valueCounts.put(value, valueCounts.getOrDefault(value, 0) + 1);

                    if (valueCounts.get(value) >= requiredConsistency) {
                        return value;
                    }
                } else {
                    int length = file.readInt();
                    file.skipBytes(length);
                }
            }
        }

        throw new IOException("Consistent data not found in the majority of files");
    }

    @Override
    public void close() throws IOException {
        for (RandomAccessFile file : dbFiles.values()) {
            file.close();
        }
    }
}