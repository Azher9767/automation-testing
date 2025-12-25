package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automation.utils.ChromeDriverUtil;

public class BasicAutomationSearch {

    public static void main(String[] args) {

        WebDriver driver = ChromeDriverUtil.getDriver();
        driver.get("https://www.wikipedia.org");

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        System.out.println("Result page title: " + driver.getTitle());
        driver.quit();
    }
}
