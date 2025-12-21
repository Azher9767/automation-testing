package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyWikipediaSearch() {

        // 1. Open Wikipedia
        driver.get("https://www.wikipedia.org/");

        // 2. Find search box
        WebElement searchBox = driver.findElement(By.id("searchInput"));

        // 3. Enter search text
        searchBox.sendKeys("Selenium");

        // 4. Submit search
        searchBox.submit();

        // 5. Validate result
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
