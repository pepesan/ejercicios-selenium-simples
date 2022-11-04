package com.cursosdedesarrollo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

@Tag("unit")
class CalculadoraTest {
    @Test
    @DisplayName("add(1,1) = 2")
    public void addsTwoNumbers() {
        // Given
        Calculadora c = new Calculadora();
        // When
        Integer resultado = c.add(1,1);
        // Then
        assertEquals(2, resultado, "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("sub(1,1) = 0")
    public void restaDosNumeros(){
        // Given 
        Calculadora c = new Calculadora();
        // When 
        Integer resultado = c.sub(1,1);
        // Then
        assertEquals(0, resultado, "1 - 1 should equal 0");
    }
    @Test
    @DisplayName("sub(2,1) = 1")
    public void restaDosNumerosOtraVez(){
        // Given 
        Calculadora c = new Calculadora();
        // When 
        Integer resultado = c.sub(2,1);
        // Then
        assertEquals(1, resultado, "2 - 1 should equal 1");
    }
} 
