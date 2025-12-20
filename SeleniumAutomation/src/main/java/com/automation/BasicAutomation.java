package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // driver.get("https://www.wikipedia.org");
        // System.out.println("Page title is: " + driver.getTitle());
        // driver.quit();

        try {
            // 1. Open Wikipedia
            driver.get("https://www.wikipedia.org");

            // 2. Locate search input (by ID)
            WebElement searchBox = driver.findElement(By.id("searchInput"));

            // 3. Enter search text
            searchBox.sendKeys("Selenium WebDriver");

            // 4. Submit search
            searchBox.submit();

            // 5. Print result page title
            System.out.println("Result Page Title: " + driver.getTitle());

        } finally {
            // 6. Close browser
            driver.quit();
        }
    }
}
