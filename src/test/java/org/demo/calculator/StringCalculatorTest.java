package org.demo.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void addNumbersSeparatedByCommaAndContainInvalidCharacter() {
        String numbers = "10,20,x";
        assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(numbers));
    }

    @Test
    void addNumbersSeparatedByCommaAndNewLine() {
        String numbers = "10,20\n30";
        assertEquals(60, stringCalculator.add(numbers));

        numbers = "10\n20,30";
        assertEquals(60, stringCalculator.add(numbers));
    }
}
