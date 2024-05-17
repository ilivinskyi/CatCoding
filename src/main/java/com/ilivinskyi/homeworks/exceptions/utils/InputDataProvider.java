package com.ilivinskyi.homeworks.exceptions.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputDataProvider {

    public FileReader getFileReader(String fileName) throws IOException {
        try (var fileReader = new FileReader(fileName)) {
            return fileReader;
        }
    }

    public BufferedReader getBufferedReader(FileReader fileReader) throws IOException {
        try (var reader = new BufferedReader(fileReader)) {
            return reader;
        }
    }
}
