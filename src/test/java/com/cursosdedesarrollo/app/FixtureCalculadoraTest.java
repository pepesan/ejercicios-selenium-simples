package com.cursosdedesarrollo.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SuiteDisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuiteDisplayName("Nombre de Suite")
public class FixtureCalculadoraTest {

    Calculadora c = null;

    @BeforeEach
    public void beforeEach (){
        System.out.println("beforeEach");
        // Given
        this.c = new Calculadora();
    }

    @Test
    @DisplayName("add(1,1) = 2")
    public void addsTwoNumbers() {
        // When
        Integer resultado = c.add(1,1);
        // Then
        assertEquals(2, resultado, "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("sub(1,1) = 0")
    public void restaDosNumeros(){
        // When
        Integer resultado = c.sub(1,1);
        // Then
        assertEquals(0, resultado, "1 - 1 should equal 0");
    }
    @Test
    @DisplayName("sub(2,1) = 1")
    public void restaDosNumerosOtraVez(){
        // When
        Integer resultado = c.sub(2,1);
        // Then
        assertEquals(1, resultado, "2 - 1 should equal 1");
    }
}
