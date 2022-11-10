package com.cursosdedesarrollo.app.selenium.estructurapaginacompleja;

import org.openqa.selenium.*;

public class PaginaPrincipalPactometro {
    private WebDriver driver;
    WebElement numSies;
    WebElement numAbst;
    WebElement numNoes;

    WebElement noes;

    WebElement botonPP;
    PaginaPrincipalPactometro(WebDriver driver){
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
