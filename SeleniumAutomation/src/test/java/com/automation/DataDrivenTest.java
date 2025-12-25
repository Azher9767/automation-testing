package com.automation;

import com.automation.utils.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.automation.utils.ChromeDriverUtil;

import java.time.Duration;

public class DataDrivenTest {

    ChromeOptions options;
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = ChromeDriverUtil.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @DataProvider(name = "searchData")
    public Object[][] getData() {
        return ExcelUtil.getExcelData(
                "src/test/resources/TestData.xlsx",
                "SearchData"
        );
    }

    @Test(dataProvider = "searchData")
    public void searchWikipedia(String searchText) {

        driver.get("https://www.wikipedia.org");

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("search"))
        );
        searchBox.sendKeys(searchText);
        searchBox.submit();

        wait.until(ExpectedConditions.or(
                ExpectedConditions.urlContains("/wiki/"),
                ExpectedConditions.urlContains("search")
        ));

        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        System.out.println("Search text: " + searchText);
        System.out.println("Page title: " + title);
        System.out.println("Current URL: " + url);

        Assert.assertTrue(
                title.contains("Wikipedia"),
                "Wikipedia result page did not load"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
