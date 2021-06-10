package com.leverx.task2.dal;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputFileWriter {
    private static final Logger logger = Logger.getLogger(OutputFileWriter.class.getName());

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
            logger.error("problems with writing in file" + e);
        }
    }
}
