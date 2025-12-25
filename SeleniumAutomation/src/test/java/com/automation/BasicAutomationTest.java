package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.automation.utils.ChromeDriverUtil;

public class BasicAutomationTest {

    public static void main(String[] args) {
       
        WebDriver  driver = ChromeDriverUtil.getDriver();
        driver.get("https://www.wikipedia.org");

        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
