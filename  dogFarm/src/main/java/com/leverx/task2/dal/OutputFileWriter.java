package com.leverx.task2.dal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFileWriter {
    private String path;

    public OutputFileWriter(String path) {
        this.path = path;
    }

    public void writeOutputFile(List<String> lines) {

        File file = new File(path, "output.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String line : lines) {
                fileWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("problems with writing in file: " + e);
        }
    }
}
