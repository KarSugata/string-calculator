package org.demo.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void createStringCalculatorInstance() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void testMethod() {
        System.out.println(stringCalculator.add(""));
    }
}
