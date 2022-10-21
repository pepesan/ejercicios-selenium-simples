package com.cursosdedesarrollo.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */

class TagsTest {
    @Tag("smoke")
    @Tag("sanity")
    @Tag("unit")
    @Fast
    @Test
    @DisplayName("1 + 1 = 2")
    public void addsTwoNumbers() {
        assertEquals(2, 1+1, "1 + 1 should equal 2");
    }
}
