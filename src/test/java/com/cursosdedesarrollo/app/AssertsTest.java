package com.cursosdedesarrollo.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertsTest {

    Calculadora c = null;
    @BeforeEach
    public void beforeEach(){
        // Given
        this.c = new Calculadora();
    }
    @Test
    public void testingAsserts(){
        Integer expected = 2;
        Integer real = 2;
        // Then
        assertEquals(expected, real, "mensaje por si hay un error" );
    }

    @Test
    public void testingAssertsReal(){
        // When
        Integer real = c.add(1,2);
        // Then
        Integer expected = 3;
        assertEquals(expected, real, "La suma de 1+2 debería dar 3" );
    }

    @Test
    public void otrosAsserts(){
        String primerNombre = "Jane";
        String segundoNombre = "Doe";
        assertAll("person",
                () -> assertEquals("Jane", primerNombre),
                () -> assertEquals("Doe", segundoNombre)
        );

        assertTrue(primerNombre.startsWith("J"), "Debería ser true");
        assertNotNull(this.c, "El objeto no debería ser Null");

        // capturamos que se lanza una excepción

        Exception exception =
                assertThrows(
                        ArithmeticException.class,
                        () ->
                            c.divide(1, 0)
                );
        assertEquals("/ by zero", exception.getMessage());


    }
}

