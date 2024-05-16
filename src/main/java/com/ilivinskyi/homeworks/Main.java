package com.ilivinskyi.homeworks;

import static com.ilivinskyi.homeworks.exceptions.ElementsSearch.findElementIndex;
import static com.ilivinskyi.homeworks.exceptions.WordsDivider.splitString;

import com.ilivinskyi.homeworks.exceptions.EmptyStringException;
import com.ilivinskyi.homeworks.exceptions.SafeDivision;
import com.ilivinskyi.homeworks.exceptions.SafeFileReader;
import com.ilivinskyi.homeworks.exceptions.SquareRootCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        // 1
        var divider = new SafeDivision();
        divider.division(0, 0);

        // 2
        System.out.println(SafeFileReader.readFile("test.txt"));

        // 3
        String input = "";

        try {
            String[] words = splitString(input);
            System.out.println("Words in string:");
            for (String word : words) {
                System.out.println(word);
            }
        } catch (EmptyStringException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // 4
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        String target = "two";

        try {
            int index = findElementIndex(list, target);
            System.out.println("Element position: " + index);
        } catch (NoSuchElementException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // 5
        SquareRootCalculator.calculateSquareRoot(-4.0);
    }
}
