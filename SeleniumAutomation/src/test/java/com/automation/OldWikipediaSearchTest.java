package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OldWikipediaSearchTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyWikipediaSearch() {
        // Open Wikipedia
        driver.get("https://www.wikipedia.org/");

        // Search for Selenium
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        // Wait until result page is loaded
        wait.until(ExpectedConditions.titleContains("Selenium"));

        // Assertion
        String pageTitle = driver.getTitle();
        Assert.assertTrue(
                pageTitle.contains("Selenium"),
                "Page title does not contain expected text"
        );

        System.out.println("Search successful, title: " + pageTitle);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
