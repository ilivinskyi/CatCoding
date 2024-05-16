package com.ilivinskyi.homeworks.exceptions;

public class SquareRootCalculator {

    public static double calculateSquareRoot(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        return Math.sqrt(number);
    }
}
