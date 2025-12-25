package com.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;
import com.automation.utils.ChromeDriverUtil;

public class AdvancedAutomation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = ChromeDriverUtil.getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1️⃣ DROPDOWN
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        new Select(dropdown).selectByVisibleText("Option 2");

        // 2️⃣ CHECKBOX
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        // 3️⃣ RADIO BUTTON
        driver.get("https://demoqa.com/radio-button");
        WebElement yesRadio = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        wait.until(ExpectedConditions.elementToBeClickable(yesRadio)).click();

        // 4️⃣ ALERT
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // 5️⃣ WINDOWS
        driver.get("https://the-internet.herokuapp.com/windows");
        String parent = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        for (String w : driver.getWindowHandles()) {
            if (!w.equals(parent)) {
                driver.switchTo().window(w);
            }
        }
        driver.close();
        driver.switchTo().window(parent);

        // 6️⃣ EXPLICIT WAIT
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();
        WebElement finish = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );
        System.out.println(finish.getText());

        driver.quit();
        System.out.println("AdvancedAutomation completed successfully");
    }
}
