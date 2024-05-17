package com.ilivinskyi.homeworks.exceptions.strings;

public class WordsDivider {

    public static String[] splitString(String input) throws EmptyStringException {
        if (input.isEmpty()) {
            throw new EmptyStringException("Input string is empty");
        }
        return input.split("\\s+");
    }
}
