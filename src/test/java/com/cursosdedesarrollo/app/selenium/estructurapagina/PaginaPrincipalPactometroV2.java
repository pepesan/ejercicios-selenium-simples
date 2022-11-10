package com.cursosdedesarrollo.app.selenium.estructurapagina;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class PaginaPrincipalPactometroV2 {
    private WebDriver driver;
    WebElement numSies;
    WebElement numAbst;
    WebElement numNoes;

    WebElement noes;

    WebElement botonPP;
    PaginaPrincipalPactometroV2(WebDriver driver){
        this.driver = driver;
        navegaPagina();
        getElements();
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
