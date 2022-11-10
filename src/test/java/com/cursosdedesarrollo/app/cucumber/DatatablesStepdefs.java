package com.cursosdedesarrollo.app.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatatablesStepdefs {
    List<String> animals;
    @Given("the following animals:")
    public void theFollowingAnimals(List<String> animals) {
        this.animals = new ArrayList<>(animals);
        System.out.println(animals);
    }

    @When("we add a {string}")
    public void weAddA(String animal) {
        this.animals.add(animal);
    }

    @Then("we have {int} animals")
    public void weHaveAnimals(int number) {
        assertEquals(number, this.animals.size());
    }
}
