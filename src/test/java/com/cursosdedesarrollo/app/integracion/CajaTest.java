package com.cursosdedesarrollo.app.integracion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CajaTest {
    @Test
    public void testConstructor(){
        Caja caja = new Caja();
        assertNull(caja.getObjeto());
    }
    @Test
    public void testConstructorConParametro(){
        Objeto objeto = new Objeto();
        Caja caja = new Caja(objeto);
        assertEquals(objeto, caja.getObjeto());
    }
    @Test
    public void testSetter(){
        Objeto objeto = new Objeto();
        Caja caja = new Caja();
        caja.setObjeto(objeto);
        assertEquals(objeto, caja.getObjeto());
    }

}
