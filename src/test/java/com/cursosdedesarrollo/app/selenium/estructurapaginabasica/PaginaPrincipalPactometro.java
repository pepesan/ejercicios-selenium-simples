package com.cursosdedesarrollo.app.selenium.estructurapaginabasica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class PaginaPrincipalPactometro {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    WebElement numSies;
    WebElement numAbst;
    WebElement numNoes;

    WebElement noes;

    WebElement botonPP;
    @BeforeEach
    public void setUp() {
        // para windows
        //System.setProperty("webdriver.chrome.driver","c:\\Users\\ruta\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        navegaPagina();
        getElements();
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    public void navegaPagina(){
        // 1 | open | /pactometro/ |
        driver.get("https://cursosdedesarrollo.com/pactometro/");
        // 2 | setWindowSize | 1402x1219 |
        driver.manage().window().setSize(new Dimension(1402, 1219));
    }
    public void getElements() {
        numSies = driver.findElement(By.id("num-sies"));
        numAbst = driver.findElement(By.id("num-abst"));
        numNoes = driver.findElement(By.id("num-noes"));
        noes = driver.findElement(By.id("noes"));
        botonPP = driver.findElement(By.id("part-PP"));
    }

}
