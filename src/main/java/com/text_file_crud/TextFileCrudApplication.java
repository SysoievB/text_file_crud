package com.text_file_crud;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TextFileCrudApplication implements CommandLineRunner {
    private final FileService service;

    public static void main(String[] args) {
        SpringApplication.run(TextFileCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.createAndWriteToFile("hello", "Some text");

        service.getTextFromFile("hello");
    }
}
