package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org");
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
