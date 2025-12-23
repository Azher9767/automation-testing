package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAutomationTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
