package org.demo.calculator;

public class StringCalculator {
    int add(String numbers) {
        String[] parsedNumbers = numbers.split(",");
        int sum = 0;
        for (String num : parsedNumbers) {
            try {
                sum += Integer.parseInt(num);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException(String.format("The given input string: %s is not a number%n", num));
            }
        }
        return sum;
    }
}
