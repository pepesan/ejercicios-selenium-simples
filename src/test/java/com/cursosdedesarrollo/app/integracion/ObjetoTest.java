package com.cursosdedesarrollo.app.integracion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjetoTest {

    @Test
    public void testConstructor(){
        Objeto objeto = new Objeto();
        assertEquals("", objeto.getCadena());
    }
    @Test
    public void testConstructorConParametro(){
        String inicial = "inicial";
        Objeto objeto = new Objeto(inicial);
        assertEquals(inicial, objeto.getCadena());
    }
    @Test
    public void testSetter(){
        String inicial = "inicial";
        Objeto objeto = new Objeto();
        objeto.setCadena(inicial);
        assertEquals(inicial, objeto.getCadena());
    }
}
