package com.cursosdedesarrollo.app.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RuleStepdefs {
    @Given("there are {int} ninjas")
    public void thereAreNinjas(int arg0) {
    }

    @And("there are more than one ninja alive")
    public void thereAreMoreThanOneNinjaAlive() {
    }

    @When("{int} ninjas meet, they will fight")
    public void ninjasMeetTheyWillFight(int arg0) {
    }

    @Then("one ninja dies \\(but not me)")
    public void oneNinjaDiesButNotMe() {
    }

    @And("there is one ninja less alive")
    public void thereIsOneNinjaLessAlive() {
    }

    @Given("there is only {int} ninja alive")
    public void thereIsOnlyNinjaAlive(int arg0) {
    }

    @Then("he \\(or she) will live forever ;-)")
    public void heOrSheWillLiveForever() {
    }
}
