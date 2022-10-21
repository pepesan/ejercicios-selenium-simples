package com.cursosdedesarrollo.app.cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

public class MyStepdefs {
    private String today;
    private String actualAnswer;
    @Given("hoy es Lunes")
    public void today_is_Monday() {
        today = "Monday";
    }
    @When("compruebo el dia")
    public void compruebo_el_dia() {
        actualAnswer = "Martes";
    }

    @Then("Meto el valor {string}")
    public void meto_el_valor(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

}
