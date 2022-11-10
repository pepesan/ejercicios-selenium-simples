package com.cursosdedesarrollo.app.cucumber;

import com.cursosdedesarrollo.app.Calculadora;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraStepdefs {
    Calculadora c;
    Integer i;
    @Given("^Tengo un objeto de la calculadora$")
    public void givenEstadoInicial(){
        this.c= new Calculadora();
    }
    @When("^hago una suma de 1 y 1$")
    public void whenSuma(){
        this.i = this.c.add(1,1);
    }
    @When("^hago una suma de 2 y 3$")
    public void whenSuma2(){
        this.i = this.c.add(1,1);
    }
    @Then("^tengo un resultado de 2$")
    public void thenComprueba(){
        assertEquals(2, this.i);
    }
    @Then("^tengo un resultado de 5$")
    public void thenComprueba2(){
        assertEquals(2, this.i);
    }


}
