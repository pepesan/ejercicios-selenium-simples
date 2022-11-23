package com.cursosdedesarrollo.app.integracion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;

import static org.mockito.Mockito.verify;

public class MockitoSencilolTest {
    @Mock
    private LinkedList<String> listado;
    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testAnnotation(){
        listado.add("Uno");
        verify(listado).add("Uno");
    }

}
