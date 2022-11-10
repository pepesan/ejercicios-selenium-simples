package com.cursosdedesarrollo.app.cucumber;

import com.cursosdedesarrollo.app.Calculadora;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HooksStepdefs {

    Calculadora c;
    Integer i;


    @Given("inicio")
    public void inicio() {
        i=0;
    }

    @When("accion")
    public void accion() {
        this.i = this.c.add(1,2);
    }

    @Then("prueba")
    public void prueba() {
        assertEquals(3, this.i);
    }
    /*
    @After
    public void doSomethingAfter(Scenario scenario){
        // Do something after scenario
        System.out.println("después de cada prueba");
    }
    @AfterStep
    public void doSomethingAfterStep(Scenario scenario){
        System.out.println("después de cada step");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("después de todos los escenarios");
    }
    @BeforeAll
    public static void beforeAll() {
        System.out.println("antes de todos los escenarios");
    }
    @Before
    public void setUp(){
        this.c = new Calculadora();
    }
    @BeforeStep
    public void doSomethingBeforeStep(Scenario scenario){
        System.out.println("antes de cada step");
        System.out.println(scenario.getLine());
    }

     */

}
