package com.cursosdedesarrollo.app.integracion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CajaObjetoIntegrationTest {
    @Test
    public void testIntegracionCajaObjeto(){
        // declaro el dato que quiero devolver
        String datoADevolver = "Micadena";
        // Declarar un objeto de la clase Caja
        Caja c = new Caja();
        // creo el objeto simulado
        Objeto objetoSimulado = spy(new Objeto());
        // cambio el objeto original por el simulado
        c.setObjeto(objetoSimulado);
        // cambio el comportamiento del objeto simulado para que
        // haga lo que yo le digo y no lo de por defecto
        when(objetoSimulado.getCadena()).thenReturn(datoADevolver);
        // llamamos al método que debería hacer la llamada al objeto simulado
        c.procesaDatos();
        // comprobar que se procesado la llamada al objeto simulado
        verify(objetoSimulado).getCadena();
        // y que los datos se han procesado correctamente
        assertEquals("Micadena1", c.getDatosProcesados());
    }
}
