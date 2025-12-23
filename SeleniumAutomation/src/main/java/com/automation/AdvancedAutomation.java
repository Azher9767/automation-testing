package com.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;

public class AdvancedAutomation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ==================================================
        // 1️⃣ DROPDOWN
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Thread.sleep(3000); // pause before locating dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Thread.sleep(3000); // pause before selecting option
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

        System.out.println("Dropdown selected");

        // ==================================================
        // 2️⃣ CHECKBOX
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        Thread.sleep(3000); // pause before locating checkbox
        WebElement checkbox = driver.findElements(
                By.cssSelector("input[type='checkbox']")
        ).get(0);

        Thread.sleep(3000); // pause before clicking checkbox
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        System.out.println("Checkbox selected");

        // ==================================================
        // 3️⃣ ALERT HANDLING
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(3000); // pause before clicking alert button
        WebElement alertButton =
                driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alertButton.click();

        Thread.sleep(3000); // pause before switching to alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());

        Thread.sleep(3000); // pause before accepting alert
        alert.accept();

        // ==================================================
        // 4️⃣ MULTIPLE WINDOWS / TABS
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindow = driver.getWindowHandle();

        Thread.sleep(3000); // pause before opening new window
        driver.findElement(By.linkText("Click Here")).click();

        Thread.sleep(3000); // pause before switching window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }

        System.out.println("New window title: " + driver.getTitle());

        Thread.sleep(3000); // pause before closing child window
        driver.close();
        driver.switchTo().window(parentWindow);

        // ==================================================
        // 5️⃣ EXPLICIT WAIT (DYNAMIC LOADING)
        // ==================================================
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        Thread.sleep(3000); // pause before clicking Start
        driver.findElement(By.cssSelector("#start button")).click();

        Thread.sleep(3000); // pause before waiting for result
        WebElement finishText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );

        System.out.println("Explicit wait text: " + finishText.getText());

        Thread.sleep(3000); // final pause before quit
        driver.quit();

        System.out.println("AdvancedAutomation completed successfully");
    }
}
