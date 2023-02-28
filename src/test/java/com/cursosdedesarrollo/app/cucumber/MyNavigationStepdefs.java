package com.cursosdedesarrollo.app.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class MyNavigationStepdefs {
    private WebDriver driver;
    @Given("Abro la pagina")
    public void abro_la_pagina() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
    }
    @When("busco {string}")
    public void busco_con_texto(String criterio) {
        By searchInput = By.id("searchInput");
        driver.findElement(searchInput).sendKeys(criterio);
        By searchButton = By.cssSelector("button.cdx-search-input__end-button");
        driver.findElement(searchButton).click();
    }

    @Then("Encuentro el texto {string}")
    public void meto_el_valor(String expectedText) {
        textToBePresentInElementLocated(By.tagName("body"),
                expectedText);
    }
    @And("Cierro Navegador")
    public void cierro_navegador(){
        driver.close();
    }

}
