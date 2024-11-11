package org.demo.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void createStringCalculatorInstance() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void addNumbersSeparatedByComma() {
        String numbers = "10,20,30";
        assertEquals(60, stringCalculator.add(numbers));
    }
}
