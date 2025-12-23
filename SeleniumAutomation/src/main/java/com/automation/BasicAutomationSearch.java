package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAutomationSearch {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org");

        // Locate search box using NAME
        WebElement searchBox = driver.findElement(By.name("search"));

        // Enter search text
        searchBox.sendKeys("Selenium WebDriver");

        // Submit the form
        searchBox.submit();

        // Print result page title
        System.out.println("Result page title: " + driver.getTitle());

        driver.quit();
    }
}
