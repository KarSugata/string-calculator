package org.demo.calculator;

public class StringCalculator {
    int add(String numbers) {
        String[] parsedNumbers = numbers.split(",");
        int sum = 0;
        for (String num : parsedNumbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
