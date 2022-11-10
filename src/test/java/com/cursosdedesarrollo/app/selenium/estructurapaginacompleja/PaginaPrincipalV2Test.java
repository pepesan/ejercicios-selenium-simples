package com.cursosdedesarrollo.app.selenium.estructurapaginacompleja;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaginaPrincipalV2Test extends PruebaConfigurada {
    PaginaPrincipalPactometro paginaPrincipal;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        paginaPrincipal = new PaginaPrincipalPactometro(getDriver());
    }

    @Test
    public void testEstadoInicial(){
        assertEquals("0", paginaPrincipal.numSies.getText());
        assertEquals("0", paginaPrincipal.numNoes.getText());
        assertEquals("0", paginaPrincipal.numAbst.getText());
    }
    @Test
    public void testBotonPulsadoBotonDeshabilitado(){
        // When pulso en el boton del PP
        paginaPrincipal.botonPP.click();
        // Then compruebo que el botón está deshabilitado
        assertEquals("true", paginaPrincipal.botonPP.getAttribute("disabled"));
        assertTrue(!paginaPrincipal.botonPP.isEnabled());
        // When asigno los diputados a los noes
        paginaPrincipal.noes.click();
        // Then el boton debe desaparecer
        assertEquals("display: none;", paginaPrincipal.botonPP.getAttribute("style"));
        assertTrue(!paginaPrincipal.botonPP.isDisplayed());
        // And comprobamos que el numero de noes es 89
        assertEquals("89", paginaPrincipal.numNoes.getText());
    }
}
