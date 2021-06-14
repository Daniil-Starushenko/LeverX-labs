package com.leverx.task2.dal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFileWriter {
    private String path;
    private final File file;

    public OutputFileWriter(String path) {
        this.path = path;
        file = new File(path, "output.txt");

    }

    public void writeOutputFile(List<String> lines) {

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(System.lineSeparator());
            for (String line : lines) {
                fileWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("problems with writing in file: " + e);
        }
    }
}
