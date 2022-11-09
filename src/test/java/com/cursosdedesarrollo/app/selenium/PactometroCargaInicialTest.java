package com.cursosdedesarrollo.app.selenium;// Generated by Selenium IDE

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class PactometroCargaInicialTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {
    // para windows
    //System.setProperty("webdriver.chrome.driver","c:\\Users\\ruta\\chromedriver.exe");
    driver = new ChromeDriver();
    // configurar un timeout a la hora de localizar elementos HTML presentes
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void pactometroCargaInicial() {
    // Test name: pactometroCargaInicial
    // Step # | name | target | value
    // 1 | open | /pactometro/ | 
    driver.get("https://cursosdedesarrollo.com/pactometro/");
    // 2 | setWindowSize | 1402x1219 | 
    driver.manage().window().setSize(new Dimension(1402, 1219));
    // 3 | assertElementPresent | css=#part-PP > img |
    WebElement elemento = new WebDriverWait(driver, Duration.ofSeconds(10))
            // Espera a un elemento clickable
            //.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#part-PP > img")));
            // Espera a un elemento presente
            .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#part-PP > img")));
    // Elemento cuyo ID es "part-PP"
    elemento = driver.findElement(By.id("part-PP"));
    // Elemento cuyo ID es "part-PP"
    elemento = driver.findElement(By.cssSelector("#part-PP"));
    // Elemento dentro de otro elemento img dentro de elemento por su ID
    elemento = driver.findElement(By.cssSelector("#part-PP > img"));
    // Elemento dentro de otro elemento img dentro de elemento por su ID
    elemento = driver.findElement(By.cssSelector("#part-PP > h2"));
    // System.out.println(elemento.getText());
    assertEquals("89", elemento.getText());
    elemento = driver.findElement(By.id("part-PP"));
    // System.out.println(elemento.getAttribute("data-dipu"));
    assertEquals("89", elemento.getAttribute("data-dipu"));
    // System.out.println(elemento.getAttribute("data-nombre"));
    assertEquals("PP", elemento.getAttribute("data-nombre"));
    // System.out.println(elemento.getAttribute("data-img"));
    assertEquals("logotipo-pp.png", elemento.getAttribute("data-img"));
    System.out.println("class: " + elemento.getAttribute("class"));
    assertEquals("boton-partido", elemento.getAttribute("class"));
    System.out.println("style: " + elemento.getAttribute("style"));
    assertEquals("", elemento.getAttribute("style"));

    List<WebElement> listadoElementos = driver
            .findElements(By.cssSelector("#partidos button"));
    assertEquals(16, listadoElementos.size());
    elemento = listadoElementos.get(0);
    System.out.println(elemento.getTagName());
    System.out.println(elemento.getAttribute("class"));
    listadoElementos = driver.findElements(By.cssSelector(".boton-partido"));
    System.out.println(listadoElementos.size());
    listadoElementos = driver.findElements(By.cssSelector(".boton-partido h2"));
    System.out.println(listadoElementos.size());
    listadoElementos = driver.findElements(By.className("boton-partido"));
    System.out.println(listadoElementos.size());
    listadoElementos = driver.findElements(By.tagName("button"));
    System.out.println(listadoElementos.size());
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("#part-PP > img"));
      assert(elements.size() > 0);
    }
    // 4 | assertElementPresent | css=#part-PSOE > img | 
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("#part-PSOE > img"));
      assert(elements.size() > 0);
    }
    // 5 | assertText | css=#part-Podemos > h2 | 35
    assertEquals("35", driver.findElement(By.cssSelector("#part-Podemos > h2")).getText());
  }
}
