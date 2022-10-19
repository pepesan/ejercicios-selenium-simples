package com.cursosdedesarrollo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

class AppTests {
    @Test
    @DisplayName("1 + 1 = 2")
    public void addsTwoNumbers() {
        assertEquals(2, 1+1, "1 + 1 should equal 2");
    }
}
