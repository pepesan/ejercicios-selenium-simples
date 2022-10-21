package com.cursosdedesarrollo.app.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ChromeTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {

    }

    @BeforeEach
    public void setupTest() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void test() {
        // Your test code here. For example:

        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        By searchInput = By.id("searchInput");
        driver.findElement(searchInput).sendKeys("Software");
        By searchButton = By.id("searchButton");
        driver.findElement(searchButton).click();

        textToBePresentInElementLocated(By.tagName("body"),
                "Computer software");
    }

}