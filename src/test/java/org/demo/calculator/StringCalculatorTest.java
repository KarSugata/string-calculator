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

    @Test
    void addNumbersSeparatedByCustomDelimiter() {
        String numbers = "//;\n10;20;30";
        assertEquals(60, stringCalculator.add(numbers));
    }

    @Test
    void addNegativeNumbers() {
        String numbers = "10,-20,30,-40";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(numbers));
        assertEquals("Negatives not allowed: [-20, -40]\n", exception.getMessage());
    }

    @Test
    void addEmptyString() {
        String numbers = "";
        assertEquals(0, stringCalculator.add(numbers));
    }

    @Test
    void addPositiveNegativeNumbers() {
        String numbers = "10,-20,30,40";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> stringCalculator.add(numbers));
        assertEquals("Negatives not allowed: [-20]\n", exception.getMessage());
    }
}
