package com.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automation.utils.ChromeDriverUtil;

public class BasicAutomation {

    public static void main(String[] args) {

        WebDriver driver = ChromeDriverUtil.getDriver();
        driver.get("https://www.wikipedia.org");
        System.out.println("Page title is: " + driver.getTitle());
        driver.quit();
    }
}
