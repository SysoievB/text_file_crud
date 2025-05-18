package com.text_file_crud;

import lombok.val;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileService {
    private static final String UPLOAD_DIR = "files/";
    private static final String FILE_EXTENSION = ".txt";

    public FileService() {
        try {
            Files.createDirectories(Paths.get(UPLOAD_DIR));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createAndWriteToFile(String fileName, String text) {
        val path = Paths.get(UPLOAD_DIR + fileName + FILE_EXTENSION);
        val file = path.toFile();

        try (val writer = new FileWriter(file, true)) { // true in FileWriter constructor means append mode
            writer.write(text);
            writer.write(System.lineSeparator());
            System.out.println("Text written to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void getTextFromFile(String fileName) {
        val content = new StringBuilder();
        val path = UPLOAD_DIR + fileName + FILE_EXTENSION;
        try (val reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
