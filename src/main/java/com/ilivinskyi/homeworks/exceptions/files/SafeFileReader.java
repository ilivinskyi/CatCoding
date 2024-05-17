package com.ilivinskyi.homeworks.exceptions.files;

import com.ilivinskyi.homeworks.exceptions.utils.InputDataProvider;
import java.io.BufferedReader;
import java.io.IOException;

public class SafeFileReader {

    InputDataProvider inputDataProvider = new InputDataProvider();

    public String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        String line;
        BufferedReader reader = null;
        try {
            reader = inputDataProvider.getBufferedReader(inputDataProvider.getFileReader(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + e.getMessage());
        }
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException("Cannot read empty file. " + e.getMessage());
            }
            content.append(line).append("\n");
        }
        return content.toString();
    }
}
