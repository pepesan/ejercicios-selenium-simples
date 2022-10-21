package com.cursosdedesarrollo.app;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParametrizadasTest {
    /*
    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void palindromes(String candidate) {
        assertTrue(StringUtils.isPalindrome(candidate));
    }

     */

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0, 1, 1",
            "1, 2, 3",
            "49, 51, 100",
            "1, 100, 101"
    })
    void add(int first, int second, int expectedResult) {
        Calculadora c = new Calculadora();
        assertEquals(expectedResult, c.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }
    @RepeatedTest(10)
    void repeatedTest() {
        assertEquals(0,0);
    }
}
