package org.demo.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        // Default delimiters: comma or newline
        String delimiter = "[,\n" +
                           "]";

        // Check for a custom delimiter in the format "//[delimiter]\n"
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.+)\n").matcher(numbers);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1)); // Escape delimiter for special characters
                numbers = numbers.substring(matcher.end());
            }
        }

        String[] parsedNumbers = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String num : parsedNumbers) {
            try {
                int parsedInt = Integer.parseInt(num);
                if (parsedInt < 0) {
                    negatives.add(parsedInt);
                } else {
                    sum += parsedInt;
                }

            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException(String.format("The given input string: %s is not a number%n", num));
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(String.format("Negatives not allowed: %s%n", negatives));
        }
        return sum;
    }
}
