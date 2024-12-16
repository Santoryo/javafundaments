package com.lr.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;

public class FileIO extends File {
    private String filename;

    public FileIO(String filename) {
        super(filename);
        this.filename = filename;
    }

    public void write(String data) {
        try (Writer writer = new FileWriter(filename)) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String read() {
        try {
            File file = new File(filename);
            return new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
