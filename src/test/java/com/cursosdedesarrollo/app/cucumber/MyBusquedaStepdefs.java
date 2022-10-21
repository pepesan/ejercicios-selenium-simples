package com.cursosdedesarrollo.app.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class MyBusquedaStepdefs {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Given("Abro la pagina a buscar")
    public void abro_la_pagina() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://cursosdedesarrollo.com/");
    }
    @When("busco  poniendo {string}")
    public void busco_con_texto(String criterio) {
        // 3 | click | id=wp-block-search__input-1 |
        driver.findElement(By.id("wp-block-search__input-1")).click();
        // 4 | type | id=wp-block-search__input-1 | docker
        driver.findElement(By.id("wp-block-search__input-1")).sendKeys(criterio);
        // 5 | click | css=.wp-block-search__button |
        driver.findElement(By.cssSelector(".wp-block-search__button")).click();
        // 6 | click | css=h1 |
        driver.findElement(By.cssSelector("h1")).click();
    }

    @Then("Encuentro el titulo {string}")
    public void meto_el_valor(String expectedText) {
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.textToBe(By.cssSelector("h1"), expectedText));
        }
        // 8 | assertText | css=h1 | Search results for: docker

        assertEquals("Search results for: docker",driver.findElement(By.cssSelector("h1")).getText());
    }
    @And("Cierro este Navegador")
    public void cierro_navegador(){
        driver.close();
    }

}
