package com.cursosdedesarrollo.app.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundStepDef {
    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.out.println("Given navego");
    }

    @When("I submit username and password")
    public void iSubmitUsernameAndPassword() {
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
    }

    @Given("User search for Lenovo Laptop")
    public void userSearchForLenovoLaptop() {
    }

    @When("Add the first laptop that appears in the search result to the basket")
    public void addTheFirstLaptopThatAppearsInTheSearchResultToTheBasket() {
    }

    @Then("User basket should display with added item")
    public void userBasketShouldDisplayWithAddedItem() {
    }

    @Given("User navigate for Lenovo Laptop")
    public void userNavigateForLenovoLaptop() {
    }

    @When("Add the laptop to the basket")
    public void addTheLaptopToTheBasket() {
    }
}
