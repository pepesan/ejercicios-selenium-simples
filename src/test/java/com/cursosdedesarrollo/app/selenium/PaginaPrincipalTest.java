package com.cursosdedesarrollo.app.selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaginaPrincipalTest extends PaginaPrincipalPactometro{
    @Test
    public void testEstadoInicial(){
        assertEquals("0", numSies.getText());
        assertEquals("0", numNoes.getText());
        assertEquals("0", numAbst.getText());
    }
    @Test
    public void testBotonPulsadoBotonDeshabilitado(){
        // When pulso en el boton del PP
        botonPP.click();
        // Then compruebo que el botón está deshabilitado
        assertEquals("true", botonPP.getAttribute("disabled"));
        assertTrue(!botonPP.isEnabled());
        // When asigno los diputados a los noes
        noes.click();
        // Then el boton debe desaparecer
        assertEquals("display: none;", botonPP.getAttribute("style"));
        assertTrue(!botonPP.isDisplayed());
        // And comprobamos que el numero de noes es 89
        assertEquals("89", numNoes.getText());
    }
}
