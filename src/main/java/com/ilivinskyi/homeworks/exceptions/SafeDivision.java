package com.ilivinskyi.homeworks.exceptions;

public class SafeDivision {

    public int division(int firstNumber, int secondNumber) {
        var result = 0;
        try {
            result = firstNumber / secondNumber;
        } catch (Exception e) {
            System.out.println("Cannot divide by zero!");
        }
        return result;
    }
}
